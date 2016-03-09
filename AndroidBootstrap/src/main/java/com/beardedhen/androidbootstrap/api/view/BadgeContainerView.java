package com.beardedhen.androidbootstrap.api.view;

import com.beardedhen.androidbootstrap.BootstrapBadge;

/**
 * Classes which implement this interface can be used as BootstrapBadge container.
 * For example, a Button can be set up with BootstrapBadge.
 */
public interface BadgeContainerView {

    String KEY = "com.beardedhen.androidbootstrap.api.view.BadgeContainerView";

    /**
     * Sets the badge object to be used inside a container.
     *
     * @param badge BootstrapBadge to setup
     */
    void setBadge(BootstrapBadge badge);

    /**
     * Sets badge count to be displayed to user.
     *
     * @param count badge count
     */
    void setBadgeCount(int count);

    /**
     * Retrieves BootstrapBadge object from container view.
     *
     * @return BootstrapBadge if exist or null if not
     */
    BootstrapBadge getBootstrapBadge();

    /**
     * Retrieves current badge count.
     *
     * @return badge count
     */
    int getBadgeCount();

    /**
     * Method where badge display logic must be implemented
     *
     */
    void displayBadgeDrawable();
}
