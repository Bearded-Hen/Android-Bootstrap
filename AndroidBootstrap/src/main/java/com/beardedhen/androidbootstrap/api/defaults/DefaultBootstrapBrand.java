package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * Bootstrap provides 6 brands by default - Primary, Success, Info, Warning, Danger, and Default.
 * Brands are often supplemented by view-specific colors, which are <b>not</b> globally used.
 */
public enum DefaultBootstrapBrand implements BootstrapBrand {

    PRIMARY(R.color.bootstrap_brand_primary),
    SUCCESS(R.color.bootstrap_brand_success),
    INFO(R.color.bootstrap_brand_info),
    WARNING(R.color.bootstrap_brand_warning),
    DANGER(R.color.bootstrap_brand_danger),
    REGULAR(R.color.bootstrap_gray_light);

    private static final int DISABLED_ALPHA_FILL = 165;
    private static final int DISABLED_ALPHA_EDGE = 190;
    private static final float ACTIVE_OPACITY_FACTOR_FILL = 0.125f;
    private static final float ACTIVE_OPACITY_FACTOR_EDGE = 0.025f;

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
        return decreaseRgbChannels(context, color, ACTIVE_OPACITY_FACTOR_EDGE);
    }

    @ColorInt public int activeFill(Context context) {
        return decreaseRgbChannels(context, color, ACTIVE_OPACITY_FACTOR_FILL);
    }

    @ColorInt public int activeEdge(Context context) {
        return decreaseRgbChannels(context, color, ACTIVE_OPACITY_FACTOR_FILL + ACTIVE_OPACITY_FACTOR_EDGE);
    }

    @ColorInt public int disabledFill(Context context) {
        return increaseOpacity(context, color, DISABLED_ALPHA_FILL);
    }

    @ColorInt public int disabledEdge(Context context) {
        return increaseOpacity(context, color, DISABLED_ALPHA_FILL - DISABLED_ALPHA_EDGE);
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

    @ColorInt private int decreaseRgbChannels(Context context, @ColorRes int res, float percent) {
        int c = context.getResources().getColor(res);

        // reduce rgb channel values to produce box shadow effect
        int red = (Color.red(c));
        red -= (red * percent);
        red = red > 0 ? red : 0;

        int green = (Color.green(c));
        green -= (green * percent);
        green = green > 0 ? green : 0;

        int blue = (Color.blue(c));
        blue -= (blue * percent);
        blue = blue > 0 ? blue : 0;

        return Color.argb(Color.alpha(c), red, green, blue);
    }

    @ColorInt private int increaseOpacity(Context context, @ColorRes int res, int alpha) {
        int c = context.getResources().getColor(res);
        return Color.argb(alpha, Color.red(c), Color.green(c), Color.blue(c));
    }

}
