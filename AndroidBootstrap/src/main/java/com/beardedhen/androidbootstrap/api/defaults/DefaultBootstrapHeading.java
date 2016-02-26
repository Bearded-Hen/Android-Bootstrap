package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;
import android.support.annotation.DimenRes;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

/**
 * Bootstrap provides styling for elements H1-H6, and sets their text size and padding using the
 * values supplied here.
 */
public enum DefaultBootstrapHeading implements BootstrapHeading {

    H1(R.dimen.bootstrap_h1_text_size,
       R.dimen.bootstrap_h1_vert_padding,
       R.dimen.bootstrap_h1_hori_padding),

    H2(R.dimen.bootstrap_h2_text_size,
       R.dimen.bootstrap_h2_vert_padding,
       R.dimen.bootstrap_h2_hori_padding),

    H3(R.dimen.bootstrap_h3_text_size,
       R.dimen.bootstrap_h3_vert_padding,
       R.dimen.bootstrap_h3_hori_padding),

    H4(R.dimen.bootstrap_h4_text_size,
       R.dimen.bootstrap_h4_vert_padding,
       R.dimen.bootstrap_h4_hori_padding),

    H5(R.dimen.bootstrap_h5_text_size,
       R.dimen.bootstrap_h5_vert_padding,
       R.dimen.bootstrap_h5_hori_padding),

    H6(R.dimen.bootstrap_h6_text_size,
       R.dimen.bootstrap_h6_vert_padding,
       R.dimen.bootstrap_h6_hori_padding);

    private final @DimenRes int textSize;
    private final @DimenRes int vertPadding;
    private final @DimenRes int horiPadding;

    DefaultBootstrapHeading(int textSize, int vertPadding, int horiPadding) {
        this.textSize = textSize;
        this.vertPadding = vertPadding;
        this.horiPadding = horiPadding;
    }

    public static DefaultBootstrapHeading fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return H1;
            case 1:
                return H2;
            case 2:
                return H3;
            case 3:
                return H4;
            case 4:
                return H5;
            case 5:
                return H6;
            default:
                return H6;
        }
    }

    @Override public float getTextSize(Context context) {
        return DimenUtils.pixelsFromSpResource(context, textSize);
    }

    @Override public float verticalPadding(Context context) {
        return DimenUtils.pixelsFromDpResource(context, vertPadding);
    }

    @Override public float horizontalPadding(Context context) {
        return DimenUtils.pixelsFromDpResource(context, horiPadding);
    }

}
