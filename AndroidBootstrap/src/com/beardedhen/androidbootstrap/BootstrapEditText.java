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
        DANGER( "danger",   R.drawable.edittext_background_rounded_danger,  R.drawable.edittext_background_danger);

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
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapEditText);

        float fontSize = FontAwesome.DEFAULT_FONT_SIZE;
        String state = "default";
        String text = "";
        String hint = "";
        boolean enabled = true;

        try {
            if (a.getString(R.styleable.BootstrapEditText_android_textSize) != null) {
                float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                float defaultDimen = FontAwesome.DEFAULT_FONT_SIZE * scaledDensity;

                float rawSize = a.getDimension(R.styleable.BootstrapEditText_android_textSize, defaultDimen);
                fontSize = rawSize / scaledDensity;
            }

            roundedCorners = a.getBoolean(R.styleable.BootstrapEditText_be_roundedCorners, false);

            //state
            state = a.getString(R.styleable.BootstrapEditText_be_state);
            state = (state == null) ? "default" : state;

            //text
            text = a.getString(R.styleable.BootstrapEditText_android_text);
            text = (text == null) ? "" : text;

            //hint
            hint = a.getString(R.styleable.BootstrapEditText_android_hint);
            hint = (hint == null) ? "" : hint;

            //enabled
            enabled = a.getBoolean(R.styleable.BootstrapEditText_android_enabled, true);
        }
        finally {
            a.recycle();
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
