package com.beardedhen.androidbootstrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.ProgressView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

import java.io.Serializable;

import static android.graphics.Bitmap.Config.ARGB_8888;

/**
 * BootstrapProgressBar displays determinate progress to the user, and is colored with BootstrapBrands.
 * Striped effects and progress update animations are supported out of the box.
 *
 * Its possible to group multiple together in an {@link com.beardedhen.androidbootstrap.BootstrapProgressBarGroup BootstrapProgressBarGroup} to give the appearance of a <a href="http://getbootstrap.com/components/#progress-stacked">stacked</a> progressbar.
 */
public class BootstrapProgressBar extends View implements ProgressView, BootstrapBrandView,
        RoundableView, BootstrapSizeView, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    private static final String TAG = "com.beardedhen.androidbootstrap.AwesomeTextView";

    private static final long UPDATE_ANIM_MS = 300;
    private static final int STRIPE_ALPHA = 150;
    private static final long STRIPE_CYCLE_MS = 1500;

    private Paint progressPaint;
    private Paint stripePaint;
    private Paint bgPaint;
    private Paint textPaint;

    private int userProgress;
    private int drawnProgress;

    private int maxProgress;

    private boolean striped;
    private boolean animated;
    private boolean rounded;

    //used for progressbarGroup so that only the currect corners will be rounded
    private boolean canRoundLeft = true;
    private boolean canRoundRight = true;

    private ValueAnimator progressAnimator;
    private Paint tilePaint;
    private final float baselineHeight = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_progress_bar_height);

    private BootstrapBrand bootstrapBrand;

    private Canvas progressCanvas;
    private Bitmap progressBitmap;
    private Bitmap stripeTile;

    private float bootstrapSize;
    private boolean showPercentage;

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

        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setAntiAlias(true);

        stripePaint = new Paint();
        stripePaint.setStyle(Paint.Style.FILL);
        stripePaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setColor(ColorUtils.resolveColor(android.R.color.black, getContext()));
        textPaint.setTextSize(DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_progress_bar_default_font_size));

        bgPaint = new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(ColorUtils.resolveColor(R.color.bootstrap_gray_light, getContext()));

        // get attributes
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapProgressBar);

        try {
            this.animated = a.getBoolean(R.styleable.BootstrapProgressBar_animated, false);
            this.rounded = a.getBoolean(R.styleable.BootstrapProgressBar_roundedCorners, false);
            this.striped = a.getBoolean(R.styleable.BootstrapProgressBar_striped, false);
            this.showPercentage = a.getBoolean(R.styleable.BootstrapProgressBar_bootstrapshowPercentage, false);
            this.userProgress = a.getInt(R.styleable.BootstrapProgressBar_bootstrapProgress, 0);
            this.maxProgress = a.getInt(R.styleable.BootstrapProgressBar_bootstrapMaxProgress, 100);

            int typeOrdinal = a.getInt(R.styleable.BootstrapProgressBar_bootstrapBrand, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapProgressBar_bootstrapSize, -1);

            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
            this.drawnProgress = userProgress;
        } finally {
            a.recycle();
        }

        textPaint.setColor(bootstrapBrand.defaultTextColor(getContext()));
        textPaint.setTextSize((DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_button_default_font_size)) * this.bootstrapSize );
        updateBootstrapState();
        setProgress(this.userProgress);
        setMaxProgress(this.maxProgress);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putInt(KEY_USER_PROGRESS, userProgress);
        bundle.putInt(KEY_DRAWN_PROGRESS, drawnProgress);
        bundle.putBoolean(KEY_STRIPED, striped);
        bundle.putBoolean(KEY_ANIMATED, animated);
        bundle.putBoolean(RoundableView.KEY, rounded);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);

            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }

            this.userProgress = bundle.getInt(KEY_USER_PROGRESS);
            this.drawnProgress = bundle.getInt(KEY_DRAWN_PROGRESS);
            this.striped = bundle.getBoolean(KEY_STRIPED);
            this.animated = bundle.getBoolean(KEY_ANIMATED);
            this.rounded = bundle.getBoolean(RoundableView.KEY);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

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

        progressAnimator.addUpdateListener(this);

        // start striped animation after progress update if needed
        progressAnimator.addListener(this);
        progressAnimator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        drawnProgress = (int) ((float) animation.getAnimatedValue());
        invalidate();
    }

    @Override
    public void onAnimationStart(Animator animation) {
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        startStripedAnimationIfNeeded(); // start striped animation after progress update
    }

    @Override
    public void onAnimationCancel(Animator animation) {
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
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
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        progressAnimator.start();
    }

    /*
     * Custom Measuring/Drawing
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // restrict view to default progressbar height

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST: // prefer default height, if not all available use as much as possible
                float desiredHeight = (baselineHeight * bootstrapSize);
                height = (height > desiredHeight) ? (int) desiredHeight : height;
                break;
            default:
                height = (int) (baselineHeight * bootstrapSize);
                break;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (h != oldh) {
            stripeTile = null; // dereference cached bitmap
        }

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float w = getWidth();
        float h = getHeight();

        if (w <= 0 || h <= 0) {
            return;
        }

        if (progressBitmap == null) {
            progressBitmap = Bitmap.createBitmap((int) w, (int) h, ARGB_8888);
        }
        if (progressCanvas == null) {
            progressCanvas = new Canvas(progressBitmap);
        }
        progressCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        float ratio = (drawnProgress / (float) maxProgress);
        int lineEnd = (int) (w * ratio);

        float offset = 0;
        float offsetFactor = (System.currentTimeMillis() % STRIPE_CYCLE_MS) / (float) STRIPE_CYCLE_MS;

        if (striped && animated) { // determine offset for current animation frame of progress bar
            offset = (h * 2) * offsetFactor;
        }

        if (striped) { // draw a regular striped bar
            if (stripeTile == null) {
                stripeTile = createTile(h, stripePaint, progressPaint);
            }

            float start = 0 - offset;

            while (start < lineEnd) { // FIXME
                progressCanvas.drawBitmap(stripeTile, start, 0, tilePaint);
                start += stripeTile.getWidth();
            }
        }
        else { // draw a filled bar
            progressCanvas.drawRect(0, 0, lineEnd, h, progressPaint);
        }

        progressCanvas.drawRect(lineEnd, 0, w, h, bgPaint); // draw bg

        float corners = rounded ? h / 2 : 0;
        Bitmap round = createRoundedBitmap(progressBitmap, corners, canRoundRight, canRoundLeft);
        canvas.drawBitmap(round, 0, 0, tilePaint);

        if(showPercentage) {
            String percent = getProgress() + "%";
            int xPos = (lineEnd / 2);
            xPos = xPos - (int) (textPaint.measureText(percent) / 2);
            int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));
            //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.

            canvas.drawText(percent, xPos, yPos, textPaint);
        }
    }

    /**
     * Creates a Bitmap which is a tile of the progress bar background
     *
     * @param h the view height
     * @return a bitmap of the progress bar background
     */
    private static Bitmap createTile(float h, Paint stripePaint, Paint progressPaint) {
        Bitmap bm = Bitmap.createBitmap((int) h * 2, (int) h, ARGB_8888);
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

    /**
     * Creates a rounded bitmap with transparent corners, from a square bitmap.
     * See <a href="http://stackoverflow.com/questions/4028270">StackOverflow</a>
     *
     * @param bitmap       the original bitmap
     * @param cornerRadius the radius of the corners
     * @param roundRight if you should round the corners on the right, note that if set to true and cornerRadius == 0 it will create a square
     * @param roundLeft if you should round the corners on the right, note that if set to true and cornerRadius == 0 it will create a square
     * @return a rounded bitmap
     */
    private static Bitmap createRoundedBitmap(Bitmap bitmap, float cornerRadius, boolean roundRight, boolean  roundLeft) {
        Bitmap roundedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), ARGB_8888);
        Canvas canvas = new Canvas(roundedBitmap);

        final Paint paint = new Paint();
        final Rect frame = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

