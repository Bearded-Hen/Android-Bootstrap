package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

/**
 * Provides a factory for generating Drawables which are used as the backgrounds for Bootstrap Views.
 * This avoids needing to define hundreds of XML resource files.
 */
class BootstrapDrawableFactory {

    /**
     * Generates a background drawable for a Bootstrap Button
     *
     * @param context      the current context
     * @param brand        the bootstrap brand
     * @param strokeWidth  the stroke width in px
     * @param cornerRadius the corner radius in px
     * @param position     the position of the button in its parent view
     * @param showOutline  whether the button should be outlined
     * @param rounded      whether the corners should be rounded
     * @return a background drawable for the BootstrapButton
     */
    static Drawable bootstrapButton(Context context,
                                    BootstrapBrand brand,
                                    int strokeWidth,
                                    int cornerRadius,
                                    ViewGroupPosition position,
                                    boolean showOutline,
                                    boolean rounded) {

        GradientDrawable defaultGd = new GradientDrawable();
        GradientDrawable activeGd = new GradientDrawable();
        GradientDrawable disabledGd = new GradientDrawable();

        defaultGd.setColor(showOutline ? Color.TRANSPARENT : brand.defaultFill(context));
        activeGd.setColor(showOutline ? brand.activeFill(context) : brand.activeFill(context));
        disabledGd.setColor(showOutline ? Color.TRANSPARENT : brand.disabledFill(context));

        defaultGd.setStroke(strokeWidth, brand.defaultEdge(context));
        activeGd.setStroke(strokeWidth, brand.activeEdge(context));
        disabledGd.setStroke(strokeWidth, brand.disabledEdge(context));

        if (showOutline && brand instanceof DefaultBootstrapBrand) {
            DefaultBootstrapBrand db = (DefaultBootstrapBrand) brand;

            if (db == DefaultBootstrapBrand.SECONDARY) {
                int color = ColorUtils.resolveColor(R.color.bootstrap_brand_secondary_border, context);

                defaultGd.setStroke(strokeWidth, color);
                activeGd.setStroke(strokeWidth, color);
                disabledGd.setStroke(strokeWidth, color);
            }
        }

        setupDrawableCorners(position, rounded, cornerRadius, defaultGd, activeGd, disabledGd);
        return setupStateDrawable(position, strokeWidth, defaultGd, activeGd, disabledGd);
    }

    /**
     * Generates a Drawable for a Bootstrap Label background, according to state parameters
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

        int cornerRadius = (int) DimenUtils.pixelsFromDpResource(context, R.dimen.bootstrap_default_corner_radius);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(bootstrapBrand.defaultFill(context));

        // corner radius should be half height if rounded as a "Pill" label
        drawable.setCornerRadius(rounded ? height / 2 : cornerRadius);
        return drawable;
    }

    /**
     * Generates a Drawable for a Bootstrap Edit Text background
     *
     * @param context        the current context
     * @param bootstrapBrand the BootstrapBrand theming whose colors should be used
     * @param rounded        whether the corners should be rounded or not
     * @return the Bootstrap Edit Text background
     */
    static Drawable bootstrapEditText(Context context,
                                      BootstrapBrand bootstrapBrand,
                                      float strokeWidth,
                                      float cornerRadius,
                                      boolean rounded) {

        StateListDrawable drawable = new StateListDrawable();

        GradientDrawable activeDrawable = new GradientDrawable();
        GradientDrawable disabledDrawable = new GradientDrawable();
        GradientDrawable defaultDrawable = new GradientDrawable();

        activeDrawable.setColor(ColorUtils.resolveColor(android.R.color.white, context));
        disabledDrawable.setColor(ColorUtils.resolveColor(android.R.color.white, context));
        defaultDrawable.setColor(ColorUtils.resolveColor(android.R.color.white, context));

        if (rounded) {
            activeDrawable.setCornerRadius(cornerRadius);
            disabledDrawable.setCornerRadius(cornerRadius);
            defaultDrawable.setCornerRadius(cornerRadius);
        }

        // stroke is larger when focused
        int defaultBorder = ColorUtils.resolveColor(R.color.bootstrap_brand_secondary_border, context);
        int disabledBorder = ColorUtils.resolveColor(R.color.bootstrap_edittext_disabled, context);

        activeDrawable.setStroke((int) strokeWidth, bootstrapBrand.defaultEdge(context));
        disabledDrawable.setStroke((int) strokeWidth, disabledBorder);
        defaultDrawable.setStroke((int) strokeWidth, defaultBorder);

        drawable.addState(new int[]{android.R.attr.state_focused}, activeDrawable);
        drawable.addState(new int[]{-android.R.attr.state_enabled}, disabledDrawable);
        drawable.addState(new int[]{}, defaultDrawable);

        return drawable;
    }

    static Drawable bootstrapCircleThumbnail(Context context,
                                             BootstrapBrand bootstrapBrand,
                                             @ColorInt int outerBorderWidth,
                                             @ColorInt int bg) {

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(bg);
        drawable.setStroke(outerBorderWidth, bootstrapBrand.defaultEdge(context));
        return drawable;
    }

