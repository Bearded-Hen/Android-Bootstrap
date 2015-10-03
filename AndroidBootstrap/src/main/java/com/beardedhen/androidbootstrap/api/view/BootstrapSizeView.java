package com.beardedhen.androidbootstrap.api.view;

import android.support.annotation.Nullable;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;

// TODO document/finalise
public interface BootstrapSizeView {

    void setBootstrapSize(@Nullable BootstrapSize bootstrapSize);

    @Nullable BootstrapSize getBootstrapSize();

}
