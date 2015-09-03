package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.OutlineableView;

public class BootstrapLabel extends FontAwesomeText implements BootstrapThemeView, OutlineableView {

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

    }

    @Override public void setBootstrapTheme(BootstrapTheme bootstrapTheme) {

    }

    @Override public void setShowOutline(boolean showOutline) {

    }
}
