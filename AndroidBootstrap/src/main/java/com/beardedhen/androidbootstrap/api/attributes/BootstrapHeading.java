package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;

import java.io.Serializable;

public interface BootstrapHeading extends Serializable {

    String KEY = "com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading";

    float getTextSize(Context context);

    int verticalPadding(Context context);

    int horizontalPadding(Context context);

}
