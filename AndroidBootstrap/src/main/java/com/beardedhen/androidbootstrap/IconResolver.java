package com.beardedhen.androidbootstrap;

import android.content.Context;

import com.beardedhen.androidbootstrap.font.FontIcon;
import com.beardedhen.androidbootstrap.font.FontIconSet;
import com.beardedhen.androidbootstrap.font.TypefaceProvider;
import com.beardedhen.androidbootstrap.font.defaults.FontAwesomeIcon;
import com.beardedhen.androidbootstrap.font.defaults.FontAwesomeIconSet;
import com.beardedhen.androidbootstrap.support.BootstrapText;

/**
 * Resolves markdown strings using FA codes and produces BootstrapText instances.
 */
public class IconResolver {

    private static final String REGEX_FONT_AWESOME = "fa_[a-z_0-9]+";

    /**
     * Resolves markdown to produce a BootstrapText instance. e.g. "{fa_android}" would be replaced
     * with the appropriate FontAwesome character and a SpannableString producec.
     *
     * @param context  the current context
     * @param markdown the markdown string
     * @return a constructed BootstrapText
     */
    public static BootstrapText resolveMarkdown(Context context, String markdown) {
        if (markdown == null) {
            return null;
        }
        else { // detect {fa_*} and split into spannable, ignore escaped chars
            BootstrapText.Builder builder = new BootstrapText.Builder(context);

            int lastAddedIndex = 0;
            int startIndex = -1;
            int endIndex = -1;

            for (int i = 0; i < markdown.length(); i++) {
                char c = markdown.charAt(i);

                if (c == '\\') { // escape sequence, ignore next char
                    i += 2;
                    continue;
                }

                if (c == '{') {
                    startIndex = i;
                }
                else if (c == '}') {
                    endIndex = i;
                }

                if (startIndex != -1 && endIndex != -1) { // recognised markdown string

                    if (startIndex >= 0 && endIndex < markdown.length()) {
                        String iconCode = markdown.substring(startIndex + 1, endIndex);

                        builder.addText(markdown.substring(lastAddedIndex, startIndex));

                        if (iconCode.matches(REGEX_FONT_AWESOME)) { // text is FontAwesome code
                            builder.addIcon(resolveIconCode(iconCode, FontAwesomeIcon.values()));
                        }
                        else {
                            builder.addIcon(resolveUnknownIconCode(iconCode));
                        }
                        lastAddedIndex = endIndex + 1;
                    }
                    startIndex = -1;
                    endIndex = -1;
                }
            }
            return builder.addText(markdown.substring(lastAddedIndex, markdown.length())).build();
        }
    }

    /**
     * Searches for the unicode character value for the Font Icon Code. This method searches all
     * active FontIcons in the application.
     *
     * @param iconCode the font icon code
     * @return the unicode character matching the icon, or null if none matches
     */
    private static FontIcon resolveUnknownIconCode(CharSequence iconCode) {
        FontIcon fontIcon;

        for (FontIconSet set : TypefaceProvider.getRegisteredIconSets()) {

            if (set.fontPath().equals(FontAwesomeIconSet.FONT_PATH)) {
                continue; // already checked previously
            }

            fontIcon = resolveIconCode(iconCode, set.allValues());

            if (fontIcon != null) {
                return fontIcon;
            }
        }

        String message = String.format("Could not find FontIcon value for '%s', " +
                "please ensure that it is mapped to a valid font", iconCode);

        throw new IllegalArgumentException(message);
    }

    /**
     * Searches for the unicode character value for the Font Icon Code, in the supplied values
     *
     * @param values   the FontIcon values for this font
     * @param iconCode the font icon code
     * @return the unicode character matching the icon, or null if none matches
     */
    private static FontIcon resolveIconCode(CharSequence iconCode, FontIcon[] values) {
        for (FontIcon fontIcon : values) {
            if (fontIcon.iconCode().equals(iconCode)) {
                return fontIcon;
            }
        }
        return null;
    }


    static FontIcon fromAttributeValue(int index, FontIconSet fontIconSet) {
        FontIcon[] values = fontIconSet.allValues();

        if (index < 0 || index > values.length) {
            throw new IllegalArgumentException();
        }
        else {
            return values[index];
        }
    }

}
