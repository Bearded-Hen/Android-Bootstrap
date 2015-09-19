package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

import java.io.Serializable;

import static com.beardedhen.androidbootstrap.BootstrapButton.Position.BOTTOM;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.END;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_HORI;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_VERT;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.SOLO;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.START;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.TOP;

// TODO document/finalise
public class BootstrapButtonGroup extends LinearLayout implements BootstrapSizeView,
        OutlineableView, RoundableView, BootstrapBrandView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButtonGroup";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButtonGroup.MODE";

    private BootstrapSize bootstrapSize;
    private BootstrapButton.ButtonMode buttonMode;
    private BootstrapBrand bootstrapBrand;

    private boolean rounded;
    private boolean outline;

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

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapButtonGroup);

        try {
            this.rounded = a.getBoolean(R.styleable.BootstrapButtonGroup_roundedCorners, false);
            this.outline = a.getBoolean(R.styleable.BootstrapButtonGroup_showOutline, false);

            int typeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_buttonMode, -1);
            int brandOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_bootstrapBrand, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_bootstrapSize, -1);

            this.buttonMode = BootstrapButton.ButtonMode.fromAttributeValue(typeOrdinal);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(brandOrdinal);
            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal);
        }
        finally {
            a.recycle();
        }
        updateBootstrapPositions();
        updateChildrenState();
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

            if (m instanceof BootstrapButton.ButtonMode) {
                buttonMode = (BootstrapButton.ButtonMode) m;
            }
            if (brand instanceof BootstrapBrand) {
                bootstrapBrand = (BootstrapBrand) brand;
            }

            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapPositions();
        updateChildrenState();
    }

    private void updateBootstrapPositions() {
        int childCount = getChildCount();
        int orientation = getOrientation();

        // tell children their position so they can draw backgrounds appropriately

        if (childCount == 0) {
            return;
        }
        else if (childCount == 1) {
            BootstrapButton button = retrieveButtonChild(0);
            button.setPosition(SOLO);
            button.updateFromParent(bootstrapBrand, bootstrapSize, buttonMode, outline, rounded);
        }

        for (int i = 0; i < childCount; i++) {
            BootstrapButton button = retrieveButtonChild(i);

            if (i == 0) { // first view
                button.setPosition(orientation == HORIZONTAL ? START : TOP);
            }
            else if (i == childCount - 1) { // last view
                button.setPosition(orientation == HORIZONTAL ? END : BOTTOM);
            }
            else {
                button.setPosition(orientation == HORIZONTAL ? MIDDLE_HORI : MIDDLE_VERT);
            }
            button.updateFromParent(bootstrapBrand, bootstrapSize, buttonMode, outline, rounded);
        }
    }

    private void updateChildrenState() {
        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.updateFromParent(bootstrapBrand, bootstrapSize, buttonMode, outline, rounded);
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

    /*
     * Getters / Setters
     */

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;

        for (int i = 0; i < getChildCount(); i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setBootstrapSize(bootstrapSize);
        }
    }

    @Override public BootstrapSize getBootstrapSize() {
        return bootstrapSize;
    }

    public BootstrapButton.ButtonMode getButtonMode() {
        return buttonMode;
    }

    public void setButtonMode(BootstrapButton.ButtonMode buttonMode) {
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

    /*
     * Overrides
     */


    @Override public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        updateBootstrapPositions();
    }

    @Override public void addView(@NonNull View child) {
        super.addView(child);
        updateBootstrapPositions();
    }

    @Override public void addView(@NonNull View child, int index) {
        super.addView(child, index);
        updateBootstrapPositions();
    }

    @Override public void addView(@NonNull View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateBootstrapPositions();
    }

    @Override public void addView(@NonNull View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateBootstrapPositions();
    }

    @Override public void addView(@NonNull View child, int width, int height) {
        super.addView(child, width, height);
        updateBootstrapPositions();
    }

    @Override
    protected boolean addViewInLayout(
            @NonNull View child, int index, ViewGroup.LayoutParams params) {
        boolean b = super.addViewInLayout(child, index, params);
        updateBootstrapPositions();
        return b;
    }

    @Override
    protected boolean addViewInLayout(@NonNull
                                      View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        boolean b = super.addViewInLayout(child, index, params, preventRequestLayout);
        updateBootstrapPositions();
        return b;
    }

    @Override public void removeView(View view) {
        super.removeView(view);
        updateBootstrapPositions();
    }

    @Override protected void removeDetachedView(@NonNull View child, boolean animate) {
        super.removeDetachedView(child, animate);
        updateBootstrapPositions();
    }

    @Override public void removeAllViews() {
        super.removeAllViews();
        updateBootstrapPositions();
    }

    @Override public void removeAllViewsInLayout() {
        super.removeAllViewsInLayout();
        updateBootstrapPositions();
    }

    @Override public void removeViewAt(int index) {
        super.removeViewAt(index);
        updateBootstrapPositions();
    }

    @Override public void removeViewInLayout(@NonNull View view) {
        super.removeViewInLayout(view);
        updateBootstrapPositions();
    }

    @Override public void removeViews(int start, int count) {
        super.removeViews(start, count);
        updateBootstrapPositions();
    }

    @Override public void removeViewsInLayout(int start, int count) {
        super.removeViewsInLayout(start, count);
        updateBootstrapPositions();
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        updateBootstrapPositions();
    }

}
