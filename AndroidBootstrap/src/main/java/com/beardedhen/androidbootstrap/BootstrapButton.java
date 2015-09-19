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

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

// TODO document/finalise
public class BootstrapButton extends AwesomeTextView implements BootstrapSizeView,
        OutlineableView, RoundableView {

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

            int sizeOrdinal = a.getInt(R.styleable.BootstrapButton_bootstrapSize, 0);
            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal);
        }
        finally {
            a.recycle();
        }
        updateBootstrapState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putSerializable(BootstrapSize.KEY, bootstrapSize);
        bundle.putSerializable(KEY_MODE, mode);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);

            Serializable size = bundle.getSerializable(BootstrapSize.KEY);
            Serializable m = bundle.getSerializable(KEY_MODE);

            if (size instanceof BootstrapSize) {
                bootstrapSize = (BootstrapSize) size;
            }
            if (m instanceof Mode) {
                mode = (Mode) m;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    @Override public void updateBootstrapState() {
        super.updateBootstrapState();

        BootstrapBrand bootstrapBrand = getBootstrapBrand();

        if (bootstrapSize != null && bootstrapBrand != null) {

            int vert = bootstrapSize.buttonVerticalPadding(getContext());
            int hori = bootstrapSize.buttonHorizontalPadding(getContext());

            setPadding(hori, vert, hori, vert);

            setTextColor(BootstrapDrawableFactory.bootstrapButtonText(
                    getContext(),
                    showOutline,
                    bootstrapBrand));

            Drawable bg = BootstrapDrawableFactory.bootstrapButton(
                    getContext(),
                    bootstrapBrand,
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

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateBootstrapState();
    }

    void setPosition(Position position) {
        this.position = position;
        updateBootstrapState();
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

}
