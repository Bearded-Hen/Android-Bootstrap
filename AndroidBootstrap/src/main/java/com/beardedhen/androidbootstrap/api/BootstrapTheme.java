package com.beardedhen.androidbootstrap.api;

import android.content.Context;
import android.support.annotation.ColorInt;

public interface BootstrapTheme {

    @ColorInt int defaultFill(Context context);

    @ColorInt int defaultEdge(Context context);

    @ColorInt int activeFill(Context context);

    @ColorInt int activeEdge(Context context);

    @ColorInt int textColor(Context context);

    @ColorInt int disabledFill(Context context);

    @ColorInt int disabledEdge(Context context);

}
