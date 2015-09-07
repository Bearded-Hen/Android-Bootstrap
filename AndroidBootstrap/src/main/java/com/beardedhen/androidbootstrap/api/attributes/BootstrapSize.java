package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;

import java.io.Serializable;

public interface BootstrapSize extends Serializable {

    String KEY = "BootstrapSize";

    int buttonFontSize(Context context);

    int buttonVerticalPadding(Context context);

    int buttonHorizontalPadding(Context context);

    int buttonCornerRadius(Context context);

    int buttonLineHeight(Context context);

}
