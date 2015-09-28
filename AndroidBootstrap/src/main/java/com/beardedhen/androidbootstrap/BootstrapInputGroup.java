package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapAddon;

class BootstrapInputGroup extends LinearLayout { // TODO implement!

 // TODO should allow the addition of "AddOn" implementations to left/right
    // otherwise should just be modified linearlayout

    private View leftAddon;
    private View rightAddon;
    private BootstrapEditText inputView;

    public BootstrapInputGroup(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapInputGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapInputGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {

    }

    public void setLeftAddonView(View view) {
        if (view instanceof BootstrapAddon) {

            if (this.leftAddon != null) {
                removeViewAt(0);
            }
            this.leftAddon = view;
            addView(view, 0);
        }
        else {
            throw new IllegalArgumentException("View must implement BootstrapAddon!");
        }
    }



}