    static Drawable bootstrapThumbnail(Context context,
                                       BootstrapBrand bootstrapBrand,
                                       @ColorInt int outerBorderWidth,
                                       @ColorInt int bg,
                                       boolean rounded) {

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(bg);
        drawable.setStroke(outerBorderWidth, bootstrapBrand.defaultEdge(context));

        float r = DimenUtils.pixelsFromDpResource(context, R.dimen.bthumbnail_rounded_corner);

        if (rounded) {
            drawable.setCornerRadii(new float[]{r, r, r, r, r, r, r, r});
        }

        return drawable;
    }

    /**
     * Generates a colorstatelist for a bootstrap button
     *
     * @param context the current context
     * @param outline whether the button is outlined
     * @param brand   the button brand
     * @return the color state list
     */
    static ColorStateList bootstrapButtonText(Context context, boolean outline, BootstrapBrand brand) {

        int defaultColor = outline ? brand.defaultFill(context) : brand.defaultTextColor(context);
        int activeColor = outline ? ColorUtils.resolveColor(android.R.color.white, context) : brand.activeTextColor(context);
        int disabledColor = outline ? brand.disabledFill(context) : brand.disabledTextColor(context);

        if (outline && brand instanceof DefaultBootstrapBrand) { // special case
            DefaultBootstrapBrand db = (DefaultBootstrapBrand) brand;

            if (db == DefaultBootstrapBrand.SECONDARY) {
                defaultColor = ColorUtils.resolveColor(R.color.bootstrap_brand_secondary_border, context);
                disabledColor = defaultColor;
            }
        }
        return new ColorStateList(getStateList(), getColorList(defaultColor, activeColor, disabledColor));
    }

    private static StateListDrawable setupStateDrawable(ViewGroupPosition position, int strokeWidth, GradientDrawable defaultGd, GradientDrawable activeGd, GradientDrawable disabledGd) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        LayerDrawable defaultLayer = new LayerDrawable(new Drawable[]{defaultGd});
        LayerDrawable activeLayer = new LayerDrawable(new Drawable[]{activeGd});
        LayerDrawable disabledLayer = new LayerDrawable(new Drawable[]{disabledGd});

        LayerDrawable[] ldAry = new LayerDrawable[]{defaultLayer, activeLayer, disabledLayer};
        int n = strokeWidth * -1;

        // use LayerDrawable to hide strokes on one side of the drawable (if needed), using negative insets
        if (position != null) {
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

    private static void setupDrawableCorners(ViewGroupPosition position, boolean rounded, int cornerRadius, GradientDrawable defaultGd, GradientDrawable activeGd, GradientDrawable disabledGd) {
        if (rounded) {
            if (position == ViewGroupPosition.SOLO) {
                defaultGd.setCornerRadius(cornerRadius);
                activeGd.setCornerRadius(cornerRadius);
                disabledGd.setCornerRadius(cornerRadius);
            }
            else {
                float[] radii; // X/Y pairs for top-left, top-right, bottom-right, bottom-left.
                float r = cornerRadius;

                switch (position) {
                    case MIDDLE_HORI:
                        radii = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
                        break;
                    case MIDDLE_VERT:
                        radii = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
                        break;
                    case TOP:
                        radii = new float[]{r, r, r, r, 0, 0, 0, 0};
                        break;
                    case BOTTOM:
                        radii = new float[]{0, 0, 0, 0, r, r, r, r};
                        break;
                    case START:
                        radii = new float[]{r, r, 0, 0, 0, 0, r, r,};
                        break;
                    case END:
                        radii = new float[]{0, 0, r, r, r, r, 0, 0};
                        break;
                    default:
                        radii = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
                        break;
                }

                defaultGd.setCornerRadii(radii);
                activeGd.setCornerRadii(radii);
                disabledGd.setCornerRadii(radii);
            }
        }
    }

    private static int[][] getStateList() {
        if (Build.VERSION.SDK_INT >= 14) {
            return new int[][]
                    {new int[]{android.R.attr.state_hovered}, new int[]{android.R.attr.state_activated},
                            new int[]{android.R.attr.state_focused}, new int[]{android.R.attr.state_selected},
                            new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered},
                            new int[]{-android.R.attr.state_enabled}, new int[]{}};
        }
        else {
            return new int[][]
                    {new int[]{android.R.attr.state_activated}, new int[]{android.R.attr.state_focused},
                            new int[]{android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed},
                            new int[]{android.R.attr.state_hovered}, new int[]{-android.R.attr.state_enabled},
                            new int[]{}};
        }
    }

    private static int[] getColorList(int defaultColor, int activeColor, int disabledColor) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new int[]{activeColor, activeColor, activeColor, activeColor, activeColor,
                    activeColor, disabledColor, defaultColor};
        }
        else {
            return new int[]{activeColor, activeColor, activeColor, activeColor, activeColor,
                    disabledColor, defaultColor};
        }
    }

    private static void setInsetOnLayers(LayerDrawable[] ary, int l, int t, int r, int b) {
        for (LayerDrawable ld : ary) {
            ld.setLayerInset(0, l, t, r, b);
        }
    }

}
