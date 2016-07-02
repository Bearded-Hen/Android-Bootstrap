package com.beardedhen.androidbootstrap;

import android.content.Context;

import com.beardedhen.androidbootstrap.font.FontAwesome;
import com.beardedhen.androidbootstrap.font.IconSet;
import com.beardedhen.androidbootstrap.font.MaterialIcons;
import com.beardedhen.androidbootstrap.font.Typicon;

import static com.beardedhen.androidbootstrap.TypefaceProvider.getRegisteredIconSets;
import static com.beardedhen.androidbootstrap.TypefaceProvider.retrieveRegisteredIconSet;

/**
 * Resolves markdown strings using FA codes and produces BootstrapText instances.
 */
class IconResolver {

    private static final String REGEX_FONT_AWESOME = "(fa_|fa-)[a-z_0-9]+";
    private static final String REGEX_TYPICONS = "(ty_|ty-)[a-z_0-9]+";
    private static final String REGEX_MATERIAL_ICONS = "(md_)[a-z_0-9]+";

    /**
     * Resolves markdown to produce a BootstrapText instance. e.g. "{fa_android}" would be replaced
     * with the appropriate FontAwesome character and a SpannableString producec.
     *
     * @param context  the current context
     * @param markdown the markdown string
     * @param editMode - whether the view requesting the icon set is displayed in the preview editor
     * @return a constructed BootstrapText
     */
    static BootstrapText resolveMarkdown(Context context, String markdown, boolean editMode) {
        if (markdown == null) {
            return null;
        }
        else { // detect {fa_*} and split into spannable, ignore escaped chars
            BootstrapText.Builder builder = new BootstrapText.Builder(context, editMode);

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
                        String iconCode = markdown.substring(startIndex + 1, endIndex).replaceAll("\\-", "_");
                        builder.addText(markdown.substring(lastAddedIndex, startIndex));

                        if (iconCode.matches(REGEX_FONT_AWESOME)) { // text is FontAwesome code
                            if (editMode) {
                                builder.addText("?");
                            }
                            else {
                                builder.addIcon(iconCode, retrieveRegisteredIconSet(FontAwesome.FONT_PATH, false));
                            }
                        }
                        else if (iconCode.matches(REGEX_TYPICONS)) {
                            if (editMode) {
                                builder.addText("?");
                            }
                            else {
                                builder.addIcon(iconCode, retrieveRegisteredIconSet(Typicon.FONT_PATH, false));
                            }
                        }
                        else if(iconCode.matches(REGEX_MATERIAL_ICONS)){
                            if (editMode) {
                                builder.addText("?");
                            }
                            else {
                                builder.addIcon(iconCode, retrieveRegisteredIconSet(MaterialIcons.FONT_PATH, false));
                            }
                        }
                        else {
                            if (editMode) {
                                builder.addText("?");
                            }
                            else {
                                builder.addIcon(iconCode, resolveIconSet(iconCode));
                            }
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
    private static IconSet resolveIconSet(String iconCode) {
        CharSequence unicode;

        for (IconSet set : getRegisteredIconSets()) {

            if (set.fontPath().equals(FontAwesome.FONT_PATH) || set.fontPath().equals(Typicon.FONT_PATH) || set.fontPath().equals(MaterialIcons.FONT_PATH)) {
                continue; // already checked previously, ignore
            }

            unicode = set.unicodeForKey(iconCode);

            if (unicode != null) {
                return set;
            }
        }

        String message = String.format("Could not find FontIcon value for '%s', " +
                "please ensure that it is mapped to a valid font", iconCode);

        throw new IllegalArgumentException(message);
    }

}
