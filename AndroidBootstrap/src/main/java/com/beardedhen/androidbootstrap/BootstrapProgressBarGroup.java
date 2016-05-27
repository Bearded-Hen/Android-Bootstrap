package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.api.view.ProgressView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

/**
 * BootstrapProgressBarGroups are a LinearLayout which exclusively holds BootstrapProgressBars in a horizontal orientation.
 * This can be used to create the effect of stacked progress bars see <a href="http://getbootstrap.com/components/#progress-stacked">here</a>
 *
 * Each child will have there weight and max progress set to there progress. An empty progressbar emptyProgressBar will then be added to the end of layout if the bar is not full.
 */
public class BootstrapProgressBarGroup extends BootstrapGroup implements ProgressView, RoundableView {

    private int cumulativeProgress;
    private int maxProgress;
    private final BootstrapProgressBar emptyProgressBar = new BootstrapProgressBar(getContext());
    private int sizeOrdinal;

    private boolean striped = false;

    private boolean isEmptyBeingAdded = false;
    private boolean rounded;
    private boolean animated;

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
            this.rounded = a.getBoolean(R.styleable.BootstrapProgressBarGroup_roundedCorners, false);
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

    /**
     * This looks for instances of emptyProgressBar and removes them if they are not at the end and then adds one at the end if its needed.
     */
    private void addEmptyProgressBar(){
        int whereIsEmpty = -1;
        for (int i = 0; i < getChildCount(); i++) {
            if (retrieveChild(i) != null && retrieveChild(i).equals(emptyProgressBar)) {
                whereIsEmpty = i;
            }
        }

        if (whereIsEmpty != getChildCount() - 1) {
            if (whereIsEmpty != -1) {
                //the flowing true/false is to stop empty progressbar being added more than once as removeView and addView indirectly call this method
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

            retrieveChild(i).setRounded(rounded);
            retrieveChild(i).setCornerRounding(false, false);
        }
        //this means that rounded corners will display correctly by telling only the first child to draw the left edge as rounded and only the last to draw right edge as rounded
        retrieveChild(0).setCornerRounding(true, false);
        retrieveChild(numChildren - 1).setCornerRounding(false, true);

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

    /**
     * This get the total progress of all the children
     * @return the CumulativeProgress i.e. the total progress of all children
     */
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
        StringBuilder builder = new StringBuilder();
        builder.append("Max Progress Cant be smaller than cumulative progress. Max = ");
        builder.append(max);
        builder.append(", cumlative = ");
        builder.append(cumulative);
        builder.append(". \n");
        for (int i = 0; i < getChildCount(); i++) {
            builder.append("Child ").append(i).append(" has progress ").append(getChildProgress(i));
        }
        if (max < cumulative){
            throw new IllegalStateException(builder.toString());

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

    /**
     * this should be called by all children to notify the BootstrapProgressBarGroup that there progress has changed
     * @param bootstrapProgressBar the child View
     */
    public void onProgressChanged(BootstrapProgressBar bootstrapProgressBar){
        updateBootstrapGroup();
    }

    /**
     *
     * @return int maxProgress. Returns the maxProgress value
     */
    public int getMaxProgress(){
        return maxProgress;
    }

    /**
     * Used for settings the maxprogress. Also check if Cumulative progress is smaller than the max before asigning, see {@link #checkCumulativeSmallerThanMax}.
     * @param maxProgress the maxProgress value
     */
    public void setMaxProgress(int maxProgress){
        checkCumulativeSmallerThanMax(maxProgress, cumulativeProgress);
        this.maxProgress = maxProgress;
    }

    /**
     *
     * @param rounded if it should display rounded corners. true will round the corners, false wont
     */
    @Override
    public void setRounded(boolean rounded){
        this.rounded = rounded;
        updateBootstrapGroup();
    }

    /**
     *
     * @return a boolean weather the progressbarGroup will have rounded edges
     */
    @Override
    public boolean isRounded(){
        return rounded;
    }

    @Override
    public void setProgress(int progress) {
        throw new IllegalStateException("This method not applicable for type BootstrapProgressBarGroup");
    }

    @Override
    public int getProgress() {
        throw new IllegalStateException("This method not applicable for type BootstrapProgressBarGroup");
    }

    /**
     * This will set all children to striped.
     * @param striped true for a striped pattern, false for a plain pattern
     */
    @Override
    public void setStriped(boolean striped) {
        this.striped = striped;
        for (int i = 0; i < getChildCount(); i++) {
            retrieveChild(i).setStriped(striped);
        }
    }

    /**
     * This will only be true if setStriped(true) was called
     * @return striped true for a striped pattern, false for a plain pattern
     */
    @Override
    public boolean isStriped() {
        return striped;
    }


    /**
     *
     * @param animated whether the view should animate its updates or not.
     */
    @Override
    public void setAnimated(boolean animated) {
        this.animated = animated;
        for (int i = 0; i < getChildCount(); i++) {
            retrieveChild(i).setAnimated(animated);
        }
    }

    /**
     * This will only be true if setAnimated(true) was called
     * @return animated if all children have been set to be animated (through the Group)
     */
    @Override
    public boolean isAnimated() {
        return animated;
    }
}
