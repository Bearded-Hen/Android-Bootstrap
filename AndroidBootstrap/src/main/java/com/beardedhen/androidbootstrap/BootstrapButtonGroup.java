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

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;

import java.io.Serializable;

import static com.beardedhen.androidbootstrap.BootstrapButton.Position.BOTTOM;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.END;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_HORI;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_VERT;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.SOLO;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.START;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.TOP;

public class BootstrapButtonGroup extends LinearLayout implements BootstrapSizeView {

    // TODO should be able to apply all child properties via this view

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapButtonGroup";
    private static final String KEY_MODE = "com.beardedhen.androidbootstrap.BootstrapButtonGroup.MODE";

    private BootstrapSize bootstrapSize;
    private BootstrapButton.Mode mode;

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
            int typeOrdinal = a.getInt(R.styleable.BootstrapButtonGroup_buttonMode, -1);
            this.mode = BootstrapButton.Mode.fromAttributeValue(typeOrdinal);
        }
        finally {
            a.recycle();
        }
        refreshDrawState();
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putSerializable(KEY_MODE, mode);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            Serializable m = bundle.getSerializable(KEY_MODE);
            if (m instanceof BootstrapButton.Mode) {
                mode = (BootstrapButton.Mode) m;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        refreshDrawState();
    }

    private void refreshDrawState() {
        int childCount = getChildCount();
        int orientation = getOrientation();

        // tell children their position so they can draw backgrounds appropriately

        if (childCount == 0) {
            return;
        }
        else if (childCount == 1) {
            BootstrapButton button = retrieveButtonChild(0);
            button.setPosition(SOLO);
            button.setMode(mode);
        }

        for (int i = 0; i < childCount; i++) {
            BootstrapButton button = retrieveButtonChild(i);
            button.setMode(mode);

            if (i == 0) { // first view
                button.setPosition(orientation == HORIZONTAL ? START : TOP);
            }
            else if (i == childCount -1) { // last view
                button.setPosition(orientation == HORIZONTAL ? END : BOTTOM);
            }
            else {
                button.setPosition(orientation == HORIZONTAL ? MIDDLE_HORI : MIDDLE_VERT);
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

    /*
     * Getters / Setters
     */

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
    }

    @Override public BootstrapSize getBootstrapSize() {
        return bootstrapSize;
    }

    public BootstrapButton.Mode getMode() {
        return mode;
    }

    public void setMode(BootstrapButton.Mode mode) {
        this.mode = mode;
        refreshDrawState();
    }


    /*
     * Overrides
     */


    @Override public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        refreshDrawState();
    }

    @Override public void addView(@NonNull View child) {
        super.addView(child);
        refreshDrawState();
    }

    @Override public void addView(@NonNull View child, int index) {
        super.addView(child, index);
        refreshDrawState();
    }

    @Override public void addView(@NonNull View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        refreshDrawState();
    }

    @Override public void addView(@NonNull View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        refreshDrawState();
    }

    @Override public void addView(@NonNull View child, int width, int height) {
        super.addView(child, width, height);
        refreshDrawState();
    }

    @Override
    protected boolean addViewInLayout(@NonNull View child, int index, ViewGroup.LayoutParams params) {
        boolean b = super.addViewInLayout(child, index, params);
        refreshDrawState();
        return b;
    }

    @Override
    protected boolean addViewInLayout(@NonNull View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        boolean b = super.addViewInLayout(child, index, params, preventRequestLayout);
        refreshDrawState();
        return b;
    }

    @Override public void removeView(View view) {
        super.removeView(view);
        refreshDrawState();
    }

    @Override protected void removeDetachedView(@NonNull View child, boolean animate) {
        super.removeDetachedView(child, animate);
        refreshDrawState();
    }

    @Override public void removeAllViews() {
        super.removeAllViews();
        refreshDrawState();
    }

    @Override public void removeAllViewsInLayout() {
        super.removeAllViewsInLayout();
        refreshDrawState();
    }

    @Override public void removeViewAt(int index) {
        super.removeViewAt(index);
        refreshDrawState();
    }

    @Override public void removeViewInLayout(@NonNull View view) {
        super.removeViewInLayout(view);
        refreshDrawState();
    }

    @Override public void removeViews(int start, int count) {
        super.removeViews(start, count);
        refreshDrawState();
    }

    @Override public void removeViewsInLayout(int start, int count) {
        super.removeViewsInLayout(start, count);
        refreshDrawState();
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        refreshDrawState();
    }

}
