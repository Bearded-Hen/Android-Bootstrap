package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapTextView;
import com.beardedhen.androidbootstrap.support.BootstrapText;

import java.io.Serializable;

/**
 * This class extends the default Android TextView to supply Bootstrap behaviour. The text color
 * can be set by changing the BootstrapBrand, and scalable Typeface icons can be interspersed with
 * regular text, using the BootstrapText spannable.
 */
public class AwesomeTextView extends TextView implements BootstrapTextView, BootstrapBrandView {

    private static final String TAG = "com.beardedhen.androidbootstrap.AwesomeTextView";

    private BootstrapText bootstrapText;
    private BootstrapBrand bootstrapBrand;

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
        String markdownText;

        try {
            int typeOrdinal = a.getInt(R.styleable.AwesomeTextView_bootstrapBrand, -1);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);

            String icon = a.getString(R.styleable.AwesomeTextView_fa_icon);

            if (icon != null && !isInEditMode()) {
                setIcon(icon);
            }

            markdownText = a.getString(R.styleable.AwesomeTextView_bootstrapText);
        }
        finally {
            a.recycle();
        }
        setClickable(true); // allows view to reach android:state_pressed

        if (markdownText != null) {
            setMarkdownText(markdownText);
        }
        updateBootstrapState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putSerializable(BootstrapTextView.KEY, bootstrapText);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            Serializable text = bundle.getSerializable(BootstrapTextView.KEY);
            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);

            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }
            if (text instanceof BootstrapText) {
                bootstrapText = (BootstrapText) text;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    /**
     * Starts a Flashing Animation on the AwesomeTextView
     *
     * @param forever whether the animation should be infinite or play once
     * @param speed   how fast the item should flash
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
     * Starts a rotating animation on the AwesomeTetView
     *
     * @param clockwise true for clockwise, false for anti clockwise spinning
     * @param speed     how fast the item should rotate
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
     * DEPRECATED: use setMarkdownText() or setBootstrapText() instead
     * <p/>
     * Used to set the text to display a FontAwesome Icon.
     *
     * @param faIcon - FontAwesome code for the icon as per the
     *               <a href="http://fortawesome.github.io/Font-Awesome/cheatsheet/">Font Awesome Cheatsheet</a>
     */
    @Deprecated public void setIcon(String faIcon) {
        setBootstrapText(new BootstrapText.Builder(getContext()).addFaIcon(faIcon).build());
    }

    @Override public void setMarkdownText(String text) {
        if (text == null) {
            return;
        }

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

    protected void updateBootstrapState() {
        if (bootstrapText != null) {
            setText(bootstrapText);
        }
        if (bootstrapBrand != null) {
            setTextColor(bootstrapBrand.defaultFill(getContext()));
        }
    }

    /*
     * Getters/Setters
     */

    @Override public void setBootstrapText(BootstrapText bootstrapText) {
        this.bootstrapText = bootstrapText;
        updateBootstrapState();
    }

    @Nullable @Override public BootstrapText getBootstrapText() {
        return bootstrapText;
    }

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        bootstrapText = null;
    }

}
