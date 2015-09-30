package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.RoundableView;

// TODO document/finalise

public class BootstrapThumbnail extends BootstrapBaseThumbnail implements RoundableView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapThumbnail";

    private boolean roundedCorners;
    private float cornerRadius;

    private final RectF imageRectF = new RectF();
    private final Matrix matrix = new Matrix();

    public BootstrapThumbnail(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapThumbnail(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapThumbnail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());
        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
    }

    protected void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapThumbnail);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapThumbnail_bootstrapBrand, -1);
            this.hasBorder = a.getBoolean(R.styleable.BootstrapCircleThumbnail_hasBorder, true);

            if (typeOrdinal == -1) { // override to use Primary for default border (looks nicer)
                this.bootstrapBrand = DefaultBootstrapBrand.PRIMARY;
            }
            else {
                this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);
            }
        }
        finally {
            a.recycle();
        }
        this.cornerRadius = getResources().getDimension(R.dimen.bthumbnail_rounded_corner);
        super.initialise(attrs);
    }

    /**
     * This method is called when the Rectangle Image needs to be recreated due to changes in size
     * etc.
     * <p/>
     * A Paint object uses a BitmapShader to draw a scaled image onto the View
     * Canvas, thus avoiding any inefficiencies in duplicating Bitmaps.
     * <p/>
     * <a href="http://www.curious-creature.com/2012/12/11/android-recipe-1-image-with-rounded-corners">
     * Further reading</a>
     */
    protected void updateImageState() {
        float xOri = 0;
        float yOri = 0;
        float viewWidth = getWidth();
        float viewHeight = getHeight();

        if ((int) viewWidth <= 0 || (int) viewHeight <= 0) {
            return;
        }

        if (sourceBitmap != null) {
            BitmapShader imageShader = new BitmapShader(sourceBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            imagePaint.setShader(imageShader);

            if (hasBorder) {
                xOri += borderWidth;
                yOri += borderWidth;
                viewWidth -= borderWidth;
                viewHeight -= borderWidth;
            }

            // Scale the bitmap using a matrix, ensuring that it always matches the view bounds.
            float bitmapWidth = sourceBitmap.getWidth();
            float bitmapHeight = sourceBitmap.getHeight();

            float scaleFactor = (bitmapWidth < bitmapHeight) ? bitmapWidth : bitmapHeight;
            float xScale = viewWidth / scaleFactor;
            float yScale = viewHeight / scaleFactor;

            // Translate image to center crop (if it is not a perfect square bitmap)
            float dx = 0;
            float dy = 0;

            if (bitmapWidth > bitmapHeight) {
                dx = (viewWidth - bitmapWidth * xScale) * 0.5f;
            }
            else if (bitmapHeight > bitmapWidth) {
                dy = (viewHeight - bitmapHeight * yScale) * 0.5f;
            }

            matrix.set(null);
            matrix.setScale(xScale, yScale);
            matrix.postTranslate((dx + 0.5f), (dy + 0.5f));

            imageShader.setLocalMatrix(matrix);
            imageRectF.set(xOri, yOri, viewWidth, viewHeight);
        }
        updateBackground();
        invalidate();
    }

    @Override protected void onDraw(@NonNull Canvas canvas) {
        float viewWidth = getWidth();
        float viewHeight = getHeight();

        if ((int) viewWidth <= 0 || (int) viewHeight <= 0) {
            return;
        }

        boolean isPlaceholder = sourceBitmap == null;
        Paint paint = (isPlaceholder) ? placeholderPaint : imagePaint;

        if (roundedCorners) {
            canvas.drawRoundRect(imageRectF, cornerRadius, cornerRadius, paint);
        }
        else {
            canvas.drawRect(imageRectF, paint);
        }
    }

    private void updateBackground() {
        Drawable bg = null;

        if (hasBorder) {
            bg = BootstrapDrawableFactory.bootstrapThumbnail(
                    getContext(),
                    bootstrapBrand,
                    (int) outerBorderWidth,
                    getResources().getColor(R.color.bthumbnail_background),
                    roundedCorners);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

    /*
     * Getters/setters
     */

    @Override public void setRounded(boolean rounded) {
        this.roundedCorners = rounded;
        updateImageState();
    }

    @Override public boolean isRounded() {
        return roundedCorners;
    }

}
