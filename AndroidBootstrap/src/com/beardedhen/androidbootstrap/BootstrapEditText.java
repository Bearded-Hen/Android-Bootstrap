package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

public class BootstrapEditText extends EditText
{
    public static final String BOOTSTRAP_EDIT_TEXT_DEFAULT = "default";
    public static final String BOOTSTRAP_EDIT_TEXT_SUCCESS = "success";
    public static final String BOOTSTRAP_EDIT_TEXT_WARNING = "warning";
    public static final String BOOTSTRAP_EDIT_TEXT_DANGER = "danger";
    private static final String DEFAULT_STATE = "default"; //state to be in if no state is given

    private String state = DEFAULT_STATE;

    //private static int[] styleable = R.styleable.BootstrapEditText;
    //private static int defStyle = R.style.BootstrapEditText;
    //private static int attributeName = R.attr.bootstrapEditTextStyle;

    private boolean roundedCorners = false;

    public BootstrapEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public BootstrapEditText(Context context, AttributeSet attrs)
    {
        this(context, attrs, R.attr.bootstrapEditTextStyle);
    }

    public BootstrapEditText(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attrs, int defStyle)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BootstrapEditText, defStyle, R.style.BootstrapEditText);

        //rounded corners
        if(a.getString(R.styleable.BootstrapEditText_be_roundedCorners) != null) {
            roundedCorners = a.getBoolean(R.styleable.BootstrapEditText_be_roundedCorners, false);
        }

        //state
        if(a.getString(R.styleable.BootstrapEditText_be_state) != null) {
            state = a.getString(R.styleable.BootstrapEditText_be_state);
        }

        this.setBackgroundDrawable(state);

        a.recycle();
    }


    private void setBackgroundDrawable(String state)
    {
        if(roundedCorners){
            this.setBackgroundResource(R.drawable.edittext_background_rounded);
        } else {
            this.setBackgroundResource(R.drawable.edittext_background);
        }

        if(roundedCorners){

            if (state.equals(BOOTSTRAP_EDIT_TEXT_SUCCESS)){
                this.setBackgroundResource(R.drawable.edittext_background_rounded_success);
            } else if (state.equals(BOOTSTRAP_EDIT_TEXT_WARNING)){
                this.setBackgroundResource(R.drawable.edittext_background_rounded_warning);
            } else if (state.equals(BOOTSTRAP_EDIT_TEXT_DANGER)){
                this.setBackgroundResource(R.drawable.edittext_background_rounded_danger);
            }

        } else {

            if (state.equals(BOOTSTRAP_EDIT_TEXT_SUCCESS)){
                this.setBackgroundResource(R.drawable.edittext_background_success);
            } else if (state.equals(BOOTSTRAP_EDIT_TEXT_WARNING)){
                this.setBackgroundResource(R.drawable.edittext_background_warning);
            } else if (state.equals(BOOTSTRAP_EDIT_TEXT_DANGER)){
                this.setBackgroundResource(R.drawable.edittext_background_danger);
            }

        }
    }

    /**
     * Change the BootstrapEditTextState
     * @param state
     */
    public void setState(String state){
        setBackgroundDrawable(state);
    }

    /**
     * Set the BootstrapEditText to a successful state
     */
    public void setSuccess()
    {
        setBackgroundDrawable(BOOTSTRAP_EDIT_TEXT_SUCCESS);
    }

    /**
     * Set the BootstrapEditText to a warning state
     */
    public void setWarning()
    {
        setBackgroundDrawable(BOOTSTRAP_EDIT_TEXT_WARNING);
    }

    /**
     * Set the BootstrapEditText to a danger state
     */
    public void setDanger()
    {
        setBackgroundDrawable(BOOTSTRAP_EDIT_TEXT_DANGER);
    }

    /**
     * Set the BootstrapEditText to a default state
     */
    public void setDefault()
    {
        setBackgroundDrawable(BOOTSTRAP_EDIT_TEXT_DEFAULT);
    }
}