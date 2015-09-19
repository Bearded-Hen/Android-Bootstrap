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
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.api.view.BootstrapHeadingView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

// TODO document/finalise
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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapLabel);

        try {
            int attrValue = a.getInt(R.styleable.BootstrapLabel_bootstrapHeading, 5);
            this.roundable = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);

            this.bootstrapHeading = DefaultBootstrapHeading.fromAttributeValue(attrValue);
        }
        finally {
            a.recycle();
        }
        requestStateRefresh();
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
        requestStateRefresh();
    }

    private void requestStateRefresh() {
        // set bg color etc

        int vert = (int) bootstrapHeading.verticalPadding(getContext());
        int hori = (int) bootstrapHeading.horizontalPadding(getContext());
        setPadding(hori, vert, hori, vert);

        setTextColor(getContext().getResources().getColor(android.R.color.white));
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(bootstrapHeading.getTextSize(getContext()));

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

        if (roundable && h != oldh) {
            requestStateRefresh();
        }
    }


    /*
     * Getters/Setters
     */


    @Override public void setRoundedCorners(boolean roundable) {
        this.roundable = roundable;
        requestStateRefresh();
    }

    @Override public boolean isRoundedCorners() {
        return roundable;
    }

    @Override public void setBootstrapHeading(@NonNull BootstrapHeading bootstrapHeading) {
        this.bootstrapHeading = bootstrapHeading;
        requestStateRefresh();
    }

    @NonNull @Override public BootstrapHeading getBootstrapHeading() {
        return bootstrapHeading;
    }

}
