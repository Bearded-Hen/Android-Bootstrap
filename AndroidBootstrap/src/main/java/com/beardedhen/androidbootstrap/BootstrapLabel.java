package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapTypeView;
import com.beardedhen.androidbootstrap.enums.BootstrapType;

public class BootstrapLabel extends FontAwesomeText implements BootstrapTypeView {

    public BootstrapLabel(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapLabel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        float fontSize = FontAwesomeIconMap.DEFAULT_FONT_SIZE;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);

        String size = "default";
        String bootstrapStringType = "default";
        boolean enabled = true;

        try {
            if (a != null) {
                bootstrapStringType = a.getString(R.styleable.BootstrapButton_bb_type);
                bootstrapStringType = (bootstrapStringType == null) ? "default" : bootstrapStringType;

                // size
                size = a.getString(R.styleable.BootstrapButton_bb_size);
                size = (size == null) ? "default" : size;

            }
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    @Override public void setBootstrapType(BootstrapType bootstrapTypeView) {

    }
}
