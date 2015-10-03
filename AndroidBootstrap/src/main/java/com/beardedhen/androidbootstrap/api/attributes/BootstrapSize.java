package com.beardedhen.androidbootstrap.api.attributes;

import android.content.Context;

import java.io.Serializable;

/**
 * Classes which implement this interface allow aspects of their view to be scaled by a float factor.
 * For example, a Button may double its padding from the baseline if a factor of 2.0 is provided.
 */
public interface BootstrapSize extends Serializable {

    /**
     * Retrieves the scale factor that should be used to scale a view from its baseline size.
     * For example, specifying that a Button should use a scale factor of 2.0 may increase its
     * padding and font size by that factor.
     *
     * @param context the current context
     * @return the scale factor
     */
    float scaleFactor(Context context);

    String KEY = "BootstrapSize";

}
