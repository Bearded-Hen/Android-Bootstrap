package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.RoundableView;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.utils.BootstrapDrawableFactory;
import com.beardedhen.androidbootstrap.utils.BootstrapDrawableParams;

public class BootstrapButton extends FontAwesomeText implements BootstrapThemeView, RoundableView {

    private BootstrapTheme bootstrapTheme = DefaultBootstrapTheme.PRIMARY;
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

            int attrValue = a.getInt(R.styleable.BootstrapButton_bootstrapType, 0);
            bootstrapTheme = DefaultBootstrapTheme.fromAttributeValue(attrValue);
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

    private void requestStateRefresh() {
        BootstrapDrawableParams params = new BootstrapDrawableParams()
                .showRoundedCorners(roundedCorners)
                .showOutline(showOutline)
                .bootstrapType(bootstrapTheme)
                .enabled(isEnabled());

        StateListDrawable bg = BootstrapDrawableFactory.bootstrapButton(getContext(), params);

        if (Build.VERSION.SDK_INT > 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
        setTextColor(bootstrapTheme.buttonTextColor(getContext()));
    }

}
