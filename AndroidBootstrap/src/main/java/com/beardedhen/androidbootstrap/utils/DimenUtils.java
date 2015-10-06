package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;

/**
 * Utils class for resolving color resource values.
 */
public class DimenUtils {

    /**
     * Resolves a dimension resource that uses scaled pixels
     *
     * @param context the current context
     * @param sizeRes the dimension resource holding an SP value
     * @return the text size in pixels
     */
    public static float pixelsFromSpResource(Context context, @DimenRes int sizeRes) {
        final Resources res = context.getResources();
        return res.getDimension(sizeRes) / res.getDisplayMetrics().density;
    }

    /**
     * Resolves a dimension resource that uses density-independent pixels
     *
     * @param context the current context
     * @param res     the dimension resource holding a DP value
     * @return the size in pixels
     */
    public static float pixelsFromDpResource(Context context, @DimenRes int res) {
        return context.getResources().getDimension(res);
    }


}
