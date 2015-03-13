package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BootstrapButton extends FrameLayout {

    private TextView lblMiddle;
    private TextView lblRight;
    private TextView lblLeft;
    private ViewGroup layout;
    private boolean roundedCorners = false;

    private enum BootstrapType {
        DEFAULT("default", R.drawable.bbuton_default, R.drawable.bbuton_default_rounded, R.color.black),
        PRIMARY("primary", R.drawable.bbuton_primary, R.drawable.bbuton_primary_rounded, R.color.white),
        SUCCESS("success", R.drawable.bbuton_success, R.drawable.bbuton_success_rounded, R.color.white),
        INFO("info", R.drawable.bbuton_info, R.drawable.bbuton_info_rounded, R.color.white),
        WARNING("warning", R.drawable.bbuton_warning, R.drawable.bbuton_warning_rounded, R.color.white),
        DANGER("danger", R.drawable.bbuton_danger, R.drawable.bbuton_danger_rounded, R.color.white),
        INVERSE("inverse", R.drawable.bbuton_inverse, R.drawable.bbuton_inverse_rounded, R.color.white);

        private final String type;
        private final int normalBg;
        private final int roundedBg;
        private final int textColour;

        BootstrapType(String type, int normalBg, int roundedBg, int textColour) {
            this.type = type;
            this.normalBg = normalBg;
            this.roundedBg = roundedBg;
            this.textColour = textColour;
        }

        public static BootstrapType getBootstrapTypeFromString(String type) {
            for (BootstrapType value : BootstrapType.values()) {
                if (value.type.equals(type)) {
                    return value;
                }
            }
            return DEFAULT;
        }

        public int getTextColour() {
            return textColour;
        }

        public int getRoundedBg() {
            return roundedBg;
        }

        public int getNormalBg() {
            return normalBg;
        }
    }

    private enum BootstrapSize {

        LARGE("large", 20.0f, 15, 20),
        DEFAULT("default", 14.0f, 10, 15),
        SMALL("small", 12.0f, 5, 10),
        XSMALL("xsmall", 10.0f, 2, 5);

        private final float fontSize;
        private final String type;
        private final int paddingA;
        private final int paddingB;

        private BootstrapSize(String type, float fontSize, int paddingA, int paddingB) {
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

        float fontSize = FontAwesome.DEFAULT_FONT_SIZE;
        float scale = getResources().getDisplayMetrics().density; //for padding
        int paddingA;
        int paddingB;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);

        String iconLeft = "";
        String iconRight = "";
        String text = "";
        String gravity = "";
        String size = "default";
        String bootstrapStringType = "default";
        boolean enabled = true;

        try {
            if (a != null) {
                bootstrapStringType = a.getString(R.styleable.BootstrapButton_bb_type);
                bootstrapStringType = (bootstrapStringType == null) ? "default" : bootstrapStringType;

                // icons
                iconLeft = a.getString(R.styleable.BootstrapButton_bb_icon_left);
                iconLeft = (iconLeft == null) ? "" : iconLeft;

                iconRight = a.getString(R.styleable.BootstrapButton_bb_icon_right);
                iconRight = (iconRight == null) ? "" : iconRight;

                // text
                text = a.getString(R.styleable.BootstrapButton_android_text);
                text = (text == null) ? "" : text;

                gravity = a.getString(R.styleable.BootstrapButton_bb_text_gravity);
                gravity = (gravity == null) ? "" : gravity;

                // size
                size = a.getString(R.styleable.BootstrapButton_bb_size);
                size = (size == null) ? "default" : size;

                int layoutWidth = a.getLayoutDimension(R.styleable.BootstrapButton_android_layout_width, 0);
                boolean fillparent = (layoutWidth == LayoutParams.MATCH_PARENT);

                Float layoutWeight = a.getFloat(R.styleable.BootstrapButton_android_layout_weight, -1);
                fillparent = (layoutWeight != -1) || fillparent;

                roundedCorners = a.getBoolean(R.styleable.BootstrapButton_bb_roundedCorners, false);
                enabled = a.getBoolean(R.styleable.BootstrapButton_android_enabled, true);

                if (a.getString(R.styleable.BootstrapButton_android_textSize) != null) {
                    float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                    float defaultDimen = FontAwesome.DEFAULT_FONT_SIZE * scaledDensity;

                    float rawSize = a.getDimension(R.styleable.BootstrapButton_android_textSize, defaultDimen);
                    fontSize = rawSize / scaledDensity;
                }
            }
        } finally {
            if (a != null) {
                a.recycle();
            }
        }

        View v = inflater.inflate(R.layout.bootstrap_button, this, false);

        BootstrapSize bootstrapSize = BootstrapSize.getBootstrapSizeFromString(size);

        paddingA = (int) (bootstrapSize.paddingA * scale + 0.5f);
        paddingB = (int) (bootstrapSize.paddingB * scale + 0.5f);

        //get layout items
        layout = (ViewGroup) v.findViewById(R.id.layout);
        lblLeft = (TextView) v.findViewById(R.id.lblLeft);
        lblMiddle = (TextView) v.findViewById(R.id.lblMiddle);
        lblRight = (TextView) v.findViewById(R.id.lblRight);

        setBootstrapType(bootstrapStringType);
        //set the font awesome icon typeface

        if (!isInEditMode()) {
            lblLeft.setTypeface(FontAwesome.getFont(getContext()));
            lblRight.setTypeface(FontAwesome.getFont(getContext()));
        }

        //set up the font size
        lblLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);

        //deal with gravity
        if (gravity.length() > 0) {
            setTextGravity(gravity);
        }

        boolean onlyIcon = true;

        //set the text
        if (text.length() > 0) {
            lblMiddle.setText(text);
            lblMiddle.setVisibility(View.VISIBLE);
            onlyIcon = false;
        }

        setupIconLeft(paddingA, paddingB, iconLeft, iconRight, onlyIcon);
        setupIconRight(paddingA, paddingB, iconLeft, iconRight, onlyIcon);

        if (iconLeft.length() > 0 && iconRight.length() > 0) {
            lblMiddle.setPadding(paddingA, 0, paddingA, 0);
        }

        this.setClickable(true);
        this.setEnabled(enabled);

        layout.setPadding(0, paddingB, 0, paddingB);

        addView(v);
    }

    private void setupIconLeft(int paddingA, int paddingB, String iconLeft, String iconRight, boolean onlyIcon) {
        //set up the padding
        if (iconLeft.length() > 0) {
            setLeftIcon(iconLeft);
            lblLeft.setVisibility(View.VISIBLE);

            if (!onlyIcon) {
                lblLeft.setPadding(paddingB, 0, 0, 0);
            }
            else {
                lblLeft.setPadding(paddingB, 0, paddingB, 0);
            }

            //padding for symmetry
            if ((iconRight.length() == 0) && !onlyIcon) {
                lblMiddle.setPadding(paddingA, 0, paddingB, 0);
            }
        }
    }

    private void setupIconRight(int paddingA, int paddingB, String iconLeft, String iconRight, boolean onlyIcon) {
        if (iconRight.length() > 0) {
            setRightIcon(iconRight);
            lblRight.setVisibility(View.VISIBLE);

            if (!onlyIcon) {
                lblRight.setPadding(0, 0, paddingB, 0);
            }
            else {
                lblRight.setPadding(paddingB, 0, paddingB, 0);
            }

            //padding for symmetry
            if ((iconLeft.length() == 0) && !onlyIcon) {
                lblMiddle.setPadding(paddingB, 0, paddingA, 0);
            }
        }
    }

    public void setText(int stringId) {
        setText(getContext().getResources().getString(stringId));
    }

    /**
     * Changes the button text
     *
     * @param text - String value for what is displayed on the button
     */
    public void setText(String text) {
        lblMiddle.setText(text);
    }

    /**
     * Changes the left icon on a BootstrapButton
     *
     * @param leftIcon- String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
     */
    public void setLeftIcon(String leftIcon) {
        lblLeft.setText(FontAwesome.getUnicode(leftIcon));
    }

    /**
     * Changes the right icon on a BootstrapButton
     *
     * @param rightIcon - String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
     */
    public void setRightIcon(String rightIcon) {
        lblRight.setText(FontAwesome.getUnicode(rightIcon));
    }

    /**
     * Changes the type of BootstrapButton
     *
     * @param bootstrapType - String value for the type of button e.g. "primary"
     */
    public void setBootstrapType(String bootstrapType) {
        BootstrapType type = BootstrapType.getBootstrapTypeFromString(bootstrapType);

        int buttonBg = (roundedCorners) ? type.getRoundedBg() : type.getNormalBg();
        layout.setBackgroundResource(buttonBg);

        int textColor = getResources().getColor(type.getTextColour());

        lblLeft.setTextColor(textColor);
        lblMiddle.setTextColor(textColor);
        lblRight.setTextColor(textColor);
    }

    /**
     * Specifies whether the BootstrapButton is enabled or disabled
     *
     * @param enabled - boolean state for either enabled or disabled
     */
    public void setBootstrapButtonEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }

    /**
     * Changes the gravity for the text on a bootstrap button that is not wrap_content
     *
     * @param gravity - string for either center, right, or left.
     */
    public void setTextGravity(String gravity) {
        int gravityId = -1;

        switch (gravity) {
            case "left":
                gravityId = Gravity.LEFT;
                break;
            case "center":
                gravityId = Gravity.CENTER_HORIZONTAL;
                break;
            case "right":
                gravityId = Gravity.RIGHT;
                break;
        }

        if (gravityId != -1) {
            lblMiddle.setGravity(gravityId | Gravity.CENTER_VERTICAL);
        }
    }

    /**
     * Returns the text the BootstrapButton is displaying.
     *
     * @return CharSequence of text displayed
     */
    public CharSequence getText() {
        return lblMiddle.getText();
    }

}
