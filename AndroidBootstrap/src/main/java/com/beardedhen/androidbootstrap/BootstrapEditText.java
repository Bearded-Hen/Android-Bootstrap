package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

// TODO document/finalise/update to v4 spec

public class BootstrapEditText extends EditText implements BootstrapBrandView, RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapEditText";

    private BootstrapBrand bootstrapBrand;
    private boolean rounded;

    public enum TextState {

        DEFAULT("default", R.drawable.edittext_background_rounded, R.drawable.edittext_background),
        SUCCESS("success", R.drawable.edittext_background_rounded_success, R.drawable.edittext_background_success),
        WARNING("warning", R.drawable.edittext_background_rounded_warning, R.drawable.edittext_background_warning),
        DANGER("danger", R.drawable.edittext_background_rounded_danger, R.drawable.edittext_background_danger);

        private final String state;
        private final int roundedBg;
        private final int normalBg;

        TextState(String state, int roundedBg, int normalBg) {
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
            this.rounded = a.getBoolean(R.styleable.BootstrapEditText_roundedCorners, false);

            int typeOrdinal = a.getInt(R.styleable.AwesomeTextView_bootstrapBrand, -1);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
        }
        finally {
            a.recycle();
        }
        textState = TextState.getStateFromString(state);
        setState(state);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, rounded);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.rounded = bundle.getBoolean(RoundableView.KEY);

            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);

            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    private void updateBootstrapState() {

    }




    private void setBackgroundDrawable(TextState textState) {
        this.textState = textState;

        if (rounded) {
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


    /*
     * Getters/Setters
     */

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override public void setRounded(boolean rounded) {
        this.rounded = rounded;
        updateBootstrapState();
    }

    @Override public boolean isRounded() {
        return rounded;
    }
}
