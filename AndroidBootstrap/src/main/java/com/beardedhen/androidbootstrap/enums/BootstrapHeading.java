package com.beardedhen.androidbootstrap.enums;

import android.content.Context;
import android.support.annotation.DimenRes;

import com.beardedhen.androidbootstrap.R;

public enum BootstrapHeading {

    H1(R.dimen.bootstrap_h1),
    H2(R.dimen.bootstrap_h2),
    H3(R.dimen.bootstrap_h3),
    H4(R.dimen.bootstrap_h4),
    H5(R.dimen.bootstrap_h5),
    H6(R.dimen.bootstrap_h6);

    private final @DimenRes int textSize;

    BootstrapHeading(int textSize) {
        this.textSize = textSize;
    }

    public static BootstrapHeading fromAttributeValue(int attrValue) {
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

}
