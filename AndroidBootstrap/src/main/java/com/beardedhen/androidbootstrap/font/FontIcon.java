package com.beardedhen.androidbootstrap.font;

/**
 * Specifies the icon codes for a Typeface, and provides the filename of the font so that it can be
 * initialised
 */
public interface FontIcon {

    /**
     * Looks up the unicode character for a FontAwesome Icon Code
     *
     * @return the unicode character or a question mark if the FA code wasn't found
     */
    char character();

    /**
     * Specifies the location that the font file resides in, starting from the assets directory
     * e.g."fontawesome-webfont.ttf"
     *
     * @return the font path
     */
    CharSequence fontPath();

}
