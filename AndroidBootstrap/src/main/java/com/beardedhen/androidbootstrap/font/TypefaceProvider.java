package com.beardedhen.androidbootstrap.font;

import android.content.Context;
import android.graphics.Typeface;

import com.beardedhen.androidbootstrap.font.defaults.FontAwesomeIconSet;
import com.beardedhen.androidbootstrap.font.defaults.TypiconsIconSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds static instances of Typefaces
 */
public class TypefaceProvider {

    private final static Map<CharSequence, Typeface> TYPEFACE_MAP = new HashMap<>();
    private final static List<FontIconSet> FONT_ICON_SET_LIST = new ArrayList<>();

    /**
     * Returns a reference to the requested typeface, creating a new instance if none already exists
     *
     * @param context  the current context
     * @param fontIcon the icon typeface
     * @return a reference to the typeface instance
     */
    public static Typeface getTypeface(Context context, FontIconSet fontIcon) {
        String path = fontIcon.fontPath().toString();
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

    /**
     * Performs setup of the Default FontIconSets so that they are available throughout the whole
     * application. Currently the default icon set includes FontAwesome.
     */
    public static void registerDefaultIconSets() {
        FONT_ICON_SET_LIST.add(new FontAwesomeIconSet());
        FONT_ICON_SET_LIST.add(new TypiconsIconSet());
    }

    /**
     * Performs setup of a custom FontIconSet, so that it is available throughout the whole application.
     *
     * @param fontIconSet a custom FontIconSet
     */
    public static void registerCustomIconSet(FontIconSet fontIconSet) {
        FONT_ICON_SET_LIST.add(fontIconSet);
    }

    /**
     * @return a list of registered FontIconSets.
     */
    public static List<FontIconSet> getRegisteredIconSets() {
        return FONT_ICON_SET_LIST;
    }

}
