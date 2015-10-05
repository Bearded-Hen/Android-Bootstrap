package com.beardedhen.androidbootstrap.font;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

import com.beardedhen.androidbootstrap.TypefaceProvider;

// TODO see Iconify Span https://goo.gl/sdUwwm

/**
 * A custom span which changes the text to the supplied typeface
 */
public class AwesomeTypefaceSpan extends TypefaceSpan {

    private final Context context;
    private final IconSet iconSet;

    public AwesomeTypefaceSpan(Context context, IconSet iconSet) {
        super(iconSet.fontPath().toString());
        this.context = context.getApplicationContext();
        this.iconSet = iconSet;
    }

    @Override public void updateDrawState(@NonNull TextPaint ds) {
        ds.setTypeface(TypefaceProvider.getTypeface(context, iconSet));
    }

    @Override public void updateMeasureState(@NonNull TextPaint paint) {
        paint.setTypeface(TypefaceProvider.getTypeface(context, iconSet));
    }

}
