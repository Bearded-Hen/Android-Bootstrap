package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BootstrapProgressBar extends View {

    private Paint progressPaint;
    private Paint bgPaint;

    public BootstrapProgressBar(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {

    }

}
