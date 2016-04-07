package com.fractalwrench.androidbootstrap.sample;

import android.content.Context;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * A custom Bootstrap Style. Implement {@see BootstrapBrand} in your own classes to define styles.
 */
public class CustomBootstrapStyle implements BootstrapBrand {

    @ColorInt private final int defaultFill;
    @ColorInt private final int defaultEdge;
    @ColorInt private final int defaultTextColor;
    @ColorInt private final int activeFill;
    @ColorInt private final int activeEdge;
    @ColorInt private final int activeTextColor;
    @ColorInt private final int disabledFill;
    @ColorInt private final int disabledEdge;
    @ColorInt private final int disabledTextColor;

    @SuppressWarnings("deprecation") public CustomBootstrapStyle(Context context) {
        defaultFill = context.getResources().getColor(R.color.custom_default_fill);
        defaultEdge = context.getResources().getColor(R.color.custom_default_edge);
        defaultTextColor = context.getResources().getColor(android.R.color.white);
        activeFill = context.getResources().getColor(R.color.custom_active_fill);
        activeEdge = context.getResources().getColor(R.color.custom_active_edge);
        activeTextColor = context.getResources().getColor(android.R.color.black);
        disabledFill = context.getResources().getColor(R.color.custom_disabled_fill);
        disabledEdge = context.getResources().getColor(R.color.custom_disabled_edge);
        disabledTextColor = context.getResources().getColor(R.color.bootstrap_gray);
    }

    @Override public int defaultFill(Context context) {
        return defaultFill;
    }

    @Override public int defaultEdge(Context context) {
        return defaultEdge;
    }

    @Override public int defaultTextColor(Context context) {
        return defaultTextColor;
    }

    @Override public int activeFill(Context context) {
        return activeFill;
    }

    @Override public int activeEdge(Context context) {
        return activeEdge;
    }

    @Override public int activeTextColor(Context context) {
        return activeTextColor;
    }

    @Override public int disabledFill(Context context) {
        return disabledFill;
    }

    @Override public int disabledEdge(Context context) {
        return disabledEdge;
    }

    @Override public int disabledTextColor(Context context) {
        return disabledTextColor;
    }

    @Override public int getColor() {
        return defaultFill;
    }
}
