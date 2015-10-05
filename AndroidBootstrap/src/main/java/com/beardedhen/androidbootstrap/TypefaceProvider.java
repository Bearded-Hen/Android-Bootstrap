package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.graphics.Typeface;

import com.beardedhen.androidbootstrap.font.FontAwesome;
import com.beardedhen.androidbootstrap.font.IconSet;
import com.beardedhen.androidbootstrap.font.Typicon;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds static instances of Typefaces, and FontIcon sets.
 */
public class TypefaceProvider {

    private final static Map<CharSequence, Typeface> TYPEFACE_MAP = new HashMap<>();
    private final static Map<CharSequence, IconSet> REGISTERED_ICON_SETS = new HashMap<>();

    /**
     * Returns a reference to the requested typeface, creating a new instance if none already exists
     *
     * @param context  the current context
     * @param iconSet the icon typeface
     * @return a reference to the typeface instance
     */
    public static Typeface getTypeface(Context context, IconSet iconSet) {
        String path = iconSet.fontPath().toString();

        if (TYPEFACE_MAP.get(path) == null) {
            final Typeface font = Typeface.createFromAsset(context.getAssets(), path);
            TYPEFACE_MAP.put(path, font);
        }
        return TYPEFACE_MAP.get(path);
    }

    /**
     * Performs setup of the Default FontIconSets so that they are available throughout the whole
     * application. Currently the default icon set includes FontAwesome.
     */
    public static void registerDefaultIconSets() {
        final FontAwesome fontAwesome = new FontAwesome();
        final Typicon typicon = new Typicon();

        REGISTERED_ICON_SETS.put(fontAwesome.fontPath(), fontAwesome);
        REGISTERED_ICON_SETS.put(typicon.fontPath(), typicon);
    }

    /**
     * Performs setup of a custom FontIconSet, so that it is available throughout the whole application.
     *
     * @param iconSet a custom FontIcon
     */
    public static void registerCustomIconSet(IconSet iconSet) {
        REGISTERED_ICON_SETS.put(iconSet.fontPath(), iconSet);
    }

    public static IconSet retrieveRegisteredIconSet(String fontPath) {
        final IconSet iconSet = REGISTERED_ICON_SETS.get(fontPath);

        if (iconSet == null) {
            throw new RuntimeException(String.format("Font '%s' not properly registered", fontPath));
        }
        return iconSet;
    }

    /**
     * @return a collection of registered FontIconSets.
     */
    public static Collection<IconSet> getRegisteredIconSets() {
        return REGISTERED_ICON_SETS.values();
    }

}
