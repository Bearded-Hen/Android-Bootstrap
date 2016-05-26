package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BootstrapProgressBarGroup extends BootstrapGroup {

    private int cumulativeProgress;
    private int maxProgress;
    private final BootstrapProgressBar emptyProgressBar = new BootstrapProgressBar(getContext());
    private int sizeOrdinal;

    boolean isEmptyBeingAdded = false;

    public BootstrapProgressBarGroup(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapProgressBarGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapProgressBarGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    protected void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapProgressBarGroup);

        try {
            this.maxProgress = a.getInt(R.styleable.BootstrapProgressBarGroup_bootstrapMaxProgress, 100);
            this.sizeOrdinal = a.getInt(R.styleable.BootstrapProgressBarGroup_bootstrapSize, 2);
        } finally {
            a.recycle();
        }

        setOrientation(HORIZONTAL);
        updateBootstrapGroup();
    }

    @Override
    protected void onBootstrapViewAdded() {
        addEmptyProgressBar();

        updateBootstrapGroup();
    }

    @Override
    protected void onBootstrapViewRemoved() {
        addEmptyProgressBar();

        updateBootstrapGroup();
    }

    private void addEmptyProgressBar(){
        int whereIsEmpty = -1;
        for (int i = 0; i < getChildCount(); i++) {
            if (retrieveChild(i) != null && retrieveChild(i).equals(emptyProgressBar)) {
                whereIsEmpty = i;
            }
        }

        if (whereIsEmpty != getChildCount() - 1) {
            if (whereIsEmpty != -1) {
                isEmptyBeingAdded = true;
                removeView(emptyProgressBar);
                isEmptyBeingAdded = false;
            }
            if (!isEmptyBeingAdded) {
                addView(emptyProgressBar);
            }
        }
    }

    @Override
    protected void updateBootstrapGroup() {
        if (getChildCount() == 0) {
            return;
        }

        cumulativeProgress = getCumulativeProgress();

        int numChildren = getChildCount();
        for (int i = 0; i < numChildren; i++) {
            LayoutParams layoutParams = getDefultlayoutParams();
            layoutParams.weight = retrieveChild(i).getProgress();
            retrieveChild(i).setLayoutParams(layoutParams);

            retrieveChild(i).setMaxProgress(retrieveChild(i).getProgress());
            retrieveChild(i).setBootstrapSize(sizeOrdinal);

        }

        //update empty progressbar attributes

        LayoutParams layoutParams = getDefultlayoutParams();
        layoutParams.weight = (float) maxProgress - cumulativeProgress;
        emptyProgressBar.setLayoutParams(layoutParams);
        emptyProgressBar.setMaxProgress(maxProgress - cumulativeProgress);
        emptyProgressBar.setBootstrapSize(sizeOrdinal);

        setWeightSum((float)maxProgress);
    }

    private LinearLayout.LayoutParams getDefultlayoutParams(){
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(height, ViewGroup.LayoutParams.WRAP_CONTENT);
        return layoutParams;
    }

    public int getCumulativeProgress(){
        int numChildren = getChildCount();
        int total = 0;
        for (int i = 0; i < numChildren; i++) {
            total += getChildProgress(i);
        }
        checkCumulativeSmallerThanMax(maxProgress, total);
        return total;
    }

    private void checkCumulativeSmallerThanMax(int max, int cumulative){
        if (max < cumulative){
            throw new IllegalStateException(String.format("Max Progress Cant be smaller than cumulative progress. Max = %d, cumlative = %d", max, cumulative));

        }

    }

    private int getChildProgress(int i){
        return retrieveChild(i).getProgress();
    }

    private BootstrapProgressBar retrieveChild(int i) {
        View view = getChildAt(i);

        if ((view instanceof BootstrapProgressBar)) {
            return (BootstrapProgressBar) view;
        }
        else {
            throw new IllegalStateException("All child view of BootstrapProgressBarGroup must be BootstrapProgressBar");
        }
    }

    public void onProgressChanged(BootstrapProgressBar bootstrapProgressBar){
        int progress = bootstrapProgressBar.getProgress();
        updateBootstrapGroup();
    }

    public int getMaxProgress(){
        return maxProgress;
    }

    public void setMaxProgress(int maxProgress){
        checkCumulativeSmallerThanMax(maxProgress, cumulativeProgress);
        this.maxProgress = maxProgress;
    }
}
