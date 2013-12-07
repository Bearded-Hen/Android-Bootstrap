package com.beardedhen.androidbootstrap.utils;

import android.graphics.Typeface;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.FontAwesome;
import com.beardedhen.androidbootstrap.R;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class FontUtils
{
    private static String ROBOTO_LOCATION_PREFIX = "fonts/Roboto/";
    private static String ROBOTO_CONDENSED_LOCATION_PREFIX = "fonts/RobotoCondensed/";

    private static HashMap<String, FontType> fontTypes;

    static{

        fontTypes = new HashMap<String, FontType>();

        //Roboto
        fontTypes.put("roboto-black", FontType.ROBOTO_BLACK);
        fontTypes.put("roboto-black-italic", FontType.ROBOTO_BLACK_ITALIC);
        fontTypes.put("roboto-bold", FontType.ROBOTO_BOLD);
        fontTypes.put("roboto-bold-italic", FontType.ROBOTO_BOLD_ITALIC);
        fontTypes.put("roboto-italic", FontType.ROBOTO_ITALIC);
        fontTypes.put("roboto-light", FontType.ROBOTO_LIGHT);
        fontTypes.put("roboto-light-italic", FontType.ROBOTO_LIGHT_ITALIC);
        fontTypes.put("roboto-medium", FontType.ROBOTO_MEDIUM);
        fontTypes.put("roboto-medium-italic", FontType.ROBOTO_MEDIUM_ITALIC);
        fontTypes.put("roboto-regular", FontType.ROBOTO_REGULAR);
        fontTypes.put("roboto-thin", FontType.ROBOTO_THIN);
        fontTypes.put("roboto-italic", FontType.ROBOTO_THIN_ITALIC);

        //Roboto Condensed
        fontTypes.put("robotoCondensed-bold", FontType.ROBOTO_CONDENSED_BOLD);
        fontTypes.put("robotoCondensed-bold-italic", FontType.ROBOTO_CONDENSED_BOLD_ITALIC);
        fontTypes.put("robotoCondensed-italic", FontType.ROBOTO_CONDENSED_ITALIC);
        fontTypes.put("robotoCondensed-light", FontType.ROBOTO_CONDENSED_LIGHT);
        fontTypes.put("robotoCondensed-light-italic", FontType.ROBOTO_CONDENSED_LIGHT_ITALIC);
        fontTypes.put("robotoCondensed-regular", FontType.ROBOTO_CONDENSED_REGULAR);

    }

    private enum FontType
    {
        ROBOTO_BLACK(ROBOTO_LOCATION_PREFIX + "Roboto-Black.ttf"),
        ROBOTO_BLACK_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-BlackItalic.ttf"),
        ROBOTO_BOLD(ROBOTO_LOCATION_PREFIX + "Roboto-Bold.ttf"),
        ROBOTO_BOLD_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-BoldItalic.ttf"),
        ROBOTO_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-Italic.ttf"),
        ROBOTO_LIGHT(ROBOTO_LOCATION_PREFIX + "Roboto-Light.ttf"),
        ROBOTO_LIGHT_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-LightItalic.ttf"),
        ROBOTO_MEDIUM(ROBOTO_LOCATION_PREFIX + "Roboto-Medium.ttf"),
        ROBOTO_MEDIUM_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-MediumItalic.ttf"),
        ROBOTO_REGULAR(ROBOTO_LOCATION_PREFIX + "Roboto-Regular.ttf"),
        ROBOTO_THIN(ROBOTO_LOCATION_PREFIX + "Roboto-Thin.ttf"),
        ROBOTO_THIN_ITALIC(ROBOTO_LOCATION_PREFIX + "Roboto-ThinItalic.ttf"),

        ROBOTO_CONDENSED_BOLD(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-Bold.ttf"),
        ROBOTO_CONDENSED_BOLD_ITALIC(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-BoldItalic.ttf"),
        ROBOTO_CONDENSED_ITALIC(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-Italic.ttf"),
        ROBOTO_CONDENSED_LIGHT(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-Light.ttf"),
        ROBOTO_CONDENSED_LIGHT_ITALIC(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-LightItalic.ttf"),
        ROBOTO_CONDENSED_REGULAR(ROBOTO_CONDENSED_LOCATION_PREFIX + "RobotoCondensed-Regular.ttf");


        private String fontName;
        private String fontLocation;

        FontType(String fontLocation)
        {
            this.fontLocation = fontLocation;
        }

        public String getFontLocation()
        {
            return this.fontLocation;
        }
    }

    public static Typeface getFont(Context context, String font)
    {
        Typeface face = null;
        try
        {
            if(fontTypes.containsKey(font))
            {
                FontType type = fontTypes.get(font);
                return Typeface.createFromAsset(context.getAssets(), type.getFontLocation());
            }
        }
        catch (Exception e)
        {
            Log.v("Bootstrap Font", "Error. roboto Please provide a valid font name.");
        }

        return face;
    }

}