package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.LabelTheme;

public enum DefaultLabelTheme implements LabelTheme {

    DEFAULT(R.color.bootstrap_lbl_default_fill),
    PRIMARY(R.color.bootstrap_lbl_primary_fill),
    SUCCESS(R.color.bootstrap_lbl_success_fill),
    INFO(R.color.bootstrap_lbl_info_fill),
    WARNING(R.color.bootstrap_lbl_warning_fill),
    DANGER(R.color.bootstrap_lbl_danger_fill);

    private final int defaultFill;

    DefaultLabelTheme(@ColorInt int defaultFill) {
        this.defaultFill = defaultFill;
    }

    public static DefaultLabelTheme fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return DEFAULT;
            case 1:
                return PRIMARY;
            case 2:
                return SUCCESS;
            case 3:
                return INFO;
            case 4:
                return WARNING;
            case 5:
                return DANGER;
            default:
                return DEFAULT;
        }
    }

    @ColorInt public int defaultFill(Context context) {
        return context.getResources().getColor(defaultFill);
    }

}
