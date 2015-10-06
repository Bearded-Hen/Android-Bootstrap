package com.beardedhen.androidbootstrap.api.view;

/**
 * Views which implement this interface allow the user to specify whether the view should be
 * displayed as an outline or not.
 */
public interface OutlineableView {

    String KEY = "Outlineable";

    /**
     * Sets whether the view should display itself as an outline or not.
     *
     * @param showOutline true to display as an outline, otherwise false
     */
    void setShowOutline(boolean showOutline);

    /**
     * @return true if the view is currently displaying itself as an outline
     */
    boolean isShowOutline();

}
