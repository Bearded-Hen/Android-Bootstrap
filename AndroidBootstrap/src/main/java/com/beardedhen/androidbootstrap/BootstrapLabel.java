package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading;
import com.beardedhen.androidbootstrap.api.attributes.LabelTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme;
import com.beardedhen.androidbootstrap.api.view.BootstrapHeadingView;
import com.beardedhen.androidbootstrap.api.view.LabelThemeView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableFactory;

public class BootstrapLabel extends AwesomeTextView implements LabelThemeView, RoundableView,
        BootstrapHeadingView {  // FIXME save state on orientation change

    private BootstrapHeading bootstrapHeading;
    private LabelTheme labelTheme;
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
            this.roundable = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);

            this.bootstrapHeading = DefaultBootstrapHeading.fromAttributeValue(attrValue);
            this.labelTheme = DefaultLabelTheme.fromAttributeValue(typeOrdinal);
        }
        finally {
            a.recycle();
        }
        requestStateRefresh();
    }

    @Override public void setRoundedCorners(boolean roundable) {
        this.roundable = roundable;
        requestStateRefresh();
    }

    @Override public boolean isRoundedCorners() {
        return roundable;
    }

    @Override public void setBootstrapHeading(BootstrapHeading bootstrapHeading) {
        this.bootstrapHeading = bootstrapHeading;

        requestStateRefresh();
    }

    @Override public BootstrapHeading getBootstrapHeading() {
        return bootstrapHeading;
    }

    private void requestStateRefresh() {
        // set bg color etc

        int vert = bootstrapHeading.verticalPadding(getContext());
        int hori = bootstrapHeading.horizontalPadding(getContext());
        setPadding(hori, vert, hori, vert);

        setTextColor(getContext().getResources().getColor(android.R.color.white));
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(bootstrapHeading.getTextSize(getContext()));

        Drawable bg = BootstrapDrawableFactory.bootstrapLabel(getContext(),
                                                              bootstrapHeading,
                                                              labelTheme,
                                                              roundable,
                                                              getHeight());

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

    @Override public void setLabelTheme(LabelTheme labelTheme) {
        this.labelTheme = labelTheme;
        requestStateRefresh();
    }

    @Override public LabelTheme getLabelTheme() {
        return labelTheme;
    }

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (roundable && h != oldh) {
            requestStateRefresh();
        }
    }
}
