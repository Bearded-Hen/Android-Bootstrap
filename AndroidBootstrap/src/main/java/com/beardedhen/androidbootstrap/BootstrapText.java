package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;

import java.util.ArrayList;
import java.util.List;

import static com.beardedhen.androidbootstrap.BootstrapText.TextType.FONTAWESOME;
import static com.beardedhen.androidbootstrap.BootstrapText.TextType.REGULAR;

public class BootstrapText extends SpannableString {

    enum TextType {
        REGULAR,
        FONTAWESOME
    }

    public BootstrapText(CharSequence source) {
        super(source);
    }

    public static class Builder {

        private final List<TextSnippet> wordList;
        private final StringBuilder sb;
        private final Context context;

        public Builder(Context context) {
            wordList = new ArrayList<>();
            sb = new StringBuilder();
            this.context = context.getApplicationContext();
        }

        public Builder addText(CharSequence text) {
            sb.append(text);
            wordList.add(new TextSnippet(text, REGULAR));
            return this;
        }

        public Builder addFaIcon(CharSequence icon) {
            CharSequence unicode = FontAwesomeIconMap.getUnicode(icon);
            sb.append(unicode);

            wordList.add(new TextSnippet(unicode, FONTAWESOME));
            return this;
        }

        public BootstrapText build() {
            BootstrapText bootstrapText = new BootstrapText(sb.toString());
            FontAwesomeTypefaceSpan typefaceSpan = new FontAwesomeTypefaceSpan(context);
            int start = 0;

            for (TextSnippet textSnippet : wordList) {
                if (textSnippet.textType == FONTAWESOME) {

                    int end = start + textSnippet.shard.length();
                    bootstrapText.setSpan(typefaceSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                start += textSnippet.shard.length();
            }
            return bootstrapText;
        }

        private static class TextSnippet {

            private final CharSequence shard;
            private final TextType textType;

            public TextSnippet(CharSequence shard, TextType textType) {
                this.shard = shard;
                this.textType = textType;
            }
        }
    }

}