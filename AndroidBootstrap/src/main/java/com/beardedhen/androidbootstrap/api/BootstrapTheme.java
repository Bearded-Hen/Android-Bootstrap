package com.beardedhen.androidbootstrap.api;

import android.content.Context;
import android.support.annotation.ColorInt;

public interface BootstrapTheme {

    @ColorInt int buttonDefaultFill(Context context);

    @ColorInt int buttonDefaultEdge(Context context);

    @ColorInt int buttonActiveFill(Context context);

    @ColorInt int buttonActiveEdge(Context context);

    @ColorInt int buttonTextColor(Context context);

    @ColorInt int buttonDisabledFill(Context context);

    @ColorInt int buttonDisabledEdge(Context context);

}
