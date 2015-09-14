package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.api.view.ToggleableView;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableFactory;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableParams;

import java.io.Serializable;

public class BootstrapButton extends AwesomeTextView implements BootstrapThemeView,
        BootstrapSizeView, OutlineableView, RoundableView, ToggleableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButton";

    private BootstrapTheme bootstrapTheme;
    private BootstrapSize bootstrapSize;

    private boolean roundedCorners;
    private boolean showOutline;
    private boolean toggleable;

    public BootstrapButton(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);

        try {
            this.roundedCorners = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);
            this.showOutline = a.getBoolean(R.styleable.BootstrapButton_showOutline, false);
            this.toggleable = a.getBoolean(R.styleable.BootstrapButton_toggleable, false);

            int typeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapType, 0);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, 0);

            bootstrapTheme = DefaultBootstrapTheme.fromAttributeValue(typeOrdinal);
            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal);
        }
        finally {
            a.recycle();
        }
        requestStateRefresh();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putSerializable(BootstrapSize.KEY, bootstrapSize);
        bundle.putSerializable(BootstrapTheme.KEY, bootstrapTheme);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);

            Serializable size = bundle.getSerializable(BootstrapSize.KEY);
            Serializable theme = bundle.getSerializable(BootstrapTheme.KEY);

            if (size instanceof BootstrapSize) {
                bootstrapSize = (BootstrapSize) size;
            }
            if (theme instanceof BootstrapTheme) {
                bootstrapTheme = (BootstrapTheme) theme;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        requestStateRefresh();
    }

    @Override public void setBootstrapTheme(BootstrapTheme bootstrapTheme) {
        this.bootstrapTheme = bootstrapTheme;
        requestStateRefresh();
    }

    @Override public void setShowOutline(boolean showOutline) {
        this.showOutline = showOutline;
        requestStateRefresh();
    }

    @Override public void setRoundedCorners(boolean roundedCorners) {
        this.roundedCorners = roundedCorners;
        requestStateRefresh();
    }

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        requestStateRefresh();
    }

    private void requestStateRefresh() {

        if (bootstrapSize != null && bootstrapTheme != null) {

            int vert = bootstrapSize.buttonVerticalPadding(getContext());
            int hori = bootstrapSize.buttonHorizontalPadding(getContext());

            setPadding(hori, vert, hori, vert);
            int textColor = showOutline ? bootstrapTheme.defaultEdge(getContext()) : bootstrapTheme.textColor(getContext());
            setTextColor(textColor);

            // TODO need to handle link special case

            BootstrapDrawableParams params = new BootstrapDrawableParams()
                    .showRoundedCorners(roundedCorners)
                    .showOutline(showOutline)
                    .bootstrapType(bootstrapTheme)
                    .bootstrapSize(bootstrapSize)
                    .enabled(isEnabled());

            StateListDrawable bg = BootstrapDrawableFactory.bootstrapButton(getContext(), params);
            setTextColor(BootstrapDrawableFactory.bootstrapButtonText(getContext(), params));

            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(bg);
            }
            else {
                setBackgroundDrawable(bg);
            }
        }
    }

    @Override public BootstrapSize getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public BootstrapTheme getBootstrapTheme() {
        return bootstrapTheme;
    }

    @Override public boolean isShowOutline() {
        return showOutline;
    }

    @Override public boolean isRoundedCorners() {
        return roundedCorners;
    }

    @Override public void setToggleable(boolean toggleable) {
        this.toggleable = toggleable;
        requestStateRefresh();
    }

    @Override public boolean isToggleable() {
        return toggleable;
    }

    @Override public boolean onTouchEvent(@NonNull MotionEvent event) {
        if (toggleable && event.getAction() == MotionEvent.ACTION_DOWN) {
            setSelected(!isSelected());
            return true;
        }
        else {
            return super.onTouchEvent(event);
        }
    }

}
