package com.beardedhen.androidbootstrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.ProgressView;

import java.io.Serializable;

// TODO document/finalise
// TODO rounded corners

public class BootstrapProgressBar extends View implements ProgressView, BootstrapBrandView {

    private static final String TAG = "com.beardedhen.androidbootstrap.AwesomeTextView";

    private static final long UPDATE_ANIM_MS = 300;
    private static final int STRIPE_ALPHA = 150;

    private static final long STRIPE_CYCLE_MS = 1500;

    private Paint progressPaint;
    private Paint stripePaint;
    private Paint bgPaint;

    private int userProgress;
    private int drawnProgress;

    private boolean striped;
    private boolean animated;

    private ValueAnimator progressAnimator;
    private Bitmap stripeTile;
    private Paint tilePaint;
    private int defaultHeight;

    private BootstrapBrand bootstrapBrand;

    public BootstrapProgressBar(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        ValueAnimator.setFrameDelay(15); // attempt 60fps
        tilePaint = new Paint();
        Resources res = getContext().getResources();
        defaultHeight = res.getDimensionPixelSize(R.dimen.bootstrap_progress_bar_height);

        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setAntiAlias(true);

        stripePaint = new Paint();
        stripePaint.setStyle(Paint.Style.FILL);
        stripePaint.setAntiAlias(true);

        bgPaint = new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(getContext().getResources().getColor(R.color.bootstrap_gray_lighter));

        // get attributes
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapProgressBar);

        try {
            this.animated = a.getBoolean(R.styleable.BootstrapProgressBar_animated, false);
            this.striped = a.getBoolean(R.styleable.BootstrapProgressBar_striped, false);
            this.userProgress = a.getInt(R.styleable.BootstrapProgressBar_progress, 0);

            int typeOrdinal = a.getInt(R.styleable.AwesomeTextView_bootstrapBrand, -1);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
            this.drawnProgress = userProgress;
        }
        finally {
            a.recycle();
        }

