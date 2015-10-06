package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

/**
 * Utils class for manipulating Bootstrap colors, and resolving colors from resource values.
 */
public class ColorUtils {

    public static final int DISABLED_ALPHA_FILL = 165;
    public static final int DISABLED_ALPHA_EDGE = 190;
    public static final float ACTIVE_OPACITY_FACTOR_FILL = 0.125f;
    public static final float ACTIVE_OPACITY_FACTOR_EDGE = 0.025f;

    /**
     * Resolves a color resource.
     *
     * @param color   the color resource
     * @param context the current context
     * @return a color int
     */
    public static @ColorInt int resolveColor(@ColorRes int color, Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(color, context.getTheme());
        }
        else {
            return context.getResources().getColor(color);
        }
    }

    /**
     * Darkens a color by reducing its RGB channel values.
     *
     * @param context the current context
     * @param res     the color resource
     * @param percent the percent to decrease
     * @return a color int
     */
    @ColorInt public static int decreaseRgbChannels(Context context,
                                                    @ColorRes int res, float percent) {
        int c = resolveColor(res, context);

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

    /**
     * Lightens a color by increasing its alpha channel value
     *
     * @param context the current context
     * @param res     the color resource
     * @param alpha   the alpha to set
     * @return a color int
     */
    @ColorInt public static int increaseOpacity(Context context, @ColorRes int res, int alpha) {
        int c = resolveColor(res, context);
        return Color.argb(alpha, Color.red(c), Color.green(c), Color.blue(c));
    }

}
