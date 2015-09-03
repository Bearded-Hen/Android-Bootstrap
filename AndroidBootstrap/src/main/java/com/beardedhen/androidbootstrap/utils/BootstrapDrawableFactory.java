package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import com.beardedhen.androidbootstrap.api.BootstrapTheme;

public class BootstrapDrawableFactory {

    public static StateListDrawable bootstrapButton(Context context, BootstrapDrawableParams params) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        // FIXME magic numbers (should set according to Bootstrap size)
        int strokeWidth = 4;
        int cornerRadius = 16;

        BootstrapTheme theme = params.getBootstrapTheme();

        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(theme.buttonDefaultFill(context));
        defaultDrawable.setStroke(strokeWidth, theme.buttonDefaultEdge(context));

        GradientDrawable pressedDrawable = new GradientDrawable();
        pressedDrawable.setColor(theme.buttonActiveFill(context));
        pressedDrawable.setStroke(strokeWidth, theme.buttonActiveEdge(context));

        GradientDrawable disabledDrawable = new GradientDrawable();
        pressedDrawable.setColor(theme.buttonDisabledFill(context));
        pressedDrawable.setStroke(strokeWidth, theme.buttonDisabledEdge(context));

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disabledDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);

        if (params.isRoundedCorners()) {
            defaultDrawable.setCornerRadius(cornerRadius);
            pressedDrawable.setCornerRadius(cornerRadius);
            disabledDrawable.setCornerRadius(cornerRadius);
        }
        return stateListDrawable;
    }

}
