package com.beardedhen.androidbootstrap.api.view;

/**
 * Views which implement this interface visually display ongoing progress to users
 */
public interface ProgressView {

    String KEY_USER_PROGRESS = "com.beardedhen.androidbootstrap.api.view.KEY_USER_PROGRESS";
    String KEY_DRAWN_PROGRESS = "com.beardedhen.androidbootstrap.api.view.KEY_DRAWN_PROGRESS";
    String KEY_STRIPED = "com.beardedhen.androidbootstrap.api.view.KEY_STRIPED";
    String KEY_ANIMATED = "com.beardedhen.androidbootstrap.api.view.KEY_ANIMATED";

    /**
     * Updates the amount of progress displayed to the user.
     *
     * @param progress a positive integer
     */
    void setProgress(int progress);

    /**
     * @return the amount of progress displayed to the user
     */
    int getProgress();

    /**
     * Sets whether the view should display a striped pattern.
     *
     * @param striped true for a striped pattern, false for a plain pattern
     */
    void setStriped(boolean striped);

    /**
     * @return true if the view is displaying a striped pattern, otherwise false
     */
    boolean isStriped();

    /**
     * Sets whether the view should animate itself. If the view is striped, the animation will run
     * in an infinite loop; if the view is not striped, the animation will only be visible when
     * setProgress() is called.
     *
     * @param animated whether the view should animate its updates or not.
     */
    void setAnimated(boolean animated);

    /**
     * @return true if the view should animate itself
     */
    boolean isAnimated();

    /**
     * @return int maxProgress. Returns the maxProgress value
     */
    int getMaxProgress();


    /**
     * Used for settings the maxprogress. Also check if Cumulative progress is smaller than the
     * max before asigning.
     * @param maxProgress the maxProgress value
     */
    void setMaxProgress(int maxProgress);
}
