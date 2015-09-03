package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

import com.beardedhen.androidbootstrap.api.BootstrapTheme;

public class BootstrapDrawableFactory {

    public static StateListDrawable bootstrapButton(Context context, BootstrapDrawableParams params) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        BootstrapTheme theme = params.getBootstrapTheme();
        int strokeWidth = params.getBootstrapSize().buttonLineHeight(context);
        int cornerRadius = params.getBootstrapSize().buttonCornerRadius(context);

        GradientDrawable defaultDrawable = new GradientDrawable();
        GradientDrawable activeDrawable = new GradientDrawable();
        GradientDrawable disabledDrawable = new GradientDrawable();

        if (!params.isShowOutline()) {
            defaultDrawable.setColor(theme.buttonDefaultFill(context));
            activeDrawable.setColor(theme.buttonActiveFill(context));
            disabledDrawable.setColor(theme.buttonDisabledFill(context));
        }

        defaultDrawable.setStroke(strokeWidth, theme.buttonDefaultEdge(context));
        activeDrawable.setStroke(strokeWidth, theme.buttonActiveEdge(context));
        disabledDrawable.setStroke(strokeWidth, theme.buttonDisabledEdge(context));

        if (Build.VERSION.SDK_INT >= 14) {
            stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, activeDrawable);
        }

        stateListDrawable.addState(new int[]{android.R.attr.state_activated}, activeDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, activeDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, activeDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disabledDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);

        if (params.isRoundedCorners()) {
            defaultDrawable.setCornerRadius(cornerRadius);
            activeDrawable.setCornerRadius(cornerRadius);
            disabledDrawable.setCornerRadius(cornerRadius);
        }
        return stateListDrawable;
    }

}
