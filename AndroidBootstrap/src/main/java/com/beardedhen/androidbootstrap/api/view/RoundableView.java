package com.beardedhen.androidbootstrap.api.view;

/**
 * Views which implement this interface allow the user to specify whether the view should have
 * rounded corners or not. The interpretation of what a 'rounded corner' is will differ between views.
 */
public interface RoundableView {

    String KEY = "com.beardedhen.androidbootstrap.api.view.Roundable";

    /**
     * Sets whether the view should display rounded corners or not
     *
     * @param rounded whether the view should be rounded
     */
    void setRounded(boolean rounded);

    /**
     * @return true if the view is displaying rounded corners, otherwise false
     */
    boolean isRounded();

}
