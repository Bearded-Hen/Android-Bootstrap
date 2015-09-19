package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * Bootstrap provides 5 brands by default - Primary, Success, Info, Warning, and Danger. Brands are
 * often supplemented by view-specific colors, which are <b>not</b> globally used.
 */
public enum DefaultBootstrapBrand implements BootstrapBrand {

    PRIMARY(R.color.bootstrap_brand_primary),
    SUCCESS(R.color.bootstrap_brand_success),
    INFO(R.color.bootstrap_brand_info),
    WARNING(R.color.bootstrap_brand_warning),
    DANGER(R.color.bootstrap_brand_danger),
    REGULAR(R.color.bootstrap_gray_light);

    private final int color;

    DefaultBootstrapBrand(int color) {
        this.color = color;
    }

    public static DefaultBootstrapBrand fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return PRIMARY;
            case 1:
                return SUCCESS;
            case 2:
                return INFO;
            case 3:
                return WARNING;
            case 4:
                return DANGER;
            case 5:
                return REGULAR;
            default:
                return REGULAR;
        }
    }

    @Override public int color(Context context) {
        return context.getResources().getColor(color);
    }

}
