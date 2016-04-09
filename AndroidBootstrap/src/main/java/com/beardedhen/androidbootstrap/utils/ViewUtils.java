package com.beardedhen.androidbootstrap.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewUtils {

    /**
     * Calls {@link View#setBackground(Drawable)} or {@link View#setBackgroundDrawable(Drawable)},
     * depending on API level
     *
     * @param view     the view
     * @param drawable the drawable
     */
    @SuppressWarnings("deprecation")
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        }
        else {
            view.setBackgroundDrawable(drawable);
        }
    }

}
