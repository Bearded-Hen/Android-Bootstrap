package com.beardedhen.androidbootstrap.enums;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.BootstrapTheme;

public enum DefaultBootstrapTheme implements BootstrapTheme {

    PRIMARY(R.color.bootstrap_btn_primary_fill_default,
            R.color.bootstrap_btn_primary_edge_default,
            R.color.bootstrap_btn_primary_fill_active,
            R.color.bootstrap_btn_primary_edge_active,
            R.color.bootstrap_btn_primary_text),

    SECONDARY(R.color.bootstrap_btn_secondary_fill_default,
              R.color.bootstrap_btn_secondary_edge_default,
              R.color.bootstrap_btn_secondary_fill_active,
              R.color.bootstrap_btn_secondary_edge_active,
              R.color.bootstrap_btn_secondary_text),

    SUCCESS(R.color.bootstrap_btn_success_fill_default,
            R.color.bootstrap_btn_success_edge_default,
            R.color.bootstrap_btn_success_fill_active,
            R.color.bootstrap_btn_success_edge_active,
            R.color.bootstrap_btn_success_text),

    WARNING(R.color.bootstrap_btn_warning_fill_default,
            R.color.bootstrap_btn_warning_edge_default,
            R.color.bootstrap_btn_warning_fill_active,
            R.color.bootstrap_btn_warning_edge_active,
            R.color.bootstrap_btn_warning_text),

    DANGER(R.color.bootstrap_btn_danger_fill_default,
           R.color.bootstrap_btn_danger_edge_default,
           R.color.bootstrap_btn_danger_fill_active,
           R.color.bootstrap_btn_danger_edge_active,
           R.color.bootstrap_btn_danger_text),

    LINK(R.color.bootstrap_btn_link_fill_default,
         R.color.bootstrap_btn_link_edge_default,
         R.color.bootstrap_btn_link_fill_active,
         R.color.bootstrap_btn_link_edge_active,
         R.color.bootstrap_btn_link_text);

    private final int defaultFill;
    private final int defaultEdge;
    private final int activeFill;
    private final int activeEdge;
    private final int textColor;

    DefaultBootstrapTheme(@ColorInt int defaultFill,
                          @ColorInt int defaultEdge,
                          @ColorInt int activeFill,
                          @ColorInt int activeEdge,
                          @ColorInt int textColor) {
        this.defaultFill = defaultFill;
        this.defaultEdge = defaultEdge;
        this.activeFill = activeFill;
        this.activeEdge = activeEdge;
        this.textColor = textColor;
    }

    public static DefaultBootstrapTheme fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return PRIMARY;
            case 1:
                return SECONDARY;
            case 2:
                return SUCCESS;
            case 3:
                return WARNING;
            case 4:
                return DANGER;
            case 5:
                return LINK;
            default:
                return PRIMARY;
        }
    }

    @ColorInt public int buttonDefaultFill(Context context) {
        return context.getResources().getColor(defaultFill);
    }

    @ColorInt public int buttonDefaultEdge(Context context) {
        return context.getResources().getColor(defaultEdge);
    }

    @ColorInt public int buttonActiveFill(Context context) {
        return context.getResources().getColor(activeFill);
    }

    @ColorInt public int buttonActiveEdge(Context context) {
        return context.getResources().getColor(activeEdge);
    }

    @ColorInt public int buttonTextColor(Context context) {
        return context.getResources().getColor(textColor);
    }

    // disabled colors have 65% opacity
    @ColorInt public int buttonDisabledFill(Context context) {
        return generateDisabledColor(context, defaultFill);
    }

    @ColorInt public int buttonDisabledEdge(Context context) {
        return generateDisabledColor(context, defaultEdge);
    }

    private int generateDisabledColor(Context context, int defaultColor) {
        int c = context.getResources().getColor(defaultColor);
        return Color.argb(166, Color.red(c), Color.green(c), Color.blue(c)); // 65% alpha
    }

}