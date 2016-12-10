package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.ButtonMode;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BadgeContainerView;
import com.beardedhen.androidbootstrap.api.view.BootstrapBadgeView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.ButtonModeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.DimenUtils;
import com.beardedhen.androidbootstrap.utils.ViewUtils;

import java.io.Serializable;

/**
 * BootstrapButtons are regular buttons styled with BootstrapBrand colors, roundable corners, and an
 * 'outlineable' mode. It is possible to group together multiple buttons using BootstrapButtonGroup,
 * allowing the use of different selection modes e.g. Checkbox/Radio group.
 */
public class BootstrapButton extends AwesomeTextView implements BootstrapSizeView,
                                                                OutlineableView, RoundableView, ButtonModeView, BadgeContainerView,
                                                                BootstrapBadgeView {


    /**
     * instances of this can be used with .setOnCheckedChangedLisener to notify you when the state of a radio, togle or checkbox button has changed.
     */
    public interface OnCheckedChangedListener{
        /**
         * This method will get called when the state of a radio button, checkbox or toggle button changes.
         * @param bootstrapButton the view thats state is changing
         * @param isChecked weather the button is checked or not.
         */
        public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked);
    }

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButton";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButton.MODE";
    private static final String KEY_INDEX = "com.beardedhen.androidbootstrap.BootstrapButton.KEY_INDEX";

    private int parentIndex;
    private ViewGroupPosition viewGroupPosition = ViewGroupPosition.SOLO;
    private ButtonMode buttonMode = ButtonMode.REGULAR;

    private float bootstrapSize;

    private boolean roundedCorners;
    private boolean showOutline;
    private boolean mustBeSelected;

    private float baselineFontSize;
    private float baselineVertPadding;
    private float baselineHoriPadding;
    private float baselineStrokeWidth;
    private float baselineCornerRadius;
    private BootstrapBadge bootstrapBadge;
    private String badgeText;

    private OnCheckedChangedListener onCheckedChangedListener;

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
            this.mustBeSelected = a.getBoolean(R.styleable.BootstrapButton_checked, false);
            this.badgeText = a.getString(R.styleable.BootstrapButton_badgeText);

            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, -1);
            int modeOrdinal = a.getInt(R.styleable.BootstrapButton_buttonMode, -1);

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

        if (badgeText != null) {
            setBadge(new BootstrapBadge(getContext()));
            setBadgeText(badgeText);
        }
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putInt(KEY_INDEX, parentIndex);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);
        bundle.putSerializable(KEY_MODE, buttonMode);

        if (bootstrapBadge != null) {
            bundle.putString(BadgeContainerView.KEY, bootstrapBadge
                    .getBadgeText());
        }
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);
            this.parentIndex = bundle.getInt(KEY_INDEX);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

            if (bootstrapBadge != null) {
                setBadgeText(bundle.getString(BadgeContainerView.KEY));
            }

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

        ViewUtils.setBackgroundDrawable(this, bg);

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

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (onCheckedChangedListener != null) {
            onCheckedChangedListener.OnCheckedChanged(this, selected);
        }
    }

    private boolean handleRadioEvent(@NonNull MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setSelected(true); // notify parent to deselect any peers

            ViewParent parent = getParent();

            if (parent instanceof BootstrapButtonGroup) {
                ((BootstrapButtonGroup) parent).onRadioToggle(parentIndex);
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

    @Override public void displayBadgeDrawable() {
        if (bootstrapBadge != null) {
            Drawable badgeDrawable = this.bootstrapBadge.getBadgeDrawable();

            if (badgeDrawable != null) {
                setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        null, badgeDrawable,
                        null);
                setCompoundDrawablePadding(DimenUtils.dpToPixels(4));
            }
        }
    }

    /*
     * Getters/Setters
     */

    public boolean isMustBeSelected() {
        return mustBeSelected;
    }

    public void setChecked(boolean checked) {
        this.mustBeSelected = checked;
    }

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

    @Override public void setBadge(BootstrapBadge badge) {
        this.bootstrapBadge = badge;
        this.bootstrapBadge.setBootstrapBrand(getBootstrapBrand(), true);
        this.bootstrapBadge.setBootstrapSize(getBootstrapSize());
        displayBadgeDrawable();
    }

    @Nullable
    @Override
    public String getBadgeText() {
        return bootstrapBadge != null ? bootstrapBadge.getBadgeText() : null;
    }

    @Override
    public void setBadgeText(@Nullable String badgeText) {
        if (bootstrapBadge != null) {
            this.badgeText = badgeText;
            this.bootstrapBadge.setBadgeText(this.badgeText);
            displayBadgeDrawable();
        }
    }

    @Override public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public BootstrapBadge getBootstrapBadge() {
        return bootstrapBadge;
    }

    @Override public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

    @Override public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateBootstrapState();
    }

    /**
     * NOTE this method only works if the buttons mode is not set to regular.
     * for non Toggle, checkbox and radio see {@link BootstrapButton#setOnClickListener}
     * @param listener OnCheckedChangedListener that will be fired when the schecked state ofa button is changed.
     */
    public void setOnCheckedChangedListener(OnCheckedChangedListener listener){
        onCheckedChangedListener = listener;
    }

    /**
     * NOTE this method only works if the buttons mode is set to regular.
     * for Toggle, checkbox and radio see {@link BootstrapButton#setOnCheckedChangedListener}
     * @param l OnClickListener that will be fired on click.
     */
    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
    }
}
