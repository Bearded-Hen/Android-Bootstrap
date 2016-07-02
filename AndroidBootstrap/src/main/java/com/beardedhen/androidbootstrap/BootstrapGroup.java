package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * This is a base class that provies methods to get updates when a view is removed or added or rotated and contains abstract methods for the set up of the class.
 *  @see BootstrapProgressBarGroup
 *  @see BootstrapButtonGroup
 */
abstract class BootstrapGroup extends LinearLayout {

    public BootstrapGroup(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    protected abstract void initialise(AttributeSet attrs);

    @Override public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        updateBootstrapGroup();
    }

    protected abstract void updateBootstrapGroup();


    protected abstract void onBootstrapViewAdded();
    protected abstract void onBootstrapViewRemoved();

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        onBootstrapViewAdded();
    }

    @Override
    public void removeAllViews() {
        super.removeAllViews();
        onBootstrapViewRemoved();
    }

    @Override
    public void removeView(View view) {
        super.removeView(view);
        onBootstrapViewRemoved();
    }

    @Override
    public void removeViewInLayout(View view) {
        super.removeViewInLayout(view);
        onBootstrapViewRemoved();
    }

    @Override
    public void removeViewsInLayout(int start, int count) {
        super.removeViewsInLayout(start, count);
        onBootstrapViewRemoved();
    }

    @Override
    public void removeViewAt(int index) {
        View child = getChildAt(index);
        super.removeViewAt(index);
        onBootstrapViewRemoved();
    }

    @Override
    public void removeViews(int start, int count) {
        super.removeViews(start, count);
        onBootstrapViewRemoved();
    }
}