//        final Rect frameLeft = new Rect(0, 0, bitmap.getWidth() /2, bitmap.getHeight());
//        final Rect frameRight = new Rect(bitmap.getWidth() /2, bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight());

        final Rect leftRect = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight());
        final Rect rightRect = new Rect(bitmap.getWidth() / 2, 0, bitmap.getWidth(), bitmap.getHeight());

        // prepare canvas for transfer
        paint.setAntiAlias(true);
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawARGB(0, 0, 0, 0);

        canvas.drawRoundRect(new RectF(frame), cornerRadius, cornerRadius, paint);

        if (!roundLeft){
            canvas.drawRect(leftRect, paint);
        }

        if (!roundRight){
            canvas.drawRect(rightRect, paint);
        }
        // draw bitmap
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, frame, frame, paint);

        return roundedBitmap;
    }

    private void updateBootstrapState() {
        int color = bootstrapBrand.defaultFill(getContext());
        progressPaint.setColor(color);
        stripePaint.setColor(getStripeColor(color));
        invalidateDrawCache();
        invalidate();
    }

    private void invalidateDrawCache() {
        stripeTile = null;
        progressBitmap = null;
        progressCanvas = null;
    }

    /*
     * Getters/Setters
     */


    @SuppressLint("DefaultLocale")
    @Override
    public void setProgress(int progress) {
        if (getParent() instanceof BootstrapProgressBarGroup){
            this.userProgress = 0;
            setMaxProgress(progress);
        }else {
            if (progress < 0 || progress > maxProgress) {
                throw new IllegalArgumentException(
                        String.format("Invalid value '%d' - progress must be an integer in the range 0-%d", progress, maxProgress));
            }
        }

        this.userProgress = progress;

        if (animated) {
            startProgressUpdateAnimation();
        }
        else {
            this.drawnProgress = progress;
            invalidate();
        }

        ViewParent parent = getParent();
        if (parent != null) {
            if (parent instanceof BootstrapProgressBarGroup) {
                BootstrapProgressBarGroup parentGroup = (BootstrapProgressBarGroup) parent;
                parentGroup.onProgressChanged(this);
            }
        }
    }

    @Override
    public int getProgress() {
        return userProgress;
    }

    @Override
    public void setStriped(boolean striped) {
        this.striped = striped;
        invalidate();
        startStripedAnimationIfNeeded();
    }

    @Override
    public boolean isStriped() {
        return striped;
    }

    @Override
    public void setAnimated(boolean animated) {
        this.animated = animated;
        invalidate();
        startStripedAnimationIfNeeded();
    }

    @Override
    public boolean isAnimated() {
        return animated;
    }

    @Override
    public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        textPaint.setColor(bootstrapBrand.defaultTextColor(getContext()));
        updateBootstrapState();
    }

    @NonNull
    @Override
    public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override
    public void setRounded(boolean rounded) {
        this.rounded = rounded;
        updateBootstrapState();
    }

    @Override
    public boolean isRounded() {
        return rounded;
    }

    @Override
    public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override
    public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        textPaint.setTextSize((DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_progress_bar_default_font_size)) * this.bootstrapSize );
        requestLayout();
        updateBootstrapState();
    }

    @Override
    public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

    /**
     *
     * @return int, the max progress.
     */
    public int getMaxProgress() {
        return maxProgress;
    }

    /**
     * Used for settings the maxprogress. Also check if currentProgress is smaller than newMaxProgress.
     * @param newMaxProgress the maxProgress value
     */
    public void setMaxProgress(int newMaxProgress) {
        if (getProgress() <= newMaxProgress) {
            maxProgress = newMaxProgress;
        }
        else {
            throw new IllegalArgumentException(
                    String.format("MaxProgress cant be smaller than the current progress %d<%d", getProgress(), newMaxProgress));
        }
        invalidate();
        BootstrapProgressBarGroup parent = (BootstrapProgressBarGroup) getParent();
    }

    void setCornerRounding(boolean left, boolean right){
        canRoundLeft = left;
        canRoundRight = right;
    }

    boolean getCornerRoundingLeft(){
        return canRoundLeft;
    }

    boolean getCornerRoundingRight(){
        return canRoundRight;
    }
}
