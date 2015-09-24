package com.beardedhen.androidbootstrap.api.view;

import android.support.annotation.NonNull;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * Views which implement this interface display placeholder text until their content is filled.
 */
public interface PlaceholderTextView {

    String KEY = "com.beardedhen.androidbootstrap.api.view.PlaceholderTextView";

    /**
     * Sets the text which should be displayed as a placeholder in this view
     *
     * @param text the placeholder text
     */
    void setPlaceholderText(CharSequence text);

    /**
     * @return the current placeholder text
     */
    @NonNull CharSequence getPlaceholderText();

}
