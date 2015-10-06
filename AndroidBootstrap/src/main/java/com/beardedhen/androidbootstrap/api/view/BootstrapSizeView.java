package com.beardedhen.androidbootstrap.api.view;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

/**
 * Classes which implement this interface allow aspects of their view to be scaled by a float factor.
 * For example, a Button may double its padding from the baseline if a factor of 2.0 is provided.
 */
public interface BootstrapSizeView {

    String KEY = "com.beardedhen.androidbootstrap.api.view.BootstrapSizeView";

    /**
     * Retrieves the scale factor that should be used to scale a view from its baseline size.
     * For example, specifying that a Button should use a scale factor of 2.0 may increase its
     * padding and font size by that factor.
     *
     * @return the scale factor
     */
    float getBootstrapSize();

    /**
     * Sets the scale factor that should be used to scale a view from its baseline size.
     * For example, specifying that a Button should use a scale factor of 2.0 may increase its
     * padding and font size by that factor.
     *
     * @param bootstrapSize the scale factor
     */
    void setBootstrapSize(float bootstrapSize);

    /**
     * Convenience method that sets the scale factor using a default bootstrap size enum value.
     *
     * @param bootstrapSize a default scale factor
     */
    void setBootstrapSize(DefaultBootstrapSize bootstrapSize);

}
