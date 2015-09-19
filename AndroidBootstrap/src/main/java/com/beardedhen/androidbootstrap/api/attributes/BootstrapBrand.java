package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;
import android.support.annotation.ColorInt;

import java.io.Serializable;

/**
 * A Bootstrap Brand is a color which is used universally across many Bootstrap Views. An example is
 * the 'Info' Brand which colors views light blue.
 */
public interface BootstrapBrand extends Serializable {

    String KEY = "BootstrapBrand";

    /**
     * Retrieves the color for the current brand.
     *
     * @param context the current context
     * @return the color for the current brand
     */
    @ColorInt int color(Context context);

}
