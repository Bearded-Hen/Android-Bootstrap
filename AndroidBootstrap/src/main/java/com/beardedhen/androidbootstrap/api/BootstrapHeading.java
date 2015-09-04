package com.beardedhen.androidbootstrap.api;

import android.content.Context;

import java.io.Serializable;

public interface BootstrapHeading extends Serializable {

    String KEY = "BootstrapHeading";

    float getTextSize(Context context);

    int verticalPadding(Context context);

    int horizontalPadding(Context context);

}
