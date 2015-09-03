package com.beardedhen.androidbootstrap.enums;

import android.content.Context;
import android.support.annotation.DimenRes;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.BootstrapSize;

public enum DefaultBootstrapSize implements BootstrapSize {

    MEDIUM(R.dimen.bootstrap_button_default_font_size,
            R.dimen.bootstrap_button_default_vert_padding,
            R.dimen.bootstrap_button_default_hori_padding,
            R.dimen.bootstrap_button_default_corner_radius,
            R.dimen.bootstrap_button_default_edge_width),

    SMALL(R.dimen.bootstrap_button_small_font_size,
          R.dimen.bootstrap_button_small_vert_padding,
          R.dimen.bootstrap_button_small_hori_padding,
          R.dimen.bootstrap_button_small_corner_radius,
          R.dimen.bootstrap_button_small_edge_width),

    LARGE(R.dimen.bootstrap_button_large_font_size,
          R.dimen.bootstrap_button_large_vert_padding,
          R.dimen.bootstrap_button_large_hori_padding,
          R.dimen.bootstrap_button_large_corner_radius,
          R.dimen.bootstrap_button_large_edge_width);

    @DimenRes private final int buttonFontSize;
    @DimenRes private final int buttonVerticalPadding;
    @DimenRes private final int buttonHorizontalPadding;
    @DimenRes private final int buttonCornerRadius;
    @DimenRes private final int buttonLineHeight;

    DefaultBootstrapSize(@DimenRes int buttonFontSize,
                         @DimenRes int buttonVerticalPadding,
                         @DimenRes int buttonHorizontalPadding,
                         @DimenRes int buttonCornerRadius,
                         @DimenRes int buttonLineHeight) {
        this.buttonFontSize = buttonFontSize;
        this.buttonVerticalPadding = buttonVerticalPadding;
        this.buttonHorizontalPadding = buttonHorizontalPadding;
        this.buttonCornerRadius = buttonCornerRadius;
        this.buttonLineHeight = buttonLineHeight;
    }

    public static DefaultBootstrapSize fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return MEDIUM;
            case 1:
                return SMALL;
            case 2:
                return LARGE;
            default:
                return MEDIUM;
        }
    }

    @Override public int buttonFontSize(Context context) {
        return context.getResources().getDimensionPixelSize(buttonFontSize);
    }

    @Override public int buttonVerticalPadding(Context context) {
        return context.getResources().getDimensionPixelSize(buttonVerticalPadding);
    }

    @Override public int buttonHorizontalPadding(Context context) {
        return context.getResources().getDimensionPixelSize(buttonHorizontalPadding);
    }

    @Override public int buttonCornerRadius(Context context) {
        return context.getResources().getDimensionPixelSize(buttonCornerRadius);
    }

    @Override public int buttonLineHeight(Context context) {
        return context.getResources().getDimensionPixelSize(buttonLineHeight);
    }

}
