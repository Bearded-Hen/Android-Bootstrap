package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

// TODO document/finalise/update to v4 spec

public class BootstrapEditText extends EditText implements BootstrapBrandView, RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapEditText";

    private BootstrapBrand bootstrapBrand;
    private boolean rounded;

    public BootstrapEditText(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapEditText);

        try {
            this.rounded = a.getBoolean(R.styleable.BootstrapEditText_roundedCorners, false);

            int typeOrdinal = a.getInt(R.styleable.AwesomeTextView_bootstrapBrand, -1);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
        }
        finally {
            a.recycle();
        }
        setGravity(Gravity.CENTER);
        updateBootstrapState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, rounded);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.rounded = bundle.getBoolean(RoundableView.KEY);

            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);

            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    private void updateBootstrapState() {
        Drawable bg = BootstrapDrawableFactory.bootstrapEditText(
                getContext(),
                bootstrapBrand,
                rounded);

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

    /*
     * Getters/Setters
     */

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override public void setRounded(boolean rounded) {
        this.rounded = rounded;
        updateBootstrapState();
    }

    @Override public boolean isRounded() {
        return rounded;
    }
}
