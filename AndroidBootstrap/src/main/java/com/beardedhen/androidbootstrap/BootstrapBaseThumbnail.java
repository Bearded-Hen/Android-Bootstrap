package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BorderView;

import java.io.Serializable;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

/**
 * Parent class of Circle & Square Thumbnails - contains boilerplate code required to get
 * BootstrapBrand & borders working via getters/setters. Also overrides ImageView so that only
 * CENTER_CROP is allowed, and a callback is fired whenever the image source changes.
 */
abstract class BootstrapBaseThumbnail extends ImageView implements BootstrapBrandView, BorderView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapBaseThumbnail";

    protected BootstrapBrand bootstrapBrand;
    protected float borderWidth;
    protected int borderColor;

    protected Bitmap sourceBitmap;

    public BootstrapBaseThumbnail(Context context) {
        super(context);
    }

    public BootstrapBaseThumbnail(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BootstrapBaseThumbnail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putSerializable(BootstrapBrandView.KEY, bootstrapBrand);
        bundle.putFloat(BorderView.KEY_WIDTH, borderWidth);
        bundle.putInt(BorderView.KEY_COLOR, borderColor);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.borderWidth = bundle.getFloat(BorderView.KEY_WIDTH);
            this.borderColor = bundle.getInt(BorderView.KEY_COLOR);

            Serializable brand = bundle.getSerializable(BootstrapBrandView.KEY);

            if (brand instanceof BootstrapBrand) {
                this.bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateImageState();
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

    protected abstract void updateImageState();

    /*
     * Getters/Setters
     */

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        this.borderColor = -1;
        invalidate();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override @ColorInt public int getBorderColor() {
        return borderColor;
    }

    @Override public void setBorderColor(@ColorInt int borderColor) {
        this.borderColor = borderColor;
        invalidate();
    }

    @Override public float getBorderWidth() {
        return borderWidth;
    }

    @Override public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        updateImageState();
    }

}