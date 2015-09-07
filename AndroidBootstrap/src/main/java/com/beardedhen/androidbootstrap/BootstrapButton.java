package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableFactory;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableParams;

public class BootstrapButton extends AwesomeTextView implements BootstrapThemeView,
        BootstrapSizeView, OutlineableView, RoundableView { // FIXME save state on orientation change

    private BootstrapTheme bootstrapTheme;
    private BootstrapSize bootstrapSize;
    private boolean roundedCorners;
    private boolean showOutline;

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
}
