package com.beardedhen.androidbootstrap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;

/**
 * Provides a factory for generating Drawables which are used as the backgrounds for Bootstrap Views.
 */
class BootstrapDrawableFactory { // TODO tidy up

    static Drawable bootstrapButton(Context context,
                                           BootstrapBrand brand,
                                           BootstrapSize bootstrapSize,
                                           BootstrapButton.Position position,
                                           boolean showOutline,
                                           boolean rounded) {

        StateListDrawable stateListDrawable = new StateListDrawable();

        int strokeWidth = bootstrapSize.buttonLineHeight(context);
        int cornerRadius = bootstrapSize.buttonCornerRadius(context);

        GradientDrawable l2 = new GradientDrawable();
        l2.setColor(Color.RED);
        l2.setStroke(strokeWidth, brand.defaultEdge(context));

        LayerDrawable ld = new LayerDrawable(new Drawable[]{l2});
        ld.setLayerInset(0, 0, 0, 0, -strokeWidth);

        GradientDrawable defaultGd = new GradientDrawable();
        GradientDrawable activeGd = new GradientDrawable();
        GradientDrawable disabledGd = new GradientDrawable();

        if (showOutline) {
            activeGd.setColor(brand.activeFill(context));
        }
        else {
            defaultGd.setColor(brand.defaultFill(context));
            activeGd.setColor(brand.activeFill(context));
            disabledGd.setColor(brand.disabledFill(context));
        }

        defaultGd.setStroke(strokeWidth, brand.defaultEdge(context));
        activeGd.setStroke(strokeWidth, brand.activeEdge(context));
        disabledGd.setStroke(strokeWidth, brand.disabledEdge(context));

        if (rounded) {
            if (position == BootstrapButton.Position.SOLO) {
                defaultGd.setCornerRadius(cornerRadius);
                activeGd.setCornerRadius(cornerRadius);
                disabledGd.setCornerRadius(cornerRadius);
            }
            else {
                float[] radii = calculateCorners(position, cornerRadius);
                defaultGd.setCornerRadii(radii);
                activeGd.setCornerRadii(radii);
                disabledGd.setCornerRadii(radii);
            }
        }

        LayerDrawable defaultLayer = new LayerDrawable(new Drawable[]{defaultGd});
        LayerDrawable activeLayer = new LayerDrawable(new Drawable[]{activeGd});
        LayerDrawable disabledLayer = new LayerDrawable(new Drawable[]{disabledGd});

        LayerDrawable[] ldAry = new LayerDrawable[]{defaultLayer, activeLayer, disabledLayer};
        int n = strokeWidth * -1;

        // use LayerDrawable to hide strokes on one side of the drawable (if Button is in a group)
        switch (position) {
            case MIDDLE_HORI:
                setInsetOnLayers(ldAry, n, 0, 0, 0);
                break;
            case END:
                setInsetOnLayers(ldAry, n, 0, 0, 0);
                break;
            case MIDDLE_VERT:
                setInsetOnLayers(ldAry, 0, n, 0, 0);
                break;
            case BOTTOM:
                setInsetOnLayers(ldAry, 0, n, 0, 0);
        }

        if (Build.VERSION.SDK_INT >= 14) {
            stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, activeLayer);
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_activated}, activeLayer);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, activeLayer);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, activeLayer);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, activeLayer);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disabledLayer);
        stateListDrawable.addState(new int[]{}, defaultLayer);

        return stateListDrawable;
    }

    private static void setInsetOnLayers(LayerDrawable[] ary, int l, int t, int r, int b) {
        for (LayerDrawable ld : ary) {
            ld.setLayerInset(0, l, t, r, b);
        }
    }

    private static float[] calculateCorners(BootstrapButton.Position position, float r) {
        // X/Y pairs for top-left, top-right, bottom-right, bottom-left.

        switch (position) {
            case MIDDLE_HORI:
                return new float[]{0, 0, 0, 0, 0, 0, 0, 0};
            case MIDDLE_VERT:
                return new float[]{0, 0, 0, 0, 0, 0, 0, 0};
            case TOP:
                return new float[]{r, r, r, r, 0, 0, 0, 0};
            case BOTTOM:
                return new float[]{0, 0, 0, 0, r, r, r, r};
            case START:
                return new float[]{r, r, 0, 0, 0, 0, r, r,};
            case END:
                return new float[]{0, 0, r, r, r, r, 0, 0};
            default:
                return new float[]{0, 0, 0, 0, 0, 0, 0, 0};
        }
    }

    @SuppressLint("InlinedApi")
    static ColorStateList bootstrapButtonText(Context context,
                                                     boolean outline,
                                                     BootstrapBrand brand) {

        int defaultColor = outline ? brand.defaultFill(context) : brand.defaultTextColor(context);
        int activeColor = outline ? context.getResources().getColor(R.color.white) : brand.activeTextColor(context);
        int disabledColor = outline ? brand.disabledFill(context) : brand.disabledTextColor(context);

        boolean hover = Build.VERSION.SDK_INT >= 14;
        int stateSize = hover ? 7 : 6; // number of states

        int[][] states = new int[stateSize][];
        int[] colors = new int[stateSize];
        int index = 0;

        if (hover) {
            states[index] = new int[]{android.R.attr.state_hovered};
            colors[index] = activeColor;
            index++;
        }

        states[index] = new int[]{android.R.attr.state_activated};
        colors[index] = activeColor;
        index++;

        states[index] = new int[]{android.R.attr.state_focused};
        colors[index] = activeColor;
        index++;

        states[index] = new int[]{android.R.attr.state_selected};
        colors[index] = activeColor;
        index++;

        states[index] = new int[]{android.R.attr.state_pressed};
        colors[index] = activeColor;
        index++;

        states[index] = new int[]{-android.R.attr.state_enabled};
        colors[index] = disabledColor;
        index++;

        states[index] = new int[]{};
        colors[index] = defaultColor;

        return new ColorStateList(states, colors);
    }

    /**
     * Generates a Drawable for a Bootstrap Label background
     *
     * @param context        the current context
     * @param bootstrapBrand the BootstrapBrand theming whose colors should be used
     * @param rounded        whether the corners should be rounded or not
     * @param height         the view height in px
     * @return the Bootstrap Label background
     */
    static Drawable bootstrapLabel(Context context,
                                          BootstrapBrand bootstrapBrand,
                                          boolean rounded,
                                          float height) {

        int cornerRadius = context.getResources().getDimensionPixelSize(R.dimen.bootstrap_label_corner_radius);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(bootstrapBrand.defaultFill(context));

        // corner radius should be half height if rounded
        drawable.setCornerRadius(rounded ? height / 2 : cornerRadius);
        return drawable;
    }

}
