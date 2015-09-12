package com.beardedhen.androidbootstrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.beardedhen.androidbootstrap.api.view.ProgressView;

public class BootstrapProgressBar extends View implements ProgressView,
        ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    // see http://stackoverflow.com/questions/13964520

    private static final long ANIMATOR_PROGRESS_MS = 500;

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
        this.userProgress = 0;
        this.drawnProgress = 0;

        int b = Color.BLUE;

        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setColor(Color.argb(255, Color.red(b), Color.green(b), Color.blue(b)));
        progressPaint.setAntiAlias(true);

        stripePaint = new Paint();
        stripePaint.setStyle(Paint.Style.FILL);
        stripePaint.setColor(Color.argb(150, Color.red(b), Color.green(b), Color.blue(b)));
        stripePaint.setAntiAlias(true);

        bgPaint = new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(Color.GRAY);

        tilePaint = new Paint();

        invalidate();
    }

    @Override public void setProgress(int progress) {
        if (progress < 0 || progress > 100) {
            String s = String.format("Invalid value '%d' - progress must be an integer in the range 0-100", progress);
            throw new RuntimeException(s);
        }

        this.drawnProgress = userProgress; // previously set value
        this.userProgress = progress;

        this.animated = true; // FIXME
        this.striped = true;

        if (animated) {
            startProgressAnimation(false);
        }
        else {
            this.drawnProgress = progress;
            invalidate();
        }
    }

    /**
     *
     * @param infinite whether the animation should repeat endlessly
     */
    private void startProgressAnimation(boolean infinite) {
        clearAnimation();
        ValueAnimator.setFrameDelay(15); // attempt 60fps

        // start == userProgress if repeating the animation infinitely (striped animation effect)
        float start = infinite ? userProgress : drawnProgress;
        progressAnimator = ValueAnimator.ofFloat(start, userProgress);

        progressAnimator.setDuration(ANIMATOR_PROGRESS_MS);
        progressAnimator.setRepeatCount(infinite ? ValueAnimator.INFINITE : 0);
        progressAnimator.setRepeatMode(ValueAnimator.RESTART);

        progressAnimator.setInterpolator(new DecelerateInterpolator());
        progressAnimator.addUpdateListener(this);
        progressAnimator.addListener(this);
        progressAnimator.start();
    }

    @Override public int getProgress() {
        return userProgress;
    }

    @Override public void setStriped(boolean striped) {
        this.striped = striped;
    }

    @Override public boolean isStriped() {
        return striped;
    }

    @Override public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    @Override public boolean isAnimated() {
        return animated;
    }

    // TODO theme colors


    /*
     * Animation Listener Callbacks
     */

    @Override public void onAnimationUpdate(ValueAnimator animation) {
        this.drawnProgress = (int) ((float) animation.getAnimatedValue());
        invalidate();
    }

    @Override public void onAnimationStart(Animator animation) {

    }

    @Override public void onAnimationEnd(Animator animation) {
        if (striped && animated) {
            startProgressAnimation(true);
        }
    }

    @Override public void onAnimationCancel(Animator animation) {

    }

    @Override public void onAnimationRepeat(Animator animation) {

    }

    /*
     * Custom Measuring/Drawing
     */

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // restrict view to default progressbar height

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int defaultHeight = 30; // FIXME populate from dimens

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

        // TODO animated stripes should have an infinite ValueAnimator, offset the bitmap position here

        if (striped && animated) { // determine offset for current animation frame of progress bar
            float offsetFactor = (float) ((System.currentTimeMillis() % 1500) / 1500.0);
            offset = (h * 2) * offsetFactor;
        }

        if (striped) { // draw a regular striped bar
            if (stripeTile == null) {
                stripeTile = createTile(h);
            }

            float start = 0 - offset;

            while (start < lineEnd) {
                canvas.drawBitmap(stripeTile, start, 0, tilePaint);
                start += stripeTile.getHeight() * 2;
            }
        }
        else { // draw a filled bar
            canvas.drawRect(0, 0, lineEnd, h, progressPaint);
        }
        canvas.drawRect(lineEnd, 0, w, h, bgPaint); // draw bg
    }

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


}
