package com.beardedhen.androidbootstrap.utils;

import com.beardedhen.androidbootstrap.enums.BootstrapType;

public class BootstrapDrawableParams {

    private BootstrapType bootstrapType;
    private boolean roundedCorners;
    private boolean showOutline;

    public BootstrapDrawableParams() {
        bootstrapType = BootstrapType.PRIMARY;
        roundedCorners = true;
        showOutline = false;
    }

    public BootstrapDrawableParams withBootstrapContext(BootstrapType bootstrapType) {
        this.bootstrapType = bootstrapType;
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

    public BootstrapType getBootstrapType() {
        return bootstrapType;
    }

    public boolean isRoundedCorners() {
        return roundedCorners;
    }

    public boolean isShowOutline() {
        return showOutline;
    }
}
