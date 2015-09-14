package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.api.view.BootstrapTextView;
import com.beardedhen.androidbootstrap.support.BootstrapText;

import java.io.Serializable;

public class AwesomeTextView extends TextView implements BootstrapTextView {

    private static final String TAG = "com.beardedhen.androidbootstrap.AwesomeTextView";

    private BootstrapText bootstrapText;

    public enum AnimationSpeed {
        FAST(500, 200),
        MEDIUM(1000, 500),
        SLOW(2000, 1000);

        private final long rotateDuration;
        private final long flashDuration;

        AnimationSpeed(long rotateDuration, long flashDuration) {
            this.rotateDuration = rotateDuration;
            this.flashDuration = flashDuration;
        }

        public long getRotateDuration() {
            return rotateDuration;
        }

        public long getFlashDuration() {
            return flashDuration;
        }
    }

    public AwesomeTextView(Context context) {
        super(context);
        initialise(null);
    }

    public AwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public AwesomeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AwesomeTextView);

        try {
            String icon = a.getString(R.styleable.AwesomeTextView_fa_icon);

            if (icon != null && !isInEditMode()) {
                setIcon(icon);
            }

            String text = a.getString(R.styleable.AwesomeTextView_bootstrapText);

            if (text != null) {
                setMarkdownText(text);
            }
        }
        finally {
            a.recycle();
        }
        setClickable(true); // allows view to reach android:state_pressed
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putSerializable(BootstrapTextView.KEY, bootstrapText);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            Serializable s = bundle.getSerializable(BootstrapTextView.KEY);

            if (s instanceof BootstrapText) {
                bootstrapText = (BootstrapText) s;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        requestStateRefresh();
    }

    /**
     * Used to start flashing a FontAwesomeText item
     *
     * @param forever whether the item should flash repeatedly or just once
     * @param speed   how fast the item should flash, chose between FontAwesomeText.AnimationSpeed.SLOW /
     *                FontAwesomeText.AnimationSpeed.MEDIUM / FontAwesomeText.AnimationSpeed.FAST
     */
    public void startFlashing(boolean forever, AnimationSpeed speed) {
        Animation fadeIn = new AlphaAnimation(0, 1);

        //set up extra variables
        fadeIn.setDuration(50);
        fadeIn.setRepeatMode(Animation.REVERSE);

        //default repeat count is 0, however if user wants, set it up to be infinite
        fadeIn.setRepeatCount(0);
        if (forever) {
            fadeIn.setRepeatCount(Animation.INFINITE);
        }

        fadeIn.setStartOffset(speed.getFlashDuration());

        //set the new animation to a final animation
        final Animation animation = fadeIn;

        //run the animation - used to work correctly on older devices
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation(animation);
            }
        }, 100);
    }

    /**
     * Used to start rotating a FontAwesomeText item
     *
     * @param clockwise true for clockwise, false for anti clockwise spinning
     * @param speed     how fast the item should flash, chose between FontAwesomeText.AnimationSpeed.SLOW /
     *                  FontAwesomeText.AnimationSpeed.MEDIUM / FontAwesomeText.AnimationSpeed.FAST
     */
    public void startRotate(boolean clockwise, AnimationSpeed speed) {
        Animation rotate;

        //set up the rotation animation
        if (clockwise) {
            rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        else {
            rotate = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }

        //set up some extra variables
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setStartOffset(0);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setDuration(speed.getRotateDuration());

        //send the new animation to a final animation
        final Animation animation = rotate;

        //run the animation - used to work correctly on older devices
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation(animation);
            }
        }, 100);
    }

    /**
     * Used to stop animating any FontAwesomeText item
     */
    public void stopAnimation() {
        this.clearAnimation();
    }

    /**
     * Used to set the icon for a FontAwesomeText item
     *
     * @param faIcon - String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
     */
    public void setIcon(String faIcon) {
        setBootstrapText(new BootstrapText.Builder(getContext()).addFaIcon(faIcon).build());
    }

    public void setMarkdownText(String text) {
        // detect {fa-*} and split into spannable
        // ignore \{fa-*\}

        BootstrapText.Builder builder = new BootstrapText.Builder(getContext());

        boolean skip = false;

        int lastAddedIndex = 0;
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < text.length(); i++) {
            if (skip) {
                skip = false;
                continue;
            }

            char c = text.charAt(i);

            if (c == '\\') { // escape sequence, ignore next char
                skip = true;
                continue;
            }

            if (c == '{') {
                startIndex = i;
            }
            else if (c == '}') {
                endIndex = i;
            }

            if (startIndex != -1 && endIndex != -1) { // encountered full facode string

                if (endIndex < startIndex) { // reset end index
                    endIndex = -1;
                }
                else if (startIndex >= 0 && endIndex < text.length()) {
                    String faCode = text.substring(startIndex + 1, endIndex);

                    if (faCode.matches("fa-[a-z-0-9]+")) {

                        // add any inbetween text
                        builder.addText(text.substring(lastAddedIndex, startIndex));
                        builder.addFaIcon(faCode);

                        lastAddedIndex = endIndex + 1;
                    }
                }
                startIndex = -1;
                endIndex = -1;
            }
        }
        setBootstrapText(builder.addText(text.substring(lastAddedIndex, text.length())).build());
    }

    @Override public void setBootstrapText(BootstrapText bootstrapText) {
        this.bootstrapText = bootstrapText;
        requestStateRefresh();
    }

    private void requestStateRefresh() {
        if (bootstrapText != null) {
            setText(bootstrapText);
        }
    }

}
