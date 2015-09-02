package com.beardedhen.androidbootstrap.enums;

import android.content.Context;

import com.beardedhen.androidbootstrap.R;

public enum BootstrapType {

    PRIMARY,
    SECONDARY,
    SUCCESS,
    WARNING,
    DANGER,
    LINK,
    CUSTOM;

    public int buttonDefaultFill(Context context) {
        return context.getResources().getColor(R.color.bbutton_info);
    }

    public int buttonDefaultEdge(Context context) {
        return context.getResources().getColor(R.color.bbutton_danger_edge);
    }

    public int buttonPressedFill(Context context) {
        return context.getResources().getColor(R.color.bbutton_primary);
    }

    public int buttonPressedEdge(Context context) {
        return context.getResources().getColor(R.color.bbutton_success_edge);
    }

    public int buttonDisabledFill(Context context) {
        return context.getResources().getColor(R.color.bbutton_danger_disabled);
    }

    public int buttonDisabledEdge(Context context) {
        return context.getResources().getColor(R.color.bbutton_inverse_edge);
    }

}
