package com.beardedhen.androidbootstrap;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.BorderView;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

import java.io.Serializable;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

/**
 * Parent class of Circle and Square Thumbnails - contains boilerplate code required to get
 * BootstrapBrand and borders working via getters/setters. Also overrides ImageView so that only
 * CENTER_CROP is allowed, and a callback is fired whenever the image source changes.
 */
abstract class BootstrapBaseThumbnail extends ImageView implements BootstrapBrandView,
        BorderView, BootstrapSizeView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapBaseThumbnail";

    protected BootstrapBrand bootstrapBrand;
    protected boolean hasBorder;

    protected float baselineBorderWidth;
    protected float baselineOuterBorderWidth;

    protected float bootstrapSize;

    protected Bitmap sourceBitmap;
    protected final Paint placeholderPaint = new Paint();
    protected final Paint borderPaint = new Paint();
    protected final Paint imagePaint = new Paint();

    public BootstrapBaseThumbnail(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapBaseThumbnail(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapBaseThumbnail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    protected void initialise(AttributeSet attrs) {
        this.baselineOuterBorderWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bthumbnail_outer_stroke);
        this.baselineBorderWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bthumbnail_default_border);
        setupPaints();
        updateImageState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putSerializable(BootstrapBrandView.KEY, bootstrapBrand);
        bundle.putBoolean(BorderView.KEY_DISPLAYED, hasBorder);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.hasBorder = bundle.getBoolean(BorderView.KEY_DISPLAYED);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

            Serializable brand = bundle.getSerializable(BootstrapBrandView.KEY);

            if (brand instanceof BootstrapBrand) {
                this.bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateImageState();
    }

    private void setupPaints() {
        int strokeColor = bootstrapBrand.defaultEdge(getContext());
        int placeholderColor = ColorUtils.resolveColor(R.color.bootstrap_gray_light, getContext());

        borderPaint.setColor(strokeColor);
        borderPaint.setAntiAlias(true);
        borderPaint.setStrokeWidth(baselineBorderWidth);
        borderPaint.setStyle(Paint.Style.STROKE);
        imagePaint.setAntiAlias(true);

        placeholderPaint.setColor(placeholderColor);
        placeholderPaint.setAntiAlias(true);
        placeholderPaint.setStyle(Paint.Style.FILL);
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateImageState();
    }

    @Override public void setScaleType(ScaleType scaleType) {
        if (scaleType != CENTER_CROP) {
            throw new IllegalArgumentException("Only CenterCrop is currently supported by this view");
        }
        else {
            super.setScaleType(scaleType);
        }
    }

    @Override public ScaleType getScaleType() {
        return CENTER_CROP;
    }

    /**
     * @return the original Bitmap source that will be drawn as a circular image
     */
    @Nullable private Bitmap getBitmapForView() {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        else {
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();

            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawable.draw(new Canvas(bm));
            return bm;
        }
    }

    /*
     * Image setter overrides
     */

    @Override public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.sourceBitmap = bm;
        updateImageState();
    }

    @Override public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.sourceBitmap = getBitmapForView();
        updateImageState();
    }

    @Override public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.sourceBitmap = getBitmapForView();
        updateImageState();
    }

    @Override public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.sourceBitmap = getBitmapForView();
        updateImageState();
    }

    /**
     * Called when the ImageView should alter its source bitmap, then invalidate itself.
     */
    protected abstract void updateImageState();

    /*
     * Getters/Setters
     */

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateImageState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @TargetApi(16) @Override public void setBorderDisplayed(boolean displayed) {
        this.hasBorder = displayed;
        updateImageState();
    }

    @Override public boolean isBorderDisplayed() {
        return hasBorder;
    }

    @Override public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateImageState();
    }

    @Override public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

}