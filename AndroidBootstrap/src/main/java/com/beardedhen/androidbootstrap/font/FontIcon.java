package com.beardedhen.androidbootstrap.font;

/**
 * Specifies the icon codes for a Typeface, and provides the filename of the font so that it can be
 * initialised
 */
public interface FontIcon {

    /**
     * Returns the unicode character for the current Font Icon.
     *
     * @return the unicode character
     */
    char unicode();

    /**
     * Retrieves the icon code for the current Font Icon. e.g. "fa-play" specifies the play icon
     * unicode character in the FontAwesome Typeface.
     *
     * @return the icon code
     */
    CharSequence iconCode();

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
