package com.beardedhen.androidbootstrap.api.defaults;

import android.content.Context;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;

/**
 * Bootstrap provides 5 sizes - XS, SM, MD, LG, and XL. In the Android implementation the scale
 * factors used are 0.75, 0.83, 1.00, 1.50, and 2.00 respectively.
 */
public enum DefaultBootstrapSize implements BootstrapSize {

    XS(),
    SM(),
    MD(),
    LG(),
    XL();

    public static DefaultBootstrapSize fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return XS;
            case 1:
                return SM;
            case 2:
                return MD;
            case 3:
                return LG;
            case 4:
                return XL;
            default:
                return MD;
        }
    }

    @Override public float scaleFactor(Context context) {
        switch (this) {
            case XS:
                return 0.70f;
            case SM:
                return 0.85f;
            case MD:
                return 1.00f;
            case LG:
                return 1.30f;
            case XL:
                return 1.60f;
            default:
                return 1.00f;
        }
    }

}
