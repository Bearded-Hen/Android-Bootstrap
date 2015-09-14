package com.beardedhen.androidbootstrap.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

import com.beardedhen.androidbootstrap.R;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapHeading;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.attributes.LabelTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;

public class BootstrapDrawableFactory {

    // TODO refactor params to parameters for button
    public static StateListDrawable bootstrapButton(Context context, BootstrapDrawableParams params) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        BootstrapTheme theme = params.getBootstrapTheme();
        int strokeWidth = params.getBootstrapSize().buttonLineHeight(context);
        int cornerRadius = params.getBootstrapSize().buttonCornerRadius(context);

        GradientDrawable defaultDrawable = new GradientDrawable();
        GradientDrawable activeDrawable = new GradientDrawable();
        GradientDrawable disabledDrawable = new GradientDrawable();

        if (params.isShowOutline()) {
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

        if (params.isRoundedCorners()) {
            defaultDrawable.setCornerRadius(cornerRadius);
            activeDrawable.setCornerRadius(cornerRadius);
            disabledDrawable.setCornerRadius(cornerRadius);
        }
        return stateListDrawable;
    }

    @SuppressLint("InlinedApi")
    public static ColorStateList bootstrapButtonText(Context context, BootstrapDrawableParams params) {
        BootstrapTheme theme = params.getBootstrapTheme();
        int defaultColor;
        int white = context.getResources().getColor(android.R.color.white);

        if (theme == DefaultBootstrapTheme.LINK) { // special case
            defaultColor = theme.textColor(context);
        }
        else {
            defaultColor = params.isShowOutline() ? theme.defaultEdge(context) : theme.textColor(context);
        }

        if (params.isShowOutline()) {
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
                                          BootstrapHeading bootstrapHeading,
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