        updateBootstrapState();
        setProgress(this.userProgress);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putInt(KEY_USER_PROGRESS, userProgress);
        bundle.putInt(KEY_DRAWN_PROGRESS, drawnProgress);
        bundle.putBoolean(KEY_STRIPED, striped);
        bundle.putBoolean(KEY_ANIMATED, animated);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);

            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }

            userProgress = bundle.getInt(KEY_USER_PROGRESS);
            drawnProgress = bundle.getInt(KEY_DRAWN_PROGRESS);
            striped = bundle.getBoolean(KEY_STRIPED);
            animated = bundle.getBoolean(KEY_ANIMATED);

            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
        setProgress(userProgress);
    }

    private int getStripeColor(@ColorInt int color) {
        return Color.argb(STRIPE_ALPHA, Color.red(color), Color.green(color), Color.blue(color));
    }

    /**
     * Starts an animation which moves the progress bar from one value to another, in response to
     * a call to setProgress(). Animation update callbacks allow the interpolator value to be used
     * to calculate the current progress value, which is stored in a temporary variable. The view is
     * then invalidated.
     * <p/>
     * If this method is called when a progress update animation is already running, the previous
     * animation will be cancelled, and the currently drawn progress recorded. A new animation will
     * then be started from the last drawn point.
     */
    private void startProgressUpdateAnimation() {
        clearAnimation();

        progressAnimator = ValueAnimator.ofFloat(drawnProgress, userProgress);
        progressAnimator.setDuration(UPDATE_ANIM_MS);
        progressAnimator.setRepeatCount(0);
        progressAnimator.setRepeatMode(ValueAnimator.RESTART);

        progressAnimator.setInterpolator(new DecelerateInterpolator());

        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override public void onAnimationUpdate(ValueAnimator animation) {
                drawnProgress = (int) ((float) animation.getAnimatedValue());
                invalidate();
            }
        });

        // start striped animation after progress update if needed
        progressAnimator.addListener(new Animator.AnimatorListener() {
            @Override public void onAnimationStart(Animator animation) {
            }

            @Override public void onAnimationEnd(Animator animation) {
                startStripedAnimationIfNeeded(); // start striped animation after progress update
            }

            @Override public void onAnimationCancel(Animator animation) {
            }

            @Override public void onAnimationRepeat(Animator animation) {
            }
        });
        progressAnimator.start();
    }

    /**
     * Starts an infinite animation cycle which provides the visual effect of stripes moving
     * backwards. The current system time is used to offset tiled bitmaps of the progress background,
     * producing the effect that the stripes are moving backwards.
     */
    private void startStripedAnimationIfNeeded() {
        if (!striped || !animated) {
            return;
        }

        clearAnimation();

        progressAnimator = ValueAnimator.ofFloat(0, 0);
        progressAnimator.setDuration(UPDATE_ANIM_MS);
        progressAnimator.setRepeatCount(ValueAnimator.INFINITE);
        progressAnimator.setRepeatMode(ValueAnimator.RESTART);

        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        progressAnimator.start();
    }

    /*
     * Custom Measuring/Drawing
     */

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // restrict view to default progressbar height

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST: // prefer default height, if not all available use as much as possible
                height = (height > defaultHeight) ? defaultHeight : height;
                break;
            default:
                height = defaultHeight;
                break;
        }
        setMeasuredDimension(width, height);
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (h != oldh) {
            stripeTile = null; // dereference cached bitmap
        }

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override protected void onDraw(Canvas canvas) {
        float w = getWidth();
        float h = getHeight();

        float ratio = (float) (drawnProgress / 100.0);
        int lineEnd = (int) (w * ratio);

        float offset = 0;
        float offsetFactor = (System.currentTimeMillis() % STRIPE_CYCLE_MS) / (float) STRIPE_CYCLE_MS;

        if (striped && animated) { // determine offset for current animation frame of progress bar
            offset = (h * 2) * offsetFactor;
        }

        if (striped) { // draw a regular striped bar
            if (stripeTile == null) {
                stripeTile = createTile(h);
            }

            float start = 0 - offset;

            while (start < lineEnd) {
                // TODO investigate caching everything apart from the edges as a bitmap rather than tiling

                canvas.drawBitmap(stripeTile, start, 0, tilePaint);
                start += stripeTile.getHeight() * 2;
            }
        }
        else { // draw a filled bar
            canvas.drawRect(0, 0, lineEnd, h, progressPaint);
        }
        canvas.drawRect(lineEnd, 0, w, h, bgPaint); // draw bg
    }

    /**
     * Creates a Bitmap which is a tile of the progress bar background
     *
     * @param h the view height
     * @return a bitmap of the progress bar background
     */
    private Bitmap createTile(float h) {
        Bitmap bm = Bitmap.createBitmap((int) h * 2, (int) h, Bitmap.Config.ARGB_8888);
        Canvas tile = new Canvas(bm);

        float x = 0;
        Path path = new Path();

        path.moveTo(x, 0);
        path.lineTo(x, h);
        path.lineTo(h, h);
        tile.drawPath(path, stripePaint); // draw striped triangle

        path.reset();
        path.moveTo(x, 0);
        path.lineTo(x + h, h);
        path.lineTo(x + (h * 2), h);
        path.lineTo(x + h, 0);
        tile.drawPath(path, progressPaint); // draw progress parallelogram

        x += h;
        path.reset();
        path.moveTo(x, 0);
        path.lineTo(x + h, 0);
        path.lineTo(x + h, h);
        tile.drawPath(path, stripePaint); // draw striped triangle (completing tile)

        return bm;
    }

    private void updateBootstrapState() {
        int color = bootstrapBrand.color(getContext());
        progressPaint.setColor(color);
        stripePaint.setColor(getStripeColor(color));
        stripeTile = null;
        invalidate();
    }


    /*
     * Getters/Setters
     */


    @Override public void setProgress(int progress) {
        if (progress < 0 || progress > 100) {
            String s = String.format("Invalid value '%d' - progress must be an integer in the range 0-100", progress);
            throw new IllegalArgumentException(s);
        }

        this.userProgress = progress;

        if (animated) {
            startProgressUpdateAnimation();
        }
        else {
            this.drawnProgress = progress;
            invalidate();
        }
    }

    @Override public int getProgress() {
        return userProgress;
    }

    @Override public void setStriped(boolean striped) {
        this.striped = striped;
        invalidate();
        startStripedAnimationIfNeeded();
    }

    @Override public boolean isStriped() {
        return striped;
    }

    @Override public void setAnimated(boolean animated) {
        this.animated = animated;
        invalidate();
        startStripedAnimationIfNeeded();
    }

    @Override public boolean isAnimated() {
        return animated;
    }

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

}
