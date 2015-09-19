package com.beardedhen.androidbootstrap.support;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Bootstrap Text provides a Builder class, which allows convenient construction of SpannableStrings.
 * Currently regular text and FontAwesome icons can be added.
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

        private final List<Integer> fontAwesomeIndices;

        public Builder(Context context) {
            fontAwesomeIndices = new ArrayList<>();
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
         * Appends a FontAwesome Icon to the BootstrapText under construction. The FA code e.g.
         * fa-play, should be supplied rather than the unicode.
         *
         * @param icon the FA code for the icon
         * @return the updated builder instance
         */
        public Builder addFaIcon(CharSequence icon) {
            CharSequence unicode = FontAwesomeIconMap.getUnicode(icon);
            sb.append(unicode);
            fontAwesomeIndices.add(sb.length());
            return this;
        }

        /**
         * @return a new instance of BootstrapText, constructed according to Builder arguments.
         */
        public BootstrapText build() {
            BootstrapText bootstrapText = new BootstrapText(sb.toString());

            for (Integer index : fontAwesomeIndices) {
                FontAwesomeTypefaceSpan span = new FontAwesomeTypefaceSpan(context);
                bootstrapText.setSpan(span, index - 1, index, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
            return bootstrapText;
        }
    }

}