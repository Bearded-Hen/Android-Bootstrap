package com.beardedhen.androidbootstrap.font;

/**
 * Specifies all the FontIcons that exist for an icon set, and provides the path of the font file
 * in the assets directory.
 */
public interface FontIconSet {

    /**
     * Specifies the location that the font file resides in, starting from the assets directory
     * e.g."fontawesome-webfont.ttf"
     *
     * @return the font path
     */
    CharSequence fontPath();

    /**
     * Retrieves all possible FontIcon values for this implementation
     *
     * @return all possible FontIcon values
     */
    FontIcon[] allValues();

}
