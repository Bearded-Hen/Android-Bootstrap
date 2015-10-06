package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;

import com.beardedhen.androidbootstrap.font.AwesomeTypefaceSpan;
import com.beardedhen.androidbootstrap.font.FontAwesome;
import com.beardedhen.androidbootstrap.font.IconSet;
import com.beardedhen.androidbootstrap.font.Typicon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Bootstrap Text provides a Builder class, which allows convenient construction of SpannableStrings.
 * Currently regular text, FontAwesome icons, and Typicons can be added.
 */
public class BootstrapText extends SpannableString implements Serializable {

    private BootstrapText(CharSequence source) {
        super(source);
    }

    /**
     * This class should be used to construct BootstrapText instances. Text is appended to itself
     * in the order in which it was added.
     */
    public static class Builder {

        private final StringBuilder sb;
        private final Context context;

        private final Map<Integer, IconSet> fontIndicesMap;

        public Builder(Context context) {
            fontIndicesMap = new HashMap<>();
            sb = new StringBuilder();
            this.context = context.getApplicationContext();
        }

        /**
         * Appends a regular piece of text to the BootstrapText under construction.
         *
         * @param text a regular piece of text
         * @return the updated builder instance
         */
        public Builder addText(CharSequence text) {
            sb.append(text);
            return this;
        }

        /**
         * Appends a FontAwesomeIcon to the BootstrapText under construction
         * @return the updated builder instance
         */
        public Builder addFontAwesomeIcon(@FontAwesome.Icon CharSequence iconCode) {
            IconSet iconSet = TypefaceProvider.retrieveRegisteredIconSet(FontAwesome.FONT_PATH);
            sb.append(iconSet.unicodeForKey(iconCode));
            fontIndicesMap.put(sb.length(), iconSet);
            return this;
        }

        /**
         * Appends a Typicon to the BootstrapText under construction
         * @return the updated builder instance
         */
        public Builder addTypicon(@Typicon.Icon CharSequence iconCode) {
            IconSet iconSet = TypefaceProvider.retrieveRegisteredIconSet(Typicon.FONT_PATH);
            sb.append(iconSet.unicodeForKey(iconCode));
            fontIndicesMap.put(sb.length(), iconSet);
            return this;
        }

        /**
         * Appends a font icon to the BootstrapText under construction
         * @param iconSet a font icon
         * @return the updated builder instance
         */
        public Builder addIcon(CharSequence iconCode, IconSet iconSet) {
            sb.append(iconSet.unicodeForKey(iconCode));
            fontIndicesMap.put(sb.length(), iconSet);
            return this;
        }

        /**
         * @return a new instance of BootstrapText, constructed according to Builder arguments.
         */
        public BootstrapText build() {
            BootstrapText bootstrapText = new BootstrapText(sb.toString());

            for (Map.Entry<Integer, IconSet> entry : fontIndicesMap.entrySet()) {
                int index = entry.getKey();

                AwesomeTypefaceSpan span = new AwesomeTypefaceSpan(context, entry.getValue());
                bootstrapText.setSpan(span, index - 1, index, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
            return bootstrapText;
        }
    }

}