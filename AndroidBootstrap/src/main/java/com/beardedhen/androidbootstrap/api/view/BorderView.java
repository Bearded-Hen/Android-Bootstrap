package com.beardedhen.androidbootstrap.api.view;

import android.support.annotation.ColorInt;

/**
 * Views which implement this interface allow the width and color of their drawn border to be set.
 */
public interface BorderView {

    String KEY_COLOR = "com.beardedhen.androidbootstrap.api.view.KEY_COLOR";
    String KEY_WIDTH = "com.beardedhen.androidbootstrap.api.view.KEY_WIDTH";

    /**
     * @return the current border color, or -1 if none exists
     */
    @ColorInt int getBorderColor();

    /**
     * Sets the border color for this view
     *
     * @param borderColor the border color
     */
    void setBorderColor(@ColorInt int borderColor);

    /**
     * @return the current border width
     */
    float getBorderWidth();

    /**
     * Sets the current border width for the view, in px
     *
     * @param borderWidth the desired border width in px
     */
    void setBorderWidth(float borderWidth);

}
