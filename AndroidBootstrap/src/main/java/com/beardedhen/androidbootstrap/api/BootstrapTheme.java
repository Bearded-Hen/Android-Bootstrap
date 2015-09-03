package com.beardedhen.androidbootstrap.api;

import android.content.Context;

public interface BootstrapTheme {

    int buttonDefaultFill(Context context);

    int buttonDefaultEdge(Context context);

    int buttonActiveFill(Context context);

    int buttonActiveEdge(Context context);

    int buttonTextColor(Context context);

    // disabled colors have 65% opacity
    int buttonDisabledFill(Context context);

    int buttonDisabledEdge(Context context);

}
