package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.api.view.BootstrapHeadingView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

/**
 * BootstrapLabels are designed for showing text styled with BootstrapBrands - they should be
 * considered similar to a BootstrapButton, but without the press functionality. It is possible to
 * set the size of BootstrapLabels using H1-H6 elements.
 */
public class BootstrapLabel extends AwesomeTextView implements RoundableView, BootstrapHeadingView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapLabel";

    private BootstrapHeading bootstrapHeading;
    private boolean roundable;

    public BootstrapLabel(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapLabel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapLabel);

        try {
            int attrValue = a.getInt(R.styleable.BootstrapLabel_bootstrapHeading, 5);
            this.roundable = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);

            this.bootstrapHeading = DefaultBootstrapHeading.fromAttributeValue(attrValue);
        }
        finally {
            a.recycle();
        }
        updateBootstrapState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, roundable);
        bundle.putSerializable(BootstrapHeading.KEY, bootstrapHeading);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundable = bundle.getBoolean(RoundableView.KEY);

            Serializable heading = bundle.getSerializable(BootstrapHeading.KEY);

            if (heading instanceof BootstrapHeading) {
                bootstrapHeading = (BootstrapHeading) heading;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    @Override public void updateBootstrapState() {
        super.updateBootstrapState();
        // set bg color etc

        if (bootstrapHeading != null) {
            int vert = (int) bootstrapHeading.verticalPadding(getContext());
            int hori = (int) bootstrapHeading.horizontalPadding(getContext());

            setPadding(hori, vert, hori, vert);
            setTextSize(bootstrapHeading.getTextSize(getContext()));
        }

        setTextColor(getBootstrapBrand().defaultTextColor(getContext()));
        setTypeface(Typeface.DEFAULT_BOLD);

        Drawable bg = BootstrapDrawableFactory.bootstrapLabel(
                getContext(),
                getBootstrapBrand(),
                roundable,
                getHeight());

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (roundable && h != oldh) { // corner radius should always be h/2
            updateBootstrapState();
        }
    }

    /*
     * Getters/Setters
     */

    @Override public void setRounded(boolean rounded) {
        this.roundable = rounded;
        updateBootstrapState();
    }

    @Override public boolean isRounded() {
        return roundable;
    }

    @Override public void setBootstrapHeading(@NonNull BootstrapHeading bootstrapHeading) {
        this.bootstrapHeading = bootstrapHeading;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapHeading getBootstrapHeading() {
        return bootstrapHeading;
    }

}
