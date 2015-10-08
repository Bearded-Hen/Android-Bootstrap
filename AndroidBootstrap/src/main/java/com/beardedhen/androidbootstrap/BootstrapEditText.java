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
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

import java.io.Serializable;

/**
 * BootstrapEditText allows users to enter values like a regular Android EditText, and allows coloring
 * via BootstrapBrand, and rounding of its background.
 */
public class BootstrapEditText extends EditText implements BootstrapBrandView, RoundableView,
        BootstrapSizeView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapEditText";

    private float baselineFontSize;
    private float baselineVertPadding;
    private float baselineHoriPadding;
    private float baselineStrokeWidth;
    private float baselineCornerRadius;

    private BootstrapBrand bootstrapBrand;
    private float bootstrapSize;
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
            int sizeOrdinal = a.getInt(R.styleable.BootstrapEditText_bootstrapSize, -1);

            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
        }
        finally {
            a.recycle();
        }

        baselineFontSize = DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_edit_text_default_font_size);
        baselineVertPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_edit_text_vert_padding);
        baselineHoriPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_edit_text_hori_padding);
        baselineStrokeWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_edit_text_edge_width);
        baselineCornerRadius = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_edit_text_corner_radius);

        setGravity(Gravity.CENTER_VERTICAL); // center text vertically by default
        updateBootstrapState();
        invalidate();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, rounded);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.rounded = bundle.getBoolean(RoundableView.KEY);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

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
        int vPadding = (int) (baselineVertPadding * bootstrapSize);
        int hPadding = (int) (baselineHoriPadding * bootstrapSize);
        setPadding(vPadding, hPadding, vPadding, hPadding);

        int strokeWidth = (int) (baselineStrokeWidth * bootstrapSize);
        float cornerRadius = baselineCornerRadius * bootstrapSize;

        final float fontSize = baselineFontSize * bootstrapSize;
        setTextSize(fontSize);

        Drawable bg = BootstrapDrawableFactory.bootstrapEditText(
                getContext(),
                bootstrapBrand,
                strokeWidth,
                cornerRadius,
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

    @Override public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateBootstrapState();
    }

    @Override public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

}
