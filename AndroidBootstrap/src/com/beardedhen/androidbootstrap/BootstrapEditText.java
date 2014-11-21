package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

public class BootstrapEditText extends EditText {

    private enum TextState {

        DEFAULT("default",  R.drawable.edittext_background_rounded,         R.drawable.edittext_background),
        SUCCESS("success",  R.drawable.edittext_background_rounded_success, R.drawable.edittext_background_success),
        WARNING("warning",  R.drawable.edittext_background_rounded_warning, R.drawable.edittext_background_warning),
        DANGER("danger",    R.drawable.edittext_background_rounded_danger,  R.drawable.edittext_background_danger);

        private String state;
        private int roundedBg;
        private int normalBg;

        private TextState(String state, int roundedBg, int normalBg) {
            this.state = state;
            this.roundedBg = roundedBg;
            this.normalBg = normalBg;
        }

        public static TextState getStateFromString(String state) {
            for (TextState value : TextState.values()) {
                if (value.state.equals(state)) {
                    return value;
                }
            }
            return DEFAULT;
        }

        public int getRoundedBg() {
            return roundedBg;
        }

        public int getNormalBg() {
            return normalBg;
        }
    }

	private boolean roundedCorners = false;
    private TextState textState;

    public BootstrapEditText(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialise(attrs);
	}

	private void initialise( AttributeSet attrs )
	{
		TypedArray a = getContext().obtainStyledAttributes(attrs,  R.styleable.BootstrapEditText);

        try {
            //get defaults
            float fontSize = FontAwesome.DEFAULT_FONT_SIZE;
            String state = "default";
            String text = "";
            String hint = "";
            boolean enabled = true;

            //font size
            if (a.getString(R.styleable.BootstrapEditText_android_textSize) != null) {
                float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                float rawSize = a.getDimension(R.styleable.BootstrapEditText_android_textSize, FontAwesome.DEFAULT_FONT_SIZE * scaledDensity);
                fontSize = rawSize / scaledDensity;
            }

            //rounded corners
            if(a.getString(R.styleable.BootstrapEditText_be_roundedCorners) != null) {
                roundedCorners = a.getBoolean(R.styleable.BootstrapEditText_be_roundedCorners, false);
            }

            //state
            if(a.getString(R.styleable.BootstrapEditText_be_state) != null) {
                state = a.getString(R.styleable.BootstrapEditText_be_state);
            }

            //text
            if(a.getString(R.styleable.BootstrapEditText_android_text) != null) {
                text = a.getString(R.styleable.BootstrapEditText_android_text);
            }

            //hint
            if(a.getString(R.styleable.BootstrapEditText_android_hint) != null) {
                hint = a.getString(R.styleable.BootstrapEditText_android_hint);
            }

            //enabled
            if(a.getString(R.styleable.BootstrapEditText_android_enabled) != null) {
                enabled = a.getBoolean(R.styleable.BootstrapEditText_android_enabled, true);
            }

            //set values
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
            this.setText(text);
            this.setHint(hint);
            this.setEnabled(enabled);

            if (enabled){
                textState = TextState.getStateFromString(state);
                setState(state);
            }
        }
        finally {
            a.recycle();
        }
	}

    private void setBackgroundDrawable(TextState textState)
    {
        this.textState = textState;

        if (roundedCorners) {
            this.setBackgroundResource(textState.getRoundedBg());
        } else {
            this.setBackgroundResource(textState.getNormalBg());
        }
    }
	
	/**
	 * Change the BootstrapEditTextState
	 * @param state a string of success, warning, danger, or default.
     * If the string is not recognised, then the state will be automatically set to default.
	 */
	public void setState(String state)
    {
        this.textState = TextState.getStateFromString(state);
		setBackgroundDrawable(textState);
	}
	
	/**
	 * Set the BootstrapEditText to a successful state
	 */
	public void setSuccess()
	{
		setBackgroundDrawable(TextState.SUCCESS);
	}
	
	/**
	 * Set the BootstrapEditText to a warning state
	 */
	public void setWarning()
	{
		setBackgroundDrawable(TextState.WARNING);
	}
	
	/**
	 * Set the BootstrapEditText to a danger state
	 */
	public void setDanger()
	{
		setBackgroundDrawable(TextState.DANGER);
	}
	
	/**
	 * Set the BootstrapEditText to a default state
	 */
	public void setDefault()
	{
		setBackgroundDrawable(TextState.DEFAULT);
	}
	
	/**
	 * Specifies whether the BootstrapEditText is enabled or disabled
	 * @param enabled - boolean state for either enabled or disabled
	 */
	public void setBootstrapEditTextEnabled(boolean enabled)
	{
		this.setEnabled(enabled);
	}
	
}
