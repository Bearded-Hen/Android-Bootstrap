package com.beardedhen.androidbootstrap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_HORI;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_VERT;

public class CustomDrawable extends Drawable {

    private Paint bgPaint;
    private Paint strokePaint;

    private boolean rounded;
    private int radius;
    private int strokeWidth;

    private boolean drawStartBorder = true;
    private boolean drawTopBorder = true;

    private BootstrapButton.Position position;

    public CustomDrawable(BootstrapButton.Position position, boolean rounded, int radius, int strokeWidth) {
        this.rounded = rounded;

        this.radius = radius;
        this.strokeWidth = strokeWidth;
        this.position = position;

        bgPaint = new Paint();
        bgPaint.setColor(Color.RED);
        bgPaint.setStyle(Paint.Style.FILL);

        strokePaint = new Paint();
        strokePaint.setColor(Color.BLACK);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(strokeWidth);
        strokePaint.setAntiAlias(true);


        switch (position) {
            case MIDDLE_HORI:
                drawStartBorder = false;
                break;
            case MIDDLE_VERT:
                drawTopBorder = false;
                break;
            case BOTTOM:
                drawTopBorder = false;
                break;
            case END:
                drawStartBorder = false;
                break;
        }
    }

    @Override public void draw(Canvas canvas) {
        int w = canvas.getWidth();
        int h = canvas.getHeight();

        if (rounded && (position != MIDDLE_VERT && position != MIDDLE_HORI)) {
            drawRoundButton(canvas, w, h);
        }
        else { // draw rounded corners
            drawSquareButton(canvas, w, h);
        }
    }

    private void drawSquareButton(Canvas canvas, int w, int h) {
        canvas.drawRect(0, 0, w, h, bgPaint);

        // start at top left corner, move clockwise

        if (drawTopBorder) {
            canvas.drawLine(0, 0, w, 0, strokePaint);
        }

        // always draw bottom/end borders
        canvas.drawLine(w, 0, w, h, strokePaint);
        canvas.drawLine(w, h, 0, h, strokePaint);

        if (drawStartBorder) {
            canvas.drawLine(0, h, 0, 0, strokePaint);
        }
    }

    private void drawRoundButton(Canvas canvas, int w, int h) {
//        Path path = new Path();

        RectF rectF = new RectF(0, 0, w, h);
        bgPaint.setPathEffect(new CornerPathEffect(radius));
        strokePaint.setPathEffect(new CornerPathEffect(radius));

        strokePaint.setDither(true);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeJoin(Paint.Join.ROUND);
        strokePaint.setStrokeCap(Paint.Cap.ROUND);


//        canvas.drawRect(rectF, bgPaint);
        canvas.drawRect(rectF, strokePaint);


//        // start at top left corner, move clockwise
//
//        if (drawTopBorder) {
//            canvas.drawLine(0, 0, w, 0, strokePaint);
//        }
//
//        // always draw bottom/end borders
//        canvas.drawLine(w, 0, w, h, strokePaint);
//        canvas.drawLine(w, h, 0, h, strokePaint);
//
//        if (drawStartBorder) {
//            canvas.drawLine(0, h, 0, 0, strokePaint);
//        }
//
//        canvas.drawRect(radius, radius, w-radius, h-radius, bgPaint);
//
//        // start right after top left corner, move clockwise
//        path.moveTo(radius, 0);
//        path.lineTo(w, 0);
//
//        // TODO top-right corner
//        path.lineTo(w, h);
//
//
//        // TODO bottom-right corner
//
//        path.lineTo(0, h);
//
//        // TODO bottom-left corner
//
//        path.lineTo(0, radius);
//
//        // TODO top-left corner
//        path.quadTo(0, 0, radius, 0);
//
//
//
//        canvas.drawPath(path, bgPaint);
//        canvas.drawPath(path, strokePaint);

    }

    @Override public void setAlpha(int alpha) {

    }

    @Override public void setColorFilter(ColorFilter cf) {

    }

    @Override public int getOpacity() {
        return 0;
    }

}
