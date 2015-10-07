package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.ButtonMode;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.ButtonModeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

import java.io.Serializable;

/**
 * BootstrapButtons are regular buttons styled with BootstrapBrand colors, roundable corners, and an
 * 'outlineable' mode. It is possible to group together multiple buttons using BootstrapButtonGroup,
 * allowing the use of different selection modes e.g. Checkbox/Radio group.
 */
public class BootstrapButton extends AwesomeTextView implements BootstrapSizeView,
        OutlineableView, RoundableView, ButtonModeView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButton";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButton.MODE";
    private static final String KEY_INDEX = "com.beardedhen.androidbootstrap.BootstrapButton.KEY_INDEX";

    private int parentIndex;
    private ViewGroupPosition viewGroupPosition = ViewGroupPosition.SOLO;
    private ButtonMode buttonMode = ButtonMode.REGULAR;

    private float bootstrapSize;

    private boolean roundedCorners;
    private boolean showOutline;

    private float baselineFontSize;
    private float baselineVertPadding;
    private float baselineHoriPadding;
    private float baselineStrokeWidth;
    private float baselineCornerRadius;

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
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButton);
        viewGroupPosition = ViewGroupPosition.SOLO;

        try {
            this.roundedCorners = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);
            this.showOutline = a.getBoolean(R.styleable.BootstrapButton_showOutline, false);

            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, -1);
            int modeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_buttonMode, -1);

            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
            buttonMode = ButtonMode.fromAttributeValue(modeOrdinal);
        }
        finally {
            a.recycle();
        }

        baselineFontSize = DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_button_default_font_size);
        baselineVertPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_vert_padding);
        baselineHoriPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_hori_padding);
        baselineStrokeWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_edge_width);
        baselineCornerRadius = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_corner_radius);
        updateBootstrapState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putInt(KEY_INDEX, parentIndex);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);
        bundle.putSerializable(KEY_MODE, buttonMode);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);
            this.parentIndex = bundle.getInt(KEY_INDEX);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

            Serializable m = bundle.getSerializable(KEY_MODE);

            if (m instanceof ButtonMode) {
                buttonMode = (ButtonMode) m;
            }
        }
        super.onRestoreInstanceState(state);
    }

    @Override protected void updateBootstrapState() {
        super.updateBootstrapState();
        BootstrapBrand bootstrapBrand = getBootstrapBrand();

        float cornerRadius = baselineCornerRadius;
        float strokeWidth = baselineStrokeWidth;

        final float fontSize = baselineFontSize * bootstrapSize;
        setTextSize(fontSize);

        cornerRadius *= bootstrapSize;
        strokeWidth *= bootstrapSize;

        setTextColor(BootstrapDrawableFactory.bootstrapButtonText(
                getContext(),
                showOutline,
                bootstrapBrand));

        Drawable bg = BootstrapDrawableFactory.bootstrapButton(
                getContext(),
                bootstrapBrand,
                (int) strokeWidth,
                (int) cornerRadius,
                viewGroupPosition,
                showOutline,
                roundedCorners);

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }

        int vert = (int) (baselineVertPadding * bootstrapSize);
        int hori = (int) (baselineHoriPadding * bootstrapSize);
        setPadding(hori, vert, hori, vert);
    }

    @Override public boolean onTouchEvent(@NonNull MotionEvent event) {

        switch (buttonMode) {
            case REGULAR:
                return super.onTouchEvent(event);
            case TOGGLE:
                return handleToggle(event);
            case CHECKBOX:
                return handleToggle(event);
            case RADIO:
                return handleRadioEvent(event);
            default:
                return super.onTouchEvent(event);
        }
    }

    private boolean handleRadioEvent(@NonNull MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isSelected()) {
                setSelected(false);
            }
            else { // notify parent to deselect any peers
                setSelected(true);

                ViewParent parent = getParent();

                if (parent instanceof BootstrapButtonGroup) {
                    ((BootstrapButtonGroup) parent).onRadioToggle(parentIndex);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    private boolean handleToggle(@NonNull MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setSelected(!isSelected());
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Called by the ViewParent, notifies the child of its position so that it can update its
     * drawable to match the position
     *
     * @param viewGroupPosition the position in the ViewGroup
     */
    void setViewGroupPosition(ViewGroupPosition viewGroupPosition, int parentIndex) {
        this.viewGroupPosition = viewGroupPosition;
        this.parentIndex = parentIndex;
        updateBootstrapState();
    }

    void updateFromParent(BootstrapBrand bootstrapBrand,
                          float bootstrapSize,
                          ButtonMode buttonMode,
                          boolean outline,
                          boolean rounded) { // called when viewparent attrs are updated

        // called by BootstrapButtonGroup when updating state all at once

        this.bootstrapSize = bootstrapSize;
        this.buttonMode = buttonMode;
        this.showOutline = outline;
        this.roundedCorners = rounded;
        setBootstrapBrand(bootstrapBrand);
        updateBootstrapState();
    }

    /*
     * Getters/Setters
     */

    @Override public boolean isShowOutline() {
        return showOutline;
    }

    @Override public boolean isRounded() {
        return roundedCorners;
    }

    @Override public void setShowOutline(boolean showOutline) {
        this.showOutline = showOutline;
        updateBootstrapState();
    }

    @Override public void setRounded(boolean rounded) {
        this.roundedCorners = rounded;
        updateBootstrapState();
    }

    @NonNull @Override public ButtonMode getButtonMode() {
        return buttonMode;
    }

    @Override public void setButtonMode(@NonNull ButtonMode buttonMode) {
        this.buttonMode = buttonMode;
    }

    @Override public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

    @Override public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateBootstrapState();
    }

}
