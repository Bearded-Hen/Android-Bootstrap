package com.beardedhen.androidbootstrap;

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

public class BootstrapProgressBar extends View implements ProgressView, ValueAnimator.AnimatorUpdateListener {

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

        if (animated) {
            clearAnimation();
            ValueAnimator.setFrameDelay(15); // attempt 60fps

            progressAnimator = ValueAnimator.ofFloat(drawnProgress, userProgress);
            progressAnimator.setDuration(ANIMATOR_PROGRESS_MS);
            progressAnimator.setInterpolator(new DecelerateInterpolator());
            progressAnimator.addUpdateListener(this);
            progressAnimator.start();
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

    @Override public void onAnimationUpdate(ValueAnimator animation) {
        this.drawnProgress = (int) ((float) animation.getAnimatedValue());
        invalidate();
    }

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

        this.striped = true;// FIXME

        // TODO animated stripes should have an infinite ValueAnimator, offset the bitmap position here

        if (striped) {

            if (stripeTile == null) {
                stripeTile = createTile(h);
            }

            Paint paint = new Paint();
            float start = 0;

            while (start < lineEnd) {
                canvas.drawBitmap(stripeTile, start, 0, paint);
                start += stripeTile.getHeight() * 2;
            }
        }
        else {
            canvas.drawRect(0, 0, lineEnd, h, progressPaint);
        }
        canvas.drawRect(lineEnd, 0, w, h, bgPaint);
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
