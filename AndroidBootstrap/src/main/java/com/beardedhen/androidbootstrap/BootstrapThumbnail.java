package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

// TODO document/finalise

public class BootstrapThumbnail extends BootstrapBaseThumbnail implements RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapThumbnail";

    private boolean roundedCorners;
    private float cornerRadius;

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
            this.hasBorder = a.getBoolean(R.styleable.BootstrapCircleThumbnail_hasBorder, true);

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
        this.cornerRadius = getResources().getDimension(R.dimen.bthumbnail_rounded_corner);
        setScaleType(ScaleType.CENTER_CROP);
        setPadding(20, 20, 20, 20);
        setCropToPadding(true);
        super.initialise(attrs);
    }

    protected void updateImageState() {
        updateBackground();
        invalidate();
    }

    private void updateBackground() {
        Drawable bg = null;

        if (hasBorder) {
            bg = BootstrapDrawableFactory.bootstrapThumbnail(
                    getContext(),
                    bootstrapBrand,
                    (int) outerBorderWidth,
                    getResources().getColor(R.color.bthumbnail_background),
                    roundedCorners);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
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
