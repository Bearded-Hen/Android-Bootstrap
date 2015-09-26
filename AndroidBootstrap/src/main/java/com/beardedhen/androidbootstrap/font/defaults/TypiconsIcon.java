package com.beardedhen.androidbootstrap.font.defaults;

import com.beardedhen.androidbootstrap.font.FontIcon;
import com.beardedhen.androidbootstrap.font.FontIconSet;

/**
 * Maps Typicons Icon Codes to unicode characters, allowing its use in AwesomeTextView.
 * See the <a href='http://typicons.com/'>Cheatsheet</a> for icon
 * code reference. <b>Please note that icon codes use underscores rather than hyphens in this
 * library.</b> For example, "fa-play" would become "fa_play". This is due to restrictions in how
 * Android Attributes can be named.
 */
public enum TypiconsIcon implements FontIcon {

    WEATHER_CLOUDY('\ue13b', "weather_cloudy");

    private final char unicode;
    private final CharSequence iconCode;
    private static final FontIconSet ICON_SET = new TypiconsIconSet();

    TypiconsIcon(char unicode, CharSequence iconCode) {
        this.unicode = unicode;
        this.iconCode = iconCode;
    }

    @Override public char unicode() {
        return unicode;
    }

    @Override public CharSequence iconCode() {
        return iconCode;
    }

    @Override public FontIconSet iconSet() {
        return ICON_SET;
    }

}
