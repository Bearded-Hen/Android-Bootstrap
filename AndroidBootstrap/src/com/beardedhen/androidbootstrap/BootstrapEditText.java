package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

public class BootstrapEditText extends EditText {

    public enum TextState {

        DEFAULT("default", R.drawable.edittext_background_rounded, R.drawable.edittext_background),
        SUCCESS("success", R.drawable.edittext_background_rounded_success, R.drawable.edittext_background_success),
        WARNING("warning", R.drawable.edittext_background_rounded_warning, R.drawable.edittext_background_warning),
        DANGER("danger", R.drawable.edittext_background_rounded_danger, R.drawable.edittext_background_danger);

        private final String state;
        private final int roundedBg;
        private final int normalBg;

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
    private int gravity = Gravity.CENTER_VERTICAL;
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

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapEditText);

        String state = "default";

        try {
            if (a != null) {
                roundedCorners = a.getBoolean(R.styleable.BootstrapEditText_be_roundedCorners, false);

                //state
                state = a.getString(R.styleable.BootstrapEditText_be_state);
                state = (state == null) ? "default" : state;

                //gravity
                gravity = a.getInt(R.styleable.BootstrapEditText_android_gravity, Gravity.CENTER_VERTICAL);
                gravity = (gravity == Gravity.NO_GRAVITY) ? Gravity.CENTER_VERTICAL : gravity;
            }
        } finally {
            if (a != null) {
                a.recycle();
            }
        }

        setGravity(gravity);

        if (this.isEnabled()) {
            textState = TextState.getStateFromString(state);
            setState(state);
        }
    }

    private void setBackgroundDrawable(TextState textState) {
        this.textState = textState;

        if (roundedCorners) {
            this.setBackgroundResource(textState.getRoundedBg());
        }
        else {
            this.setBackgroundResource(textState.getNormalBg());
        }
    }

    /**
     * Change the BootstrapEditTextState
     *
     * @param state an enum of success, warning, danger, or default.
     */
    public void setState(TextState state) {
        this.textState = state;
        setBackgroundDrawable(textState);
    }

    /**
     * Deprecated, use {@link #setState(com.beardedhen.androidbootstrap.BootstrapEditText.TextState)} instead
     */
    public void setState(String state) {
        this.textState = TextState.getStateFromString(state);
        setBackgroundDrawable(textState);
    }

    /**
     * Deprecated, use {@link #setState(com.beardedhen.androidbootstrap.BootstrapEditText.TextState)} instead
     */
    @Deprecated public void setSuccess() {
        setBackgroundDrawable(TextState.SUCCESS);
    }

    /**
     * Deprecated, use {@link #setState(com.beardedhen.androidbootstrap.BootstrapEditText.TextState)} instead
     */
    @Deprecated public void setWarning() {
        setBackgroundDrawable(TextState.WARNING);
    }

    /**
     * Deprecated, use {@link #setState(com.beardedhen.androidbootstrap.BootstrapEditText.TextState)} instead
     */
    @Deprecated public void setDanger() {
        setBackgroundDrawable(TextState.DANGER);
    }

    /**
     * Deprecated, use {@link #setState(com.beardedhen.androidbootstrap.BootstrapEditText.TextState)} instead
     */
    @Deprecated public void setDefault() {
        setBackgroundDrawable(TextState.DEFAULT);
    }

    /**
     * THIS METHOD IS DEPRECATED AND WILL BE REMOVED IN A FUTURE RELEASE.
     * Use setEnabled() instead.
     *
     * Specifies whether the BootstrapEditText is enabled or disabled
     *
     * @param enabled - boolean state for either enabled or disabled
     */
    @Deprecated public void setBootstrapEditTextEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }

}
