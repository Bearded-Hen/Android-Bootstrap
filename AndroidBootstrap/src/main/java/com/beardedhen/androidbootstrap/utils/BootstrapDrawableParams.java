package com.beardedhen.androidbootstrap.utils;

import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapTheme;

public class BootstrapDrawableParams {

    private BootstrapTheme bootstrapTheme;
    private boolean roundedCorners;
    private boolean showOutline;
    private boolean enabled;

    public BootstrapDrawableParams() {
        bootstrapTheme = DefaultBootstrapTheme.PRIMARY;
        roundedCorners = true;
        showOutline = false;
    }

    public BootstrapDrawableParams bootstrapType(BootstrapTheme bootstrapTheme) {
        this.bootstrapTheme = bootstrapTheme;
        return this;
    }

    public BootstrapDrawableParams showRoundedCorners(boolean roundedCorners) {
        this.roundedCorners = roundedCorners;
        return this;
    }

    public BootstrapDrawableParams showOutline(boolean showOutline) {
        this.showOutline = showOutline;
        return this;
    }

    public BootstrapDrawableParams enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public BootstrapTheme getBootstrapTheme() {
        return bootstrapTheme;
    }

    public boolean isRoundedCorners() {
        return roundedCorners;
    }

    public boolean isShowOutline() {
        return showOutline;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
