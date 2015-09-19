package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * Bootstrap provides 5 brands by default - Primary, Success, Info, Warning, and Danger. Brands are
 * often supplemented by view-specific colors, which are <b>not</b> globally used.
 */
public enum DefaultBootstrapBrand implements BootstrapBrand {

    PRIMARY(R.color.bootstrap_brand_primary),
    SUCCESS(R.color.bootstrap_brand_success),
    INFO(R.color.bootstrap_brand_info),
    WARNING(R.color.bootstrap_brand_warning),
    DANGER(R.color.bootstrap_brand_danger),
    REGULAR(R.color.bootstrap_gray_light);

    private static final float DISABLED_OPACITY_FACTOR = 0.65f;
    private static final float ACTIVE_OPACITY_FACTOR = 0.125f;

    private final int color;

    DefaultBootstrapBrand(int color) {
        this.color = color;
    }

    public static DefaultBootstrapBrand fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return PRIMARY;
            case 1:
                return SUCCESS;
            case 2:
                return INFO;
            case 3:
                return WARNING;
            case 4:
                return DANGER;
            case 5:
                return REGULAR;
            default:
                return REGULAR;
        }
    }

    @ColorInt public int defaultFill(Context context) {
        return context.getResources().getColor(color);
    }

    @ColorInt public int defaultEdge(Context context) {
        return context.getResources().getColor(color);
    }

    @ColorInt public int activeFill(Context context) {
        return generateActiveColor(context, color);// context.getResources().getColor(activeFill);
    }

    @ColorInt public int activeEdge(Context context) {
        return generateActiveColor(context, color);// context.getResources().getColor(activeEdge);
    }

    // disabled colors have 65% opacity
    @ColorInt public int disabledFill(Context context) {
        return generateDisabledColor(context, color);
    }

    @ColorInt public int disabledEdge(Context context) {
        return generateDisabledColor(context, color);
    }

    @ColorInt public int defaultTextColor(Context context) {
        return context.getResources().getColor(android.R.color.white);
    }

    @ColorInt public int activeTextColor(Context context) {
        return context.getResources().getColor(android.R.color.white);
    }

    @ColorInt public int disabledTextColor(Context context) {
        return context.getResources().getColor(android.R.color.white);
    }

    private int generateDisabledColor(Context context, int defaultColor) {
        int c = context.getResources().getColor(defaultColor);

        // reduce default alpha by 65%
        return Color.argb((int) (DISABLED_OPACITY_FACTOR * 255),
                Color.red(c), Color.green(c), Color.blue(c));
    }

    private int generateActiveColor(Context context, int defaultColor) {
        int c = context.getResources().getColor(defaultColor);

        // reduce rgb channel values to produce box shadow effect
        int red = (Color.red(c));
        red -= (red * ACTIVE_OPACITY_FACTOR);
        red = red > 0 ? red : 0;

        int green = (Color.green(c));
        green -= (green * ACTIVE_OPACITY_FACTOR);
        green = green > 0 ? green : 0;

        int blue = (Color.blue(c));
        blue -= (blue * ACTIVE_OPACITY_FACTOR);
        blue = blue > 0 ? blue : 0;

        return Color.argb(Color.alpha(c), red, green, blue);
    }

}
