package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.beardedhen.androidbootstrap.api.BootstrapClassView;
import com.beardedhen.androidbootstrap.enums.BootstrapContext;

public class BootstrapButton extends FontAwesomeText implements BootstrapClassView {

    private boolean roundedCorners = false;

//    private enum BootstrapType {
//
//        private final String type;
//        private final int normalBg;
//        private final int roundedBg;
//        private final int textColour;
//
//        BootstrapType(String type, int normalBg, int roundedBg, int textColour) {
//            this.type = type;
//            this.normalBg = normalBg;
//            this.roundedBg = roundedBg;
//            this.textColour = textColour;
//        }
//
//        public static BootstrapType getBootstrapTypeFromString(String type) {
//            for (BootstrapType value : BootstrapType.values()) {
//                if (value.type.equals(type)) {
//                    return value;
//                }
//            }
//            return DEFAULT;
//        }
//
//        public int getTextColour() {
//            return textColour;
//        }
//
//        public int getRoundedBg() {
//            return roundedBg;
//        }
//
//        public int getNormalBg() {
//            return normalBg;
//        }
//    }

    private enum BootstrapSize {

        LARGE("large", 20.0f, 15, 20),
        DEFAULT("default", 14.0f, 10, 15),
        SMALL("small", 12.0f, 5, 10),
        XSMALL("xsmall", 10.0f, 2, 5);

        private final float fontSize;
        private final String type;
        private final int paddingA;
        private final int paddingB;

        BootstrapSize(String type, float fontSize, int paddingA, int paddingB) {
            this.type = type;
            this.fontSize = fontSize;
            this.paddingA = paddingA;
            this.paddingB = paddingB;
        }

        public float getFontSize() {
            return fontSize;
        }

        public static BootstrapSize getBootstrapSizeFromString(String size) {
            for (BootstrapSize value : BootstrapSize.values()) {
                if (value.type.equals(size)) {
                    return value;
                }
            }
            return DEFAULT;
        }
    }

    public BootstrapButton(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapButton(Context context, AttributeSet attrs, int defStyle) {
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

                roundedCorners = a.getBoolean(R.styleable.BootstrapButton_bb_roundedCorners, false);

                if (a.getString(R.styleable.BootstrapButton_android_textSize) != null) {
                    float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                    float defaultDimen = FontAwesomeIconMap.DEFAULT_FONT_SIZE * scaledDensity;

                    float rawSize = a.getDimension(R.styleable.BootstrapButton_android_textSize, defaultDimen);
                }
            }
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    /**
     * Specifies whether the BootstrapButton is enabled or disabled
     *
     * @param enabled - boolean state for either enabled or disabled
     */
    public void setBootstrapButtonEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }

    @Override public void setBootstrapClass(BootstrapContext bootstrapContext) {

//        DEFAULT("default", , R.color.black),
//                PRIMARY("primary", R.drawable.bbuton_primary, R.drawable.bbuton_primary_rounded, R.color.white),
//                SUCCESS("success", R.drawable.bbuton_success, R.drawable.bbuton_success_rounded, R.color.white),
//                INFO("info", R.drawable.bbuton_info, R.drawable.bbuton_info_rounded, R.color.white),
//                WARNING("warning", R.drawable.bbuton_warning, R.drawable.bbuton_warning_rounded, R.color.white),
//                DANGER("danger", R.drawable.bbuton_danger, R.drawable.bbuton_danger_rounded, R.color.white),
//                INVERSE("inverse", R.drawable.bbuton_inverse, R.drawable.bbuton_inverse_rounded, R.color.white);

        int resId = 0;
        int textColor = 0;

        switch (bootstrapContext) {
            case PRIMARY:
                resId = roundedCorners ? R.drawable.bbuton_primary : R.drawable.bbuton_primary_rounded;
                break;
            default:
                resId = roundedCorners ? R.drawable.bbuton_default : R.drawable.bbuton_default_rounded;
                break;
        }

        setBackground(getResources().getDrawable(resId));
        setTextColor(getResources().getColor(android.R.color.white));
    }

}
