package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.graphics.Typeface;

import com.beardedhen.androidbootstrap.font.FontAwesome;
import com.beardedhen.androidbootstrap.font.IconSet;
import com.beardedhen.androidbootstrap.font.MaterialIcons;
import com.beardedhen.androidbootstrap.font.Typicon;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds static instances of Typefaces, and IconSets, allowing views to use them across the application
 * without expensive initialisation.
 */
public class TypefaceProvider {

    private final static Map<CharSequence, Typeface> TYPEFACE_MAP = new HashMap<>();
    private final static Map<CharSequence, IconSet> REGISTERED_ICON_SETS = new HashMap<>();

    /**
     * Returns a reference to the requested typeface, creating a new instance if none already exists
     *
     * @param context the current context
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
     * Registers instances of the Default IconSets so that they are available throughout the whole
     * application. Currently the default icon sets include FontAwesome and Typicon.
     */
    public static void registerDefaultIconSets() {
        final FontAwesome fontAwesome = new FontAwesome();
        final Typicon typicon = new Typicon();
        final MaterialIcons materialIcons = new MaterialIcons();

        REGISTERED_ICON_SETS.put(fontAwesome.fontPath(), fontAwesome);
        REGISTERED_ICON_SETS.put(typicon.fontPath(), typicon);
        REGISTERED_ICON_SETS.put(materialIcons.fontPath(), materialIcons);
    }

    /**
     * Registers a custom IconSet, so that it is available for use throughout the whole application.
     *
     * @param iconSet a custom IconSet
     */
    public static void registerCustomIconSet(IconSet iconSet) {
        REGISTERED_ICON_SETS.put(iconSet.fontPath(), iconSet);
    }

    /**
     * Retrieves a registered IconSet whose font can be found in the asset directory at the given path
     *
     * @param fontPath the given path
     * @param editMode - whether the view requesting the icon set is displayed in the preview editor
     * @return the registered IconSet instance
     */
    public static IconSet retrieveRegisteredIconSet(String fontPath, boolean editMode) {
        final IconSet iconSet = REGISTERED_ICON_SETS.get(fontPath);

        if (iconSet == null && !editMode) {
            throw new RuntimeException(String.format("Font '%s' not properly registered, please" +
                    " see the README at https://github.com/Bearded-Hen/Android-Bootstrap", fontPath));
        }
        return iconSet;
    }

    /**
     * Retrieves a collection of all registered IconSets in the application
     *
     * @return a collection of registered IconSets.
     */
    public static Collection<IconSet> getRegisteredIconSets() {
        return REGISTERED_ICON_SETS.values();
    }

}
