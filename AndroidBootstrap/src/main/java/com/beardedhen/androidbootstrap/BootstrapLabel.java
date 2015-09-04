package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapHeading;
import com.beardedhen.androidbootstrap.api.BootstrapHeadingView;
import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.RoundableView;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.utils.BootstrapDrawableFactory;

public class BootstrapLabel extends FontAwesomeText implements BootstrapThemeView, RoundableView,
        BootstrapHeadingView {  // FIXME save state on orientation change

    private BootstrapHeading bootstrapHeading;
    private BootstrapTheme bootstrapTheme;
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
            int typeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapType, 0);

            this.bootstrapHeading = DefaultBootstrapHeading.fromAttributeValue(attrValue);
            this.bootstrapTheme = DefaultBootstrapTheme.fromAttributeValue(typeOrdinal);
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

    @Override public BootstrapTheme getBootstrapTheme() {
        return bootstrapTheme;
    }

    @Override public void setRoundedCorners(boolean roundable) {
        this.roundable = roundable;
        requestStateRefresh();
    }

    @Override public boolean isRoundedCorners() {
        return roundable;
    }

    @Override public void setBootstrapHeading(BootstrapHeading bootstrapHeading) { // FIXME should alter padding
        this.bootstrapHeading = bootstrapHeading;
        requestStateRefresh();
    }

    @Override public BootstrapHeading getBootstrapHeading() {
        return bootstrapHeading;
    }

    @Override protected void requestStateRefresh() {
        // set bg color etc

        setTextColor(getContext().getResources().getColor(android.R.color.white));
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(bootstrapHeading.getTextSize(getContext()));

        Drawable bg = BootstrapDrawableFactory.bootstrapLabel(getContext(), bootstrapHeading, bootstrapTheme, false);

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

}
