package com.beardedhen.androidbootstrap.utils;

import com.beardedhen.androidbootstrap.enums.BootstrapContext;
import com.beardedhen.androidbootstrap.enums.BootstrapPadding;

public class BootstrapDrawable { // TODO programmatically generate drawables

    private final BootstrapContext bootstrapContext;
    private final  BootstrapPadding bootstrapPadding;

    private final boolean roundedCorners;
    private final boolean showOutline;

    private BootstrapDrawable(Builder builder) {
        this.bootstrapContext = builder.bootstrapContext;
        this.bootstrapPadding = builder.bootstrapPadding;
        this.roundedCorners = builder.roundedCorners;
        this.showOutline = builder.showOutline;
    }

    public static class Builder {

        private BootstrapContext bootstrapContext;
        private BootstrapPadding bootstrapPadding;

        private boolean roundedCorners;
        private boolean showOutline;

        public Builder() {
            bootstrapContext = BootstrapContext.PRIMARY;
            bootstrapPadding = BootstrapPadding.DEFAULT;
            roundedCorners = true;
            showOutline = false;
        }

        public Builder withBootstrapContext(BootstrapContext bootstrapContext) {
            this.bootstrapContext = bootstrapContext;
            return this;
        }

        public Builder withBootstrapPadding(BootstrapPadding bootstrapPadding) {
            this.bootstrapPadding = bootstrapPadding;
            return this;
        }

        public Builder showRoundedCorners(boolean roundedCorners) {
            this.roundedCorners = roundedCorners;
            return this;
        }

        public Builder showOutline(boolean showOutline) {
            this.showOutline = showOutline;
            return this;
        }
    }

}
