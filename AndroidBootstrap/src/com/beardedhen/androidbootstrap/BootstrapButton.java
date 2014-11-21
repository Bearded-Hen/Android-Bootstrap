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
	private boolean fillparent = false;

    private enum BootstrapType
    {
        DEFAULT("default",  R.drawable.bbuton_default,  R.drawable.bbuton_default_rounded,  R.color.black),
        PRIMARY("primary",  R.drawable.bbuton_primary,  R.drawable.bbuton_primary_rounded,  R.color.white),
        SUCCESS("success",  R.drawable.bbuton_success,  R.drawable.bbuton_success_rounded,  R.color.white),
        INFO(   "info",     R.drawable.bbuton_info,     R.drawable.bbuton_info_rounded,     R.color.white),
        WARNING("warning",  R.drawable.bbuton_warning,  R.drawable.bbuton_warning_rounded,  R.color.white),
        DANGER( "danger",   R.drawable.bbuton_danger,   R.drawable.bbuton_danger_rounded,   R.color.white),
        INVERSE("inverse",  R.drawable.bbuton_inverse,  R.drawable.bbuton_inverse_rounded,  R.color.white),;

        private String type;
        private int normalBg;
        private int roundedBg;
        private int textColour;

        BootstrapType(String type, int normalBg, int roundedBg, int textColour)
        {
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

	private void initialise(AttributeSet attrs)
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());

		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);
		
		//defaults
		String bootstrapStringType = "default";
		String iconLeft = "";
		String iconRight = "";
		String text = "";
		float fontSize = FontAwesome.DEFAULT_FONT_SIZE;
		float scale = getResources().getDisplayMetrics().density; //for padding
		String size = "default";
		int paddingA = (int) (10 *scale + 0.5f);
		int paddingB = (int) (15 *scale + 0.5f);

		//attribute values
//        try {
            if (a.getString(R.styleable.BootstrapButton_bb_type) != null) {
                bootstrapStringType = a.getString(R.styleable.BootstrapButton_bb_type);
            }

            if (a.getString(R.styleable.BootstrapButton_bb_roundedCorners) != null) {
                roundedCorners = a.getBoolean(R.styleable.BootstrapButton_bb_roundedCorners, false) ;
            }

            if(a.getString(R.styleable.BootstrapButton_bb_size) != null) {
                size = a.getString(R.styleable.BootstrapButton_bb_size);
            }

            if ( a.getString(R.styleable.BootstrapButton_bb_icon_left) != null) {
                iconLeft =  a.getString(R.styleable.BootstrapButton_bb_icon_left );
            }

            if(a.getString(R.styleable.BootstrapButton_bb_icon_right) != null) {
                iconRight = a.getString(R.styleable.BootstrapButton_bb_icon_right );
            }

            if(a.getString(R.styleable.BootstrapButton_android_text) != null) {
                text = a.getString(R.styleable.BootstrapButton_android_text);
            }
            String gravity = "";
            if(a.getString(R.styleable.BootstrapButton_bb_text_gravity) != null) {
                gravity = a.getString(R.styleable.BootstrapButton_bb_text_gravity);
            }

            boolean enabled = true;
            if(a.getString(R.styleable.BootstrapButton_android_enabled) != null) {
                enabled = a.getBoolean(R.styleable.BootstrapButton_android_enabled, true);
            }

            int layoutWidth = 0;
            if(a.getString(R.styleable.BootstrapButton_android_layout_width) != null) {
                layoutWidth = a.getLayoutDimension(R.styleable.BootstrapButton_android_layout_width, 0);
            }

            //works even if it's fill_parent or match_parent
            if( (layoutWidth == LayoutParams.MATCH_PARENT)) {
                fillparent = true;
            }

            if(a.getString(R.styleable.BootstrapButton_android_textSize) != null) {
                float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                float rawSize = a.getDimension(R.styleable.BootstrapButton_android_textSize, 14.0f * scaledDensity);
                fontSize = rawSize / scaledDensity;
            }
//        }
//        finally {
            a.recycle();
