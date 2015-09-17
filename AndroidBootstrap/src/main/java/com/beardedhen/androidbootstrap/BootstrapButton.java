package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.BootstrapThemeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.support.BootstrapDrawableParams;

import java.io.Serializable;

public class BootstrapButton extends AwesomeTextView implements BootstrapThemeView,
        BootstrapSizeView, OutlineableView, RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButton";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButton.MODE";

    enum Position {
        SOLO,
        MIDDLE_HORI,
        MIDDLE_VERT,
        TOP,
        BOTTOM,
        START,
        END
    }

    enum Mode {
        REGULAR,
        TOGGLE,
        CHECKBOX,
        RADIO;

        public static Mode fromAttributeValue(int attrValue) {
            switch (attrValue) {
                case 0:
                    return REGULAR;
                case 1:
                    return TOGGLE;
                case 2:
                    return CHECKBOX;
                case 3:
                    return RADIO;
                default:
                    return REGULAR;
            }
        }
    }

    private Position position = Position.SOLO;
    private Mode mode = Mode.REGULAR;

    private BootstrapTheme bootstrapTheme;
    private BootstrapSize bootstrapSize;

    private boolean roundedCorners;
    private boolean showOutline;

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
        position = Position.SOLO;

        try {
            this.roundedCorners = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false);
            this.showOutline = a.getBoolean(R.styleable.BootstrapButton_showOutline, false);

            int typeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapType, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, 0);

            bootstrapTheme = DefaultBootstrapTheme.fromAttributeValue(typeOrdinal);
            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal);
        }
        finally {
            a.recycle();
        }
        requestStateRefresh();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putSerializable(BootstrapSize.KEY, bootstrapSize);
        bundle.putSerializable(BootstrapTheme.KEY, bootstrapTheme);
        bundle.putSerializable(KEY_MODE, mode);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);

            Serializable size = bundle.getSerializable(BootstrapSize.KEY);
            Serializable theme = bundle.getSerializable(BootstrapTheme.KEY);
            Serializable m = bundle.getSerializable(KEY_MODE);

            if (size instanceof BootstrapSize) {
                bootstrapSize = (BootstrapSize) size;
            }
            if (theme instanceof BootstrapTheme) {
                bootstrapTheme = (BootstrapTheme) theme;
            }
            if (m instanceof Mode) {
                mode = (Mode) m;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        requestStateRefresh();
    }

    private void requestStateRefresh() {

        if (bootstrapSize != null && bootstrapTheme != null) {

            int vert = bootstrapSize.buttonVerticalPadding(getContext());
            int hori = bootstrapSize.buttonHorizontalPadding(getContext());

            setPadding(hori, vert, hori, vert);
            int textColor = showOutline ? bootstrapTheme.defaultEdge(getContext()) : bootstrapTheme.textColor(getContext());
            setTextColor(textColor);

            // TODO need to handle link special case

            BootstrapDrawableParams params = new BootstrapDrawableParams()
                    .showRoundedCorners(roundedCorners)
                    .showOutline(showOutline)
                    .bootstrapType(bootstrapTheme)
                    .bootstrapSize(bootstrapSize)
                    .enabled(isEnabled());

            setTextColor(BootstrapDrawableFactory.bootstrapButtonText(
                    getContext(),
                    showOutline,
                    bootstrapTheme));

            StateListDrawable bg = BootstrapDrawableFactory.bootstrapButton(
                    getContext(),
                    bootstrapTheme,
                    bootstrapSize,
                    position,
                    showOutline,
                    roundedCorners);

            if (Build.VERSION.SDK_INT >= 16) {
                setBackground(bg);
            }
            else {
                setBackgroundDrawable(bg);
            }
        }
    }

    @Override public boolean onTouchEvent(@NonNull MotionEvent event) {

        switch (mode) {
            case REGULAR:
                return super.onTouchEvent(event);
            case TOGGLE:
                return handleToggle(event);
            case CHECKBOX:
                return handleToggle(event);
            case RADIO:
                return super.onTouchEvent(event); // FIXME implement
            default:
                return super.onTouchEvent(event);
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

    /*
     * Getters/Setters
     */

    @Override public BootstrapSize getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public BootstrapTheme getBootstrapTheme() {
        return bootstrapTheme;
    }

    @Override public boolean isShowOutline() {
        return showOutline;
    }

    @Override public boolean isRoundedCorners() {
        return roundedCorners;
    }

    @Override public void setBootstrapTheme(BootstrapTheme bootstrapTheme) {
        this.bootstrapTheme = bootstrapTheme;
        requestStateRefresh();
    }

    @Override public void setShowOutline(boolean showOutline) {
        this.showOutline = showOutline;
        requestStateRefresh();
    }

    @Override public void setRoundedCorners(boolean roundedCorners) {
        this.roundedCorners = roundedCorners;
        requestStateRefresh();
    }

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        requestStateRefresh();
    }

    void setPosition(Position position) {
        this.position = position;
        requestStateRefresh();
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

}
