package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

import static com.beardedhen.androidbootstrap.utils.ColorUtils.ACTIVE_OPACITY_FACTOR_EDGE;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.ACTIVE_OPACITY_FACTOR_FILL;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.DISABLED_ALPHA_EDGE;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.DISABLED_ALPHA_FILL;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.decreaseRgbChannels;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.increaseOpacity;
import static com.beardedhen.androidbootstrap.utils.ColorUtils.resolveColor;

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
    SECONDARY(R.color.bootstrap_brand_secondary_fill, R.color.bootstrap_brand_secondary_text),
    REGULAR(R.color.bootstrap_gray_light);

    private final int textColor;
    private final int color;

    DefaultBootstrapBrand(int color) {
        this.color = color;
        this.textColor =  android.R.color.white;
    }

    DefaultBootstrapBrand(int color, int textColor) {
        this.color = color;
        this.textColor =  textColor;
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
            case 6:
                return SECONDARY;
            default:
                return REGULAR;
        }
    }

    @ColorInt public int defaultFill(Context context) {
        return resolveColor(color, context);
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
        return resolveColor(textColor, context);
    }

    @ColorInt public int activeTextColor(Context context) {
        return resolveColor(textColor, context);
    }

    @ColorInt public int disabledTextColor(Context context) {
        return resolveColor(textColor, context);
    }

}