//        }

		View v;
		if(fillparent){
			v = inflater.inflate(R.layout.bootstrap_button_fill, null, false);
		} else {
			 v = inflater.inflate(R.layout.bootstrap_button, this, false);
		}
		
		//set up font sizes and padding for different button sizes
		if(size.equals("large")){
			fontSize = 20.0f;
			paddingA = (int) (15 *scale + 0.5f);
			paddingB = (int) (20 *scale + 0.5f);
		}
		
		if(size.equals("small")){
			fontSize = 12.0f;
			paddingA = (int) (5 *scale + 0.5f);
			paddingB = (int) (10 *scale + 0.5f);
		}
		
		if(size.equals("xsmall")){
			fontSize = 10.0f;
			paddingA = (int) (2 *scale + 0.5f);
			paddingB = (int) (5 *scale + 0.5f);
		}
	
		//get layout items
		layout = (ViewGroup) v.findViewById(R.id.layout);
		lblLeft = (TextView) v.findViewById(R.id.lblLeft);
		lblMiddle = (TextView) v.findViewById(R.id.lblMiddle);
		lblRight = (TextView) v.findViewById(R.id.lblRight);

        setBootstrapType(bootstrapStringType);
		
		//set the font awesome icon typeface
		lblLeft.setTypeface(FontAwesome.getFont(getContext()));
		lblRight.setTypeface(FontAwesome.getFont(getContext()));
		
		//set up the font size
		lblLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
		
        //deal with gravity
        if(gravity.length() > 0) {
        	setTextGravity(gravity);
        }
        
        boolean onlyIcon = true;
        
        //set the text 
        if(text.length() > 0){
        	lblMiddle.setText(text );
        	lblMiddle.setVisibility(View.VISIBLE);
        	onlyIcon = false;
        }

        //set up the padding
        if (iconLeft.length() > 0) {
        	setLeftIcon(iconLeft);
        	lblLeft.setVisibility(View.VISIBLE);
        	
        	if (!onlyIcon){
        		lblLeft.setPadding(paddingB, 0, 0, 0);
        	} else {
        		lblLeft.setPadding(paddingB, 0, paddingB, 0);
        	}
        	
        	//padding for symmetry
        	if (( iconRight.length() == 0) && !onlyIcon) {
        		lblMiddle.setPadding(paddingA, 0, paddingB, 0);
        	}
        }
         
        if (iconRight.length() > 0) {
        	//lblRight.setText(iconRight);
        	setRightIcon(iconRight);
        	lblRight.setVisibility(View.VISIBLE);
        	
        	if (!onlyIcon){
        		lblRight.setPadding(0, 0, paddingB, 0);
        	}else {
        		lblRight.setPadding(paddingB, 0, paddingB, 0);
        	}

        	//padding for symmetry
        	if ( (iconLeft.length() == 0) && !onlyIcon) {
        		lblMiddle.setPadding(paddingB, 0, (int) paddingA, 0);
        	}
        }
        
        if(iconLeft.length() > 0 && iconRight.length() > 0 )
        {
        	lblMiddle.setPadding(paddingA, 0, paddingA, 0);
        }

        this.setClickable(true);
        this.setEnabled(enabled);

        layout.setPadding(0, paddingB, 0, paddingB);
        
		addView(v);
	}

    public void setText(int stringId) {
        setText(getContext().getResources().getString(stringId));
    }
	
	/**
	 * Changes the button text
	 * @param text - String value for what is displayed on the button
	 */
	public void setText(String text) {
		lblMiddle.setText(text);
	}

	/**
	 * Changes the left icon on a BootstrapButton
	 * @param leftIcon- String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
	 */
	public void setLeftIcon(String leftIcon) {
		lblLeft.setText(FontAwesome.getUnicode(leftIcon));
	}
	
	/**
	 * Changes the right icon on a BootstrapButton
	 * @param rightIcon - String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
	 */
	public void setRightIcon(String rightIcon) {
        lblRight.setText(FontAwesome.getUnicode(rightIcon));
	}
	
	/**
	 * Changes the type of BootstrapButton
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
	 * @param enabled - boolean state for either enabled or disabled
	 */
	public void setBootstrapButtonEnabled(boolean enabled)
	{
		this.setEnabled(enabled);
	}
	
	/**
	 * Changes the gravity for the text on a bootstrap button that is not wrap_content
	 * @param gravity - string for either center, right, or left.
	 */
	public void setTextGravity(String gravity) {
		if(gravity.equals("left")) {
			lblMiddle.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		} else if (gravity.equals("center")) {
			lblMiddle.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
		} else if (gravity.equals("right")) {
			lblMiddle.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
		}
	}

    /**
     * Returns the text the BootstrapButton is displaying.
     * @return CharSequence of text displayed
     */
    public CharSequence getText() {
        return lblMiddle.getText();
    }

}
