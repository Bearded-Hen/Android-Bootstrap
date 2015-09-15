package com.beardedhen.androidbootstrap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.attributes.LabelTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;

public class BootstrapDrawableFactory {

    // TODO refactor params to parameters for button
    public static StateListDrawable bootstrapButton(Context context,
                                                    BootstrapTheme theme,
                                                    BootstrapSize bootstrapSize,
                                                    BootstrapButton.Position position,
                                                    boolean showOutline,
                                                    boolean rounded) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        int strokeWidth = bootstrapSize.buttonLineHeight(context);
        int cornerRadius = bootstrapSize.buttonCornerRadius(context);

        GradientDrawable defaultDrawable = new GradientDrawable();
        GradientDrawable activeDrawable = new GradientDrawable();
        GradientDrawable disabledDrawable = new GradientDrawable();

        if (showOutline) {
            activeDrawable.setColor(theme.activeFill(context));
        }
        else {
            defaultDrawable.setColor(theme.defaultFill(context));
            activeDrawable.setColor(theme.activeFill(context));
            disabledDrawable.setColor(theme.disabledFill(context));
        }

        defaultDrawable.setStroke(strokeWidth, theme.defaultEdge(context));
        activeDrawable.setStroke(strokeWidth, theme.activeEdge(context));
        disabledDrawable.setStroke(strokeWidth, theme.disabledEdge(context));

        if (Build.VERSION.SDK_INT >= 14) {
            stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, activeDrawable);
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_activated}, activeDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, activeDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, activeDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, activeDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disabledDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);

        if (rounded) {
            if (position == BootstrapButton.Position.SOLO) {
                defaultDrawable.setCornerRadius(cornerRadius);
                activeDrawable.setCornerRadius(cornerRadius);
                disabledDrawable.setCornerRadius(cornerRadius);
            }
            else {
                float[] radii = calculateCorners(position, cornerRadius);
                defaultDrawable.setCornerRadii(radii);
                activeDrawable.setCornerRadii(radii);
                disabledDrawable.setCornerRadii(radii);
            }
        }
        return stateListDrawable;
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
    public static ColorStateList bootstrapButtonText(Context context,
                                                     boolean outline,
                                                     BootstrapTheme theme) {
        int defaultColor;
        int white = context.getResources().getColor(android.R.color.white);

        if (theme == DefaultBootstrapTheme.LINK) { // special case
            defaultColor = theme.textColor(context);
        }
        else {
            defaultColor = outline ? theme.defaultEdge(context) : theme.textColor(context);
        }

        if (outline) {
            boolean hover = Build.VERSION.SDK_INT >= 14;
            int stateSize = hover ? 6 : 5;

            int[][] states = new int[stateSize][];
            int[] colors = new int[stateSize];
            int index = 0;

            if (hover) {
                states[index] = new int[]{android.R.attr.state_hovered};
                colors[index] = white;
                index++;
            }

            states[index] = new int[]{android.R.attr.state_activated};
            colors[index] = white;
            index++;

            states[index] = new int[]{android.R.attr.state_focused};
            colors[index] = white;
            index++;

            states[index] = new int[]{android.R.attr.state_selected};
            colors[index] = white;
            index++;

            states[index] = new int[]{android.R.attr.state_pressed};
            colors[index] = white;
            index++;

            states[index] = new int[]{};
            colors[index] = defaultColor;

            return new ColorStateList(states, colors);
        }
        else {
            int[] colors = new int[]{defaultColor};
            int[][] states = {new int[]{}};
            return new ColorStateList(states, colors);
        }
    }

    public static Drawable bootstrapLabel(Context context,
                                          LabelTheme theme,
                                          boolean rounded,
                                          float height) {

        int cornerRadius = context.getResources().getDimensionPixelSize(R.dimen.bootstrap_label_corner_radius);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(theme.defaultFill(context));

        // corner radius should be half height
        drawable.setCornerRadius(rounded ? height / 2 : cornerRadius);

        return drawable;
    }

}
