package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

// TODO document/finalise

public class BootstrapThumbnail extends BootstrapBaseThumbnail implements RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapThumbnail";

    private boolean roundedCorners;

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

    private void initialise(AttributeSet attrs) {
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
        updateImageState();
    }

    protected void updateImageState() {
        // TODO update image
    }

    /*
     * Getters/setters
     */

    @Override public void setRounded(boolean rounded) {
        this.roundedCorners = rounded;
    }

    @Override public boolean isRounded() {
        return roundedCorners;
    }

}
