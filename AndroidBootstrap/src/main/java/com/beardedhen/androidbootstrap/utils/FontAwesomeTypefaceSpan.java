package com.beardedhen.androidbootstrap.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class FontAwesomeTypefaceSpan extends TypefaceSpan {

    private final Context context;

    public FontAwesomeTypefaceSpan(Context context) {
        super("FontAwesome");
        this.context = context.getApplicationContext();
    }

    @Override public void updateDrawState(@NonNull TextPaint ds) {
        ds.setTypeface(FontAwesomeIconMap.getFont(context));
    }

    @Override public void updateMeasureState(@NonNull TextPaint paint) {
        paint.setTypeface(FontAwesomeIconMap.getFont(context));
    }

}
