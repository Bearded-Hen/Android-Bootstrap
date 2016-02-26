package com.beardedhen.androidbootstrap.api.view;

import android.support.annotation.NonNull;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;

/**
 * Views which implement this interface change their color according to the given Bootstrap Brand
 */
public interface BootstrapBrandView {

    String KEY = "com.beardedhen.androidbootstrap.api.view.BootstrapBrandView";

    /**
     * Changes the color of the view to match the given Bootstrap Brand
     *
     * @param bootstrapBrand the Bootstrap Brand
     */
    void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand);

    /**
     * @return the current Bootstrap Brand
     */
    @NonNull BootstrapBrand getBootstrapBrand();

}
