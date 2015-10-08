package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.ColorUtils;

// TODO document/finalise

public class BootstrapThumbnail extends BootstrapBaseThumbnail implements RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapThumbnail";

    private Paint placeholderPaint;
    private final RectF imageRect = new RectF();

    private boolean roundedCorners;
    private float baselineCornerRadius;

    public BootstrapThumbnail(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapThumbnail(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapThumbnail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
    }

    protected void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapThumbnail);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapThumbnail_bootstrapBrand, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapThumbnail_bootstrapSize, -1);

            this.hasBorder = a.getBoolean(R.styleable.BootstrapCircleThumbnail_hasBorder, true);
            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();

            if (typeOrdinal == -1) { // override to use Primary for default border (looks nicer)
                this.bootstrapBrand = DefaultBootstrapBrand.PRIMARY;
            }
            else {
                this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
            }
        }
        finally {
            a.recycle();
        }

        placeholderPaint = new Paint();
        placeholderPaint.setColor(ColorUtils.resolveColor(R.color.bootstrap_gray_light, getContext()));
        placeholderPaint.setStyle(Paint.Style.FILL);
        placeholderPaint.setAntiAlias(true);

        this.baselineCornerRadius = getResources().getDimension(R.dimen.bthumbnail_rounded_corner);
        this.baselineBorderWidth = getResources().getDimension(R.dimen.bthumbnail_default_border);
        setScaleType(ScaleType.CENTER_CROP);

        super.initialise(attrs);
    }

    protected void updateImageState() {
        updateBackground();
        updatePadding();
        invalidate();
    }

    private void updateBackground() {
        Drawable bg = null;

        if (hasBorder) {
            bg = BootstrapDrawableFactory.bootstrapThumbnail(
                    getContext(),
                    bootstrapBrand,
                    (int) (baselineOuterBorderWidth * bootstrapSize),
                    ColorUtils.resolveColor(R.color.bootstrap_thumbnail_background, getContext()),
                    roundedCorners);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

    private void updatePadding() {
        if (Build.VERSION.SDK_INT >= 16) {
            int p = hasBorder ? (int) (baselineBorderWidth * bootstrapSize) : 0;
            setPadding(p, p, p, p);
            setCropToPadding(hasBorder);
        }
    }

    @Override protected void onDraw(Canvas canvas) {
        if (sourceBitmap == null) { // draw a placeholder

            float padding = hasBorder ? (baselineBorderWidth * bootstrapSize) : 0;
            imageRect.top = padding;
            imageRect.bottom = getHeight() - padding;
            imageRect.left = padding;
            imageRect.right = getWidth() - padding;

            if (roundedCorners) {
                canvas.drawRoundRect(
                        imageRect,
                        (baselineCornerRadius * bootstrapSize),
                        (baselineCornerRadius * bootstrapSize),
                        placeholderPaint);
            }
            else {
                canvas.drawRect(imageRect, placeholderPaint);
            }
        }
        else {
            super.onDraw(canvas);
        }
    }

    /*
     * Getters/setters
     */

    @Override public void setRounded(boolean rounded) {
        this.roundedCorners = rounded;
        updateImageState();
    }

    @Override public boolean isRounded() {
        return roundedCorners;
    }

}
