package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BootstrapText extends SpannableString implements Serializable {

    static final String KEY = "BootstrapText";

    enum TextType {
        REGULAR,
        FONTAWESOME
    }

    public BootstrapText(CharSequence source) {
        super(source);
    }

    public static class Builder {

        private final StringBuilder sb;
        private final Context context;

        private final List<Integer> fontAwesomeIndices;

        public Builder(Context context) {
            fontAwesomeIndices = new ArrayList<>();
            sb = new StringBuilder();
            this.context = context.getApplicationContext();
        }

        public Builder addText(CharSequence text) {
            sb.append(text);
            return this;
        }

        public Builder addFaIcon(CharSequence icon) {
            CharSequence unicode = FontAwesomeIconMap.getUnicode(icon);
            sb.append(unicode);
            fontAwesomeIndices.add(sb.length());
            return this;
        }

        public BootstrapText build() {
            BootstrapText bootstrapText = new BootstrapText(sb.toString());

            for (Integer index : fontAwesomeIndices) {
                FontAwesomeTypefaceSpan span = new FontAwesomeTypefaceSpan(context);
                bootstrapText.setSpan(span, index-1, index, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
            return bootstrapText;
        }
    }

}