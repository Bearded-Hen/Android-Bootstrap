package com.beardedhen.androidbootstrap.font.defaults;

import com.beardedhen.androidbootstrap.font.FontIcon;
import com.beardedhen.androidbootstrap.font.FontIconSet;

/**
 * Describes all the icons within the FontAwesome set, and provides the location of its font
 * within the asset directory
 */
public class FontAwesomeIconSet implements FontIconSet {

    public static final String FONT_PATH = "fontawesome-webfont-v440.ttf";

    @Override public CharSequence fontPath() {
        return FONT_PATH;
    }

    @Override public FontIcon[] allValues() {
        return FontAwesomeIcon.values();
    }

}
