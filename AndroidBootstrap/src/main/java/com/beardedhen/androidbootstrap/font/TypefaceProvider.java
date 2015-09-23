package com.beardedhen.androidbootstrap.font;

import android.content.Context;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds static instances of Typefaces
 */
public class TypefaceProvider {

    private final static Map<CharSequence, Typeface> TYPEFACE_MAP = new HashMap<>();
    private final static List<FontIcon> FONT_ICON_LIST = new ArrayList<>();

    /**
     * Returns a reference to the requested typeface, creating a new instance if none already exists
     *
     * @param context  the current context
     * @param fontIcon the icon typeface
     * @return a reference to the typeface instance
     */
    public static Typeface getTypeface(Context context, FontIcon fontIcon) {
        String path = fontIcon.fontPath().toString();
        FONT_ICON_LIST.add(fontIcon);
        return getTypeface(context, path);
    }

    /**
     * Returns a reference to the requested typeface, creating a new instance if none already exists
     *
     * @param context the current context
     * @param path    the typeface path
     * @return a reference to the typeface instance
     */
    public static Typeface getTypeface(Context context, CharSequence path) {
        if (TYPEFACE_MAP.get(path) == null) {
            final Typeface font = Typeface.createFromAsset(context.getAssets(), path.toString());
            TYPEFACE_MAP.put(path, font);
        }
        return TYPEFACE_MAP.get(path);
    }

    public static List<FontIcon> getFontIconList() {
        return FONT_ICON_LIST;
    }

}
