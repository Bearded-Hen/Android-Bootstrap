package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.text.TextPaint;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.ExpandDirection;
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

    static Drawable bootstrapAlert(Context context,
                                   BootstrapBrand bootstrapBrand) {

        GradientDrawable disabledGd = new GradientDrawable();

        int strokeWidth = context.getResources().getDimensionPixelSize(R.dimen.bootstrap_alert_stroke_width);

        disabledGd.setColor(ColorUtils.increaseOpacityFromInt(context, bootstrapBrand.getColor(),
                                                            40));
        disabledGd.setCornerRadius(6);
        disabledGd.setStroke(strokeWidth, ColorUtils.increaseOpacityFromInt(context, bootstrapBrand.getColor(), 70));
        return disabledGd;
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

    static Drawable bootstrapWell(@ColorInt int backgroundColor, int cornerRadius, int strokeWidth, @ColorInt int strokeColor) {
        GradientDrawable background = new GradientDrawable();
        background.setColor(backgroundColor);
        background.setCornerRadius(cornerRadius);
        background.setStroke(strokeWidth, strokeColor);
        return background;
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

    private static void setupDrawableCorners(ViewGroupPosition position, boolean rounded, int r,
                                             GradientDrawable defaultGd, GradientDrawable activeGd, GradientDrawable disabledGd) {
        if (rounded) {
            if (position == ViewGroupPosition.SOLO) {
                defaultGd.setCornerRadius(r);
                activeGd.setCornerRadius(r);
                disabledGd.setCornerRadius(r);
            }
            else {
                float[] radii; // X/Y pairs for top-left, top-right, bottom-right, bottom-left.

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

    static StateListDrawable bootstrapDropDownArrow(Context context, int width, int height, ExpandDirection expandDirection, boolean outline, BootstrapBrand brand) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        int defaultColor = outline ? brand.defaultFill(context) : brand.defaultTextColor(context);
        int activeColor = outline ? ColorUtils.resolveColor(android.R.color.white, context) : brand.activeTextColor(context);
        int disabledColor = outline ? brand.disabledFill(context) : brand.disabledTextColor(context);

        if (Build.VERSION.SDK_INT >= 14) {
            stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, createArrowIcon(context, width, height, activeColor, expandDirection));
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_activated}, createArrowIcon(context, width, height, activeColor, expandDirection));
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, createArrowIcon(context, width, height, activeColor, expandDirection));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createArrowIcon(context, width, height, activeColor, expandDirection));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, createArrowIcon(context, width, height, activeColor, expandDirection));
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, createArrowIcon(context, width, height, disabledColor, expandDirection));
        stateListDrawable.addState(new int[]{}, createArrowIcon(context, width, height, defaultColor, expandDirection));
        return stateListDrawable;
    }

    static StateListDrawable bootstrapAlertCloseIcon(Context context, int width, int height, int inset) {

        StateListDrawable stateListDrawable = new StateListDrawable();

        int defaultColor = ColorUtils.resolveColor(R.color.bootstrap_alert_cross_default, context);
        int activeColor = ColorUtils.resolveColor(R.color.bootstrap_gray, context);
        int disabledColor = ColorUtils.resolveColor(R.color.bootstrap_alert_cross_default, context);

        if (Build.VERSION.SDK_INT >= 14) {
            stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, createCloseCrossIcon(context, width, height, activeColor, inset));
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_activated}, createCloseCrossIcon(context, width, height, activeColor, inset));
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, createCloseCrossIcon(context, width, height, activeColor, inset));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createCloseCrossIcon(context, width, height, activeColor, inset));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, createCloseCrossIcon(context, width, height, activeColor, inset));
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, createCloseCrossIcon(context, width, height, disabledColor, inset));
        stateListDrawable.addState(new int[]{}, createCloseCrossIcon(context, width, height, defaultColor, inset));
        return stateListDrawable;
    }

    /**
     * Creates arrow icon that depends on ExpandDirection
     *
     * @param context context
     * @param width  width of icon in pixels
     * @param height height of icon in pixels
     * @param color arrow color
     * @param expandDirection arrow direction
     * @return icon drawable
     */
    private static Drawable createArrowIcon(Context context, int width, int height, int color, ExpandDirection expandDirection) {
        Bitmap canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(canvasBitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(color);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        switch (expandDirection) {
            case UP:
                path.moveTo(0, (height / 3) * 2);
                path.lineTo(width, (height / 3) * 2);
                path.lineTo(width / 2, height / 3);
                path.lineTo(0, (height / 3) * 2);
                break;
            case DOWN:
                path.moveTo(0, height / 3);
                path.lineTo(width, height / 3);
                path.lineTo(width / 2, (height / 3) * 2);
                path.lineTo(0, height / 3);
                break;
        }
        path.close();
        canvas.drawPath(path, paint);
        return new BitmapDrawable(context.getResources(), canvasBitmap);
    }

    private static Drawable createCloseCrossIcon(Context context, int width, int height, int color, int inset) {
        Bitmap canvasBitmap = Bitmap.createBitmap(width + inset * 2, height + inset * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(canvasBitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(color);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(inset, inset);
        path.lineTo(width + inset, height + inset);
        path.moveTo(width + inset, inset);
        path.lineTo(inset, height + inset);
        path.close();
        canvas.drawPath(path, paint);
        return new BitmapDrawable(context.getResources(), canvasBitmap);
    }

    public static Drawable createBadgeDrawable(Context context, BootstrapBrand brand, int width,
                                               int height, String badgeText, boolean insideAnObject) {

        if (badgeText == null) {
            return null;
        }
        else {
            Paint badgePaint = new Paint();
            Rect canvasBounds = new Rect();
            TextPaint badgeTextPaint = new TextPaint();
            badgePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
            badgeTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
            badgeTextPaint.setTextAlign(Paint.Align.CENTER);
            badgeTextPaint.setTextSize((float) (height * 0.7));

            if (insideAnObject) {
                badgePaint.setColor(brand.defaultTextColor(context));
                badgeTextPaint.setColor(brand.defaultFill(context));
            }
            else {
                badgePaint.setColor(brand.defaultFill(context));
                badgeTextPaint.setColor(brand.defaultTextColor(context));
            }

            int rectLength = (int) badgeTextPaint.measureText(badgeText);

            Bitmap canvasBitmap = Bitmap.createBitmap(width + rectLength, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(canvasBitmap);
            canvas.getClipBounds(canvasBounds);

            int firstCircleDx = canvasBounds.left + canvasBounds.height() / 2;
            int circleDy = canvasBounds.height() / 2;
            int circleRadius = canvasBounds.height() / 2;
            int secondCircleDx = firstCircleDx + rectLength;

            Rect rect = new Rect();
            rect.left = firstCircleDx;
            rect.top = 0;
            rect.right = rect.left + rectLength;
            rect.bottom = canvasBounds.height();

            canvas.drawCircle(firstCircleDx, circleDy, circleRadius, badgePaint);
            canvas.drawRect(rect, badgePaint);
            canvas.drawCircle(secondCircleDx, circleDy, circleRadius, badgePaint);
            canvas.drawText(badgeText, canvasBounds.width() / 2, canvasBounds.height() / 2 - ((badgeTextPaint.descent() +
                                                                                               badgeTextPaint.ascent()) / 2),
                            badgeTextPaint);

            return new BitmapDrawable(context.getResources(), canvasBitmap);
        }
    }

    static ColorStateList bootstrapDropDownViewText(Context context) {

        int defaultColor = ColorUtils.resolveColor(R.color.bootstrap_gray_dark, context);
        int activeColor = ColorUtils.resolveColor(android.R.color.black, context);
        int disabledColor = ColorUtils.resolveColor(R.color.bootstrap_gray_light, context);

        return new ColorStateList(getStateList(), getColorList(defaultColor, activeColor, disabledColor));
    }

    private static void setInsetOnLayers(LayerDrawable[] ary, int l, int t, int r, int b) {
        for (LayerDrawable ld : ary) {
            ld.setLayerInset(0, l, t, r, b);
        }
    }

}
