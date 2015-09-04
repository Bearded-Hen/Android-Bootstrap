package com.beardedhen.androidbootstrap.enums;

import android.content.Context;
import android.support.annotation.DimenRes;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.BootstrapHeading;

public enum DefaultBootstrapHeading implements BootstrapHeading {

    H1(R.dimen.bootstrap_h1_text_size),
    H2(R.dimen.bootstrap_h2_text_size),
    H3(R.dimen.bootstrap_h3_text_size),
    H4(R.dimen.bootstrap_h4_text_size),
    H5(R.dimen.bootstrap_h5_text_size),
    H6(R.dimen.bootstrap_h6_text_size);

    private final @DimenRes int textSize;

    DefaultBootstrapHeading(int textSize) {
        this.textSize = textSize;
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

    public float getTextSize(Context context) {
        return context.getResources().getDimension(textSize);
    }

    @Override public int verticalPadding(Context context) {
        return 0; // FIXME
    }

    @Override public int horizontalPadding(Context context) {
        return 0; // FIXME
    }


}
