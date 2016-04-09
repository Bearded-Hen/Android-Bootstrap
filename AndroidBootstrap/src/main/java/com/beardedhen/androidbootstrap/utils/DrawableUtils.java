package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;

public class DrawableUtils {

    @SuppressWarnings("deprecation")
    public static Drawable resolveDrawable(@DrawableRes int resId, Context context) {
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();

        if (Build.VERSION.SDK_INT >= 22) {
            return resources.getDrawable(resId, theme);
        }
        else {
            return resources.getDrawable(resId);
        }
    }

}
