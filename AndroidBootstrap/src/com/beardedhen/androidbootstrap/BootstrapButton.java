package com.beardedhen.androidbootstrap;

import java.util.HashMap;
import java.util.Map;
import com.beardedhen.androidbootstrap.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class BootstrapButton extends Button
{
    //private static int[] styleable = R.styleable.BootstrapButton;
    //private static int defStyle = R.style.BootstrapButton;
    //private static int attributeName = R.attr.bootstrapButtonStyle;

    private ButtonType defaultButtonType = ButtonType.DANGER;
    ButtonType type = defaultButtonType;

    private static Map<String, ButtonType> buttonTypes;
    private static Map<String, String> fontAwesomeMap;
    private static Typeface font;
    private String leftIcon = "";
    private String rightIcon = "";
    private String spacing = "   ";//space in dp between icon and text
    private boolean roundedCorners = false;
    private boolean gradient = false;
    private String typeString = "";

    public BootstrapButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public BootstrapButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.bootstrapButtonStyle);
    }

    public BootstrapButton(Context context)
    {
        this(context, null);
    }

    static{

        buttonTypes = new HashMap<String, ButtonType>();
        buttonTypes.put("default", ButtonType.DEFAULT);
        buttonTypes.put("primary", ButtonType.PRIMARY);
        buttonTypes.put("success", ButtonType.SUCCESS);
        buttonTypes.put("info", ButtonType.INFO);
        buttonTypes.put("warning", ButtonType.WARNING);
        buttonTypes.put("danger", ButtonType.DANGER);
        buttonTypes.put("inverse", ButtonType.INVERSE);
        buttonTypes.put("purple", ButtonType.PURPLE);

        fontAwesomeMap = FontAwesome.getFaMap();

    }

    private enum ButtonType
    {
        DEFAULT(R.drawable.button_default, R.drawable.button_default_rounded, R.drawable.button_default_gradient, R.drawable.button_default_gradient_rounded, R.color.black),
        PRIMARY(R.drawable.button_primary, R.drawable.button_primary_rounded, R.drawable.button_primary_gradient, R.drawable.button_primary_gradient_rounded, R.color.white),
        SUCCESS(R.drawable.button_success, R.drawable.button_success_rounded, R.drawable.button_success_gradient, R.drawable.button_success_gradient_rounded, R.color.white),
        INFO(R.drawable.button_info, R.drawable.button_info_rounded, R.drawable.button_info_gradient, R.drawable.button_info_gradient_rounded, R.color.white),
        WARNING(R.drawable.button_warning, R.drawable.button_warning_rounded, R.drawable.button_warning_gradient, R.drawable.button_warning_gradient_rounded, R.color.white),
        DANGER(R.drawable.button_danger, R.drawable.button_danger_rounded, R.drawable.button_danger_gradient, R.drawable.button_danger_gradient_rounded, R.color.white),
        INVERSE(R.drawable.button_inverse, R.drawable.button_inverse_rounded, R.drawable.button_inverse_gradient, R.drawable.button_inverse_gradient_rounded, R.color.white),
        PURPLE(R.drawable.button_purple, R.drawable.button_purple_rounded, R.drawable.button_purple_gradient, R.drawable.button_purple_gradient_rounded, R.color.white);


        private int squareDrawable;
        private int roundedDrawable;
        private int squareGradientDrawable;
        private int roundedGradientDrawable;
        private int textColor;

        ButtonType(int squareDrawable, int roundedDrawable, int squareGradientDrawable, int roundedGradientDrawable, int textColor)
        {
            this.squareDrawable = squareDrawable;
            this.roundedDrawable = roundedDrawable;
            this.squareGradientDrawable = squareGradientDrawable;
            this.roundedGradientDrawable = roundedGradientDrawable;
            this.textColor = textColor;
        }
    }

    private void init(Context context, AttributeSet attrs, int defStyle)
    {

        //this.scale = getResources().getDisplayMetrics().density;

        //get font
        readFont(getContext());

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BootstrapButton, defStyle, R.style.BootstrapButton);

        try
        {
            if(a.getString(R.styleable.BootstrapButton_bb_type) != null)
            {
                typeString = a.getString(R.styleable.BootstrapButton_bb_type);
            }

            if(a.getString(R.styleable.BootstrapButton_bb_icon_left) != null)
            {
                String leftIconKey = a.getString(R.styleable.BootstrapButton_bb_icon_left);
                this.leftIcon = fontAwesomeMap.get(leftIconKey);
                if(this.getText().length() != 0)
                {
                    this.leftIcon = this.leftIcon + this.spacing;
                }
            }

            if(a.getString(R.styleable.BootstrapButton_bb_icon_right) != null)
            {
                String rightIconKey = a.getString(R.styleable.BootstrapButton_bb_icon_right);
                this.rightIcon = fontAwesomeMap.get(rightIconKey);
                if(this.getText().length() != 0)
                {
                    this.rightIcon = this.spacing + this.rightIcon;
                }
            }

            if(a.getString(R.styleable.BootstrapButton_bb_roundedCorners) != null)
            {
                this.roundedCorners = a.getBoolean(R.styleable.BootstrapButton_bb_roundedCorners, false);

            }

            if(a.getString(R.styleable.BootstrapButton_bb_gradient) != null)
            {
                this.gradient = a.getBoolean(R.styleable.BootstrapButton_bb_gradient, false);
            }

        }
        finally
        {
            a.recycle();
        }


        this.setText(this.leftIcon + this.getText().toString() + this.rightIcon);

        this.type = buttonTypes.get(typeString);

        //int paddingDP = (int) (this.padding *scale + 0.5f);
        //this.setPadding(paddingDP, paddingDP, paddingDP, paddingDP);
        this.setTypeface(font);
        this.setTextColor(getResources().getColor(this.type.textColor));
        //gradient
        if(this.gradient == true)
        {
            //get round or square
            if(this.roundedCorners == true)
            {

                this.setBackgroundResource(this.type.roundedGradientDrawable);
            }
            else
            {
                this.setBackgroundResource(this.type.squareGradientDrawable);
            }
        }
        //non gradient
        else
        {
            //get round or square
            if(this.roundedCorners == true)
            {
                this.setBackgroundResource(this.type.roundedDrawable);
            }
            else
            {
                this.setBackgroundResource(this.type.squareDrawable);
            }
        }

    }

    //static class to read in font
    private static void readFont(Context context)
    {
        if(font == null){
            try {
                font = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");
            } catch (Exception e) {
                Log.e("BootstrapButton", "Could not get typeface because " + e.getMessage());
                font = Typeface.DEFAULT;
            }
        }

    }

}
