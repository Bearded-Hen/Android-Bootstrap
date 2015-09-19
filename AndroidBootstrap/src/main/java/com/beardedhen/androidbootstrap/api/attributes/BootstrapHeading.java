package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;

import java.io.Serializable;

/**
 * A Heading defines the text size and padding of its view. Bootstrap supports styles for H1-H6
 * elements out of the box.
 */
public interface BootstrapHeading extends Serializable {

    String KEY = "com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading";

    /**
     * Retrieves the text size for the current BootstrapHeading.
     *
     * @param context the current context
     * @return the text size
     */
    float getTextSize(Context context);

    /**
     * Retrieves the vertical padding for the current BootstrapHeading
     *
     * @param context the current context
     * @return the vertical padding
     */
    float verticalPadding(Context context);

    /**
     * Retrieves the horizontal padding for the current BootstrapHeading
     *
     * @param context the current context
     * @return the horizontal padding
     */
    float horizontalPadding(Context context);

}
