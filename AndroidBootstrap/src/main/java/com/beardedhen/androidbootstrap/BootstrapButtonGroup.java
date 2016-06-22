package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.ButtonMode;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.ButtonModeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.BOTTOM;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.END;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.MIDDLE_HORI;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.MIDDLE_VERT;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.SOLO;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.START;
import static com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition.TOP;

/**
 * BootstrapButtonGroups are a LinearLayout which exclusively holds BootstrapButtons. It is possible
 * to set the properties of all children with one method call to this view. Options include
 * BootstrapBrand colors, roundable corners, 'outlineable' mode and different selection modes
 * e.g. Checkbox/Radio group.
 * If button mode is set to radio only one button is a button group may be selected at a time.
 */
public class BootstrapButtonGroup extends BootstrapGroup implements BootstrapSizeView,
        OutlineableView, RoundableView, BootstrapBrandView, ButtonModeView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButtonGroup";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButtonGroup.MODE";

    private float bootstrapSize;
    private ButtonMode buttonMode;
    private BootstrapBrand bootstrapBrand;

    private boolean rounded;
    private boolean outline;

    private int checkedButtonId = 0;

    public BootstrapButtonGroup(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapButtonGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    protected void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButtonGroup);

        try {
            this.rounded = a.getBoolean(R.styleable.BootstrapButtonGroup_roundedCorners, false);
            this.outline = a.getBoolean(R.styleable.BootstrapButtonGroup_showOutline, false);

            int typeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_buttonMode, -1);
            int brandOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_bootstrapBrand, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_bootstrapSize, -1);

            this.checkedButtonId = a.getResourceId(R.styleable.BootstrapButtonGroup_checkedButton, 0);
            this.buttonMode = ButtonMode.fromAttributeValue(typeOrdinal);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(brandOrdinal);
            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
        }
        finally {
            a.recycle();
        }
        updateBootstrapGroup();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putSerializable(KEY_MODE, buttonMode);
        bundle.putSerializable(BootstrapBrand.KEY, bootstrapBrand);

        bundle.putBoolean(RoundableView.KEY, rounded);
        bundle.putBoolean(OutlineableView.KEY, outline);

        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            outline = bundle.getBoolean(OutlineableView.KEY);
            rounded = bundle.getBoolean(RoundableView.KEY);

            Serializable brand = bundle.getSerializable(BootstrapBrand.KEY);
            Serializable m = bundle.getSerializable(KEY_MODE);

            if (m instanceof ButtonMode) {
                buttonMode = (ButtonMode) m;
            }
            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }

            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapGroup();
    }

    @Override
    protected void onBootstrapViewAdded() {
        updateBootstrapGroup();
    }

    @Override
    protected void onBootstrapViewRemoved() {
        updateBootstrapGroup();
    }

    protected void updateBootstrapGroup() {
        int childCount = getChildCount();
        int orientation = getOrientation();

        // tell children their position so they can draw backgrounds appropriately

        if (childCount == 0) {
            return;
        }
        else if (childCount == 1) {
            BootstrapButton button = retrieveButtonChild(0);
            button.setViewGroupPosition(SOLO, 0);
        }

        List<BootstrapButton> buttonList = new ArrayList<>();

        for (int i = 0; i < childCount; i++) {
            BootstrapButton button = retrieveButtonChild(i);

            if (button.getVisibility() == VISIBLE) {
                buttonList.add(button);
            }
        }

        final int size = buttonList.size();
        for (int i = 0; i < size; i++) {
            BootstrapButton button = buttonList.get(i);
            ViewGroupPosition position;

            if (i == 0) { // first view
                position = orientation == HORIZONTAL ? START : TOP;
            }
            else if (i == size - 1) { // last view
                position = orientation == HORIZONTAL ? END : BOTTOM;
            }
            else {
                position = orientation == HORIZONTAL ? MIDDLE_HORI : MIDDLE_VERT;
            }
            button.setViewGroupPosition(position, i);
            button.updateFromParent(bootstrapBrand, bootstrapSize, buttonMode, outline, rounded);
            if (buttonMode == ButtonMode.RADIO && button.isMustBeSelected()) {
                button.setSelected(true);
                onRadioToggle(i);
                checkedButtonId = 0; //BootstrapButton "checked" attribute is preferable
            }
            else if (buttonMode == ButtonMode.RADIO && button.getId() == checkedButtonId) {
                button.setSelected(true);
                onRadioToggle(i);
            }
        }
    }

    private BootstrapButton retrieveButtonChild(int i) {
        View view = getChildAt(i);

        if ((view instanceof BootstrapButton)) {
            return (BootstrapButton) view;
        }
        else {
            throw new IllegalStateException("All child view of BootstrapButtonGroup must be BootstrapButtons");
        }
    }

    /**
     * Used for Radio Group Mode - resets all children to an unselected state,
     * apart from the calling Button.
     *
     * @param index the index of the button becoming selected
     */
    void onRadioToggle(int index) {
        for (int i = 0; i < getChildCount(); i++) {

            if (i != index) {
                BootstrapButton b = retrieveButtonChild(i);
                b.setSelected(false);
            }
        }
    }

    /*
     * Getters / Setters
     */

    public void check(@IdRes int id) {
        this.checkedButtonId = id;
    }

    @Override public float getBootstrapSize() {
        return bootstrapSize;
    }

    @Override public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        setBootstrapSize(bootstrapSize.scaleFactor());
    }

    @Override public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setBootstrapSize(this.bootstrapSize);
        }
    }

    @NonNull public ButtonMode getButtonMode() {
        return buttonMode;
    }

    public void setButtonMode(@NonNull ButtonMode buttonMode) {
        this.buttonMode = buttonMode;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setButtonMode(buttonMode);
        }
    }

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setBootstrapBrand(bootstrapBrand);
        }
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override public void setShowOutline(boolean showOutline) {
        this.outline = showOutline;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setShowOutline(outline);
        }
    }

    @Override public boolean isShowOutline() {
        return outline;
    }

    @Override public void setRounded(boolean rounded) {
        this.rounded = rounded;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setRounded(rounded);
        }
    }

    @Override public boolean isRounded() {
        return rounded;
    }

}
