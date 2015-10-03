package com.beardedhen.androidbootstrap.support;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;

public class DimenUtils {

    public static float textSizeFromDimenResource(Context context, @DimenRes int sizeRes) {
        final Resources res = context.getResources();
        return res.getDimension(sizeRes) / res.getDisplayMetrics().density;
    }

}
