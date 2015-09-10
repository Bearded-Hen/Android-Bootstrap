package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.beardedhen.androidbootstrap.api.view.ProgressView;

public class BootstrapProgressBar extends View implements ProgressView {

    // see http://stackoverflow.com/questions/13964520

    private Paint progressPaint;
    private Paint bgPaint;

    private int progress;
    private boolean striped;
    private boolean animated;

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
        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setColor(Color.BLUE);

        bgPaint = new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(Color.GRAY);

        setProgress(40);
    }

    @Override public void setProgress(int progress) {
        if (progress < 0 || progress > 100) {
            String s = String.format("Invalid value '%d' - progress must be an integer in the range 0-100", progress);
            throw new RuntimeException(s);
        }

        this.progress = progress;
        invalidate();
    }

    @Override public int getProgress() {
        return progress;
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

    @Override protected void onDraw(Canvas canvas) {
        float w = getWidth();
        float h = getHeight();

        float ratio = (float) (progress / 100.0);
        int lineEnd = (int) (w * ratio);

        canvas.drawRect(0, 0, lineEnd, h, progressPaint);
        canvas.drawRect(lineEnd, 0, w, h, bgPaint);
    }

}
