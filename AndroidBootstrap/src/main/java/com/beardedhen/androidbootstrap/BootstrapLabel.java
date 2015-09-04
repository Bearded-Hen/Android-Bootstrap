package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapHeadingView;
import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.RoundableView;
import com.beardedhen.androidbootstrap.enums.BootstrapHeading;

public class BootstrapLabel extends FontAwesomeText implements BootstrapThemeView, RoundableView,
        BootstrapHeadingView {

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
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontAwesomeText);

        try {
            int attrValue = a.getInt(R.styleable.BootstrapLabel_bootstrapHeading, 5);
            setBootstrapHeading(BootstrapHeading.fromAttributeValue(attrValue));
        }
        finally {
            a.recycle();
        }
    }

    @Override public void setBootstrapTheme(BootstrapTheme bootstrapTheme) {
        this.bootstrapTheme = bootstrapTheme;
    }

    @Override public BootstrapTheme getBootstrapTheme() {
        return bootstrapTheme;
    }

    @Override public void setRoundedCorners(boolean roundable) {
        this.roundable = roundable;
    }

    @Override public boolean isRoundedCorners() {
        return roundable;
    }

    @Override public void setBootstrapHeading(BootstrapHeading bootstrapHeading) {
        this.bootstrapHeading = bootstrapHeading;
        setTextSize(bootstrapHeading.getTextSize(getContext()));
    }

    @Override public BootstrapHeading getBootstrapHeading() {
        return bootstrapHeading;
    }

}
