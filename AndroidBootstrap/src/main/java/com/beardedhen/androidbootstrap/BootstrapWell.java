package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;
import com.beardedhen.androidbootstrap.utils.ViewUtils;

/**
 * BootstrapWells are used as a container layout for other views, typically text.
 */
public class BootstrapWell extends FrameLayout {

    private float bootstrapSize;

    public BootstrapWell(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapWell(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapWell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);

        try {
            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, -1);
            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
        }
        finally {
            a.recycle();
        }
        updateBootstrapState();
    }

    private void updateBootstrapState() {
        Drawable bg = BootstrapDrawableFactory.bootstrapWell(ColorUtils.resolveColor(R.color.bootstrap_well_background, getContext()),
                (int) (DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_well_corner_radius) * bootstrapSize / 2),
                (int) DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_well_stroke_width),
                ColorUtils.resolveColor(R.color.bootstrap_well_border_color, getContext()));

        ViewUtils.setBackgroundDrawable(this, bg);

        int padding = (int) (DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_well_default_padding) * bootstrapSize * 2.5);
        setPadding(padding, padding, padding, padding);
    }
}
