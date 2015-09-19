package com.beardedhen.androidbootstrap.api.view;

/**
 * Views which implement this interface visually display ongoing progress to users
 */
public interface ProgressView {

    /**
     * Updates the amount of progress displayed to the user.
     *
     * @param progress an integer between 0-100
     */
    void setProgress(int progress);

    /**
     * @return the amount of progress displayed to the user (0-100)
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

}
