package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import com.beardedhen.androidbootstrap.enums.BootstrapType;

public class BootstrapDrawableFactory {

    public static StateListDrawable buildBootstrapButton(Context context, BootstrapDrawableParams params) {
        StateListDrawable stateListDrawable = new StateListDrawable();

        // FIXME magic numbers (should set according to Bootstrap size)

        BootstrapType bootstrapType = params.getBootstrapType();

        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(bootstrapType.buttonDefaultFill(context));
        defaultDrawable.setStroke(4, bootstrapType.buttonDefaultEdge(context));

        GradientDrawable pressedDrawable = new GradientDrawable();
        pressedDrawable.setColor(bootstrapType.buttonPressedFill(context));
        pressedDrawable.setStroke(4, bootstrapType.buttonPressedEdge(context));

        GradientDrawable disabledDrawable = new GradientDrawable();
        pressedDrawable.setColor(bootstrapType.buttonDisabledFill(context));
        pressedDrawable.setStroke(4, bootstrapType.buttonDisabledEdge(context));

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disabledDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);

        if (params.isRoundedCorners()) {
            defaultDrawable.setCornerRadius(16);
            pressedDrawable.setCornerRadius(16);
            disabledDrawable.setCornerRadius(16);
        }
        return stateListDrawable;
    }

}
