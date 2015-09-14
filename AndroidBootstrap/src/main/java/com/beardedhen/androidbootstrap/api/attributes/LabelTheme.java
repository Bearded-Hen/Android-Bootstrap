package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;
import android.support.annotation.ColorInt;

import java.io.Serializable;

public interface LabelTheme extends Serializable {

    String KEY = "com.beardedhen.androidbootstrap.api.attributes.LabelTheme";

    @ColorInt int defaultFill(Context context);

}
