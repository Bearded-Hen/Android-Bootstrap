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
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

/**
 * BootstrapCircleThumbnails display a circular image with an optional border, that can be themed
 * using BootstrapBrand colors. The view extends ImageView, and will automatically center crop and
 * scale images.
 */
public class BootstrapCircleThumbnail extends BootstrapBaseThumbnail {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapCircleThumbnail";

    private final RectF imageRectF = new RectF();
    private final Matrix matrix = new Matrix();

    public BootstrapCircleThumbnail(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    protected void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapCircleThumbnail);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapCircleThumbnail_bootstrapBrand, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapCircleThumbnail_bootstrapSize, -1);

            this.hasBorder = a.getBoolean(R.styleable.BootstrapCircleThumbnail_hasBorder, true);
            this.bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();

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

        baselineOuterBorderWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bthumbnail_outer_stroke);
        super.initialise(attrs);
    }

    /**
     * This method is called when the Circle Image needs to be recreated due to changes in size etc.
     * A Paint object uses a BitmapShader to draw a center-cropped, circular image onto the View
     * Canvas. A Matrix on the BitmapShader scales the original Bitmap to match the current view
     * bounds, avoiding any inefficiencies in duplicating Bitmaps.
     * <a href="http://www.curious-creature.com/2012/12/11/android-recipe-1-image-with-rounded-corners">
     * Further reading</a>
     */
    protected void updateImageState() {
        float viewWidth = getWidth();
        float viewHeight = getHeight();

        if ((int) viewWidth <= 0 || (int) viewHeight <= 0) {
            return;
        }

        if (sourceBitmap != null) {
            BitmapShader imageShader = new BitmapShader(sourceBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            imagePaint.setShader(imageShader);

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
            imageRectF.set(0, 0, viewWidth, viewHeight);
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

        // draw the image paint first, then draw a border as a Stroke paint (if needed)
        float center = viewWidth / 2;
        float imageRadius = center;

        if (hasBorder) {
            imageRadius -= (baselineBorderWidth * bootstrapSize);
        }

        Paint paint = (isPlaceholder) ? placeholderPaint : imagePaint;
        canvas.drawCircle(center, center, imageRadius, paint);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = MeasureSpec.getSize(widthMeasureSpec); // AT_MOST/EXACTLY are used by default
        int h = MeasureSpec.getSize(heightMeasureSpec);

        if (sourceBitmap != null) {
            if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED) {
                w = sourceBitmap.getWidth();
            }
            if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.UNSPECIFIED) {
                h = sourceBitmap.getHeight();
            }
        }

        if (w > h) { // no ovals allowed
            w = h;
        }
        if (h > w) {
            h = w;
        }
        setMeasuredDimension(w, h);
    }

    private void updateBackground() {
        Drawable bg = null;

        if (hasBorder) {
            bg = BootstrapDrawableFactory.bootstrapCircleThumbnail(
                    getContext(),
                    bootstrapBrand,
                    (int) (baselineOuterBorderWidth * bootstrapSize),
                    ColorUtils.resolveColor(R.color.bootstrap_thumbnail_background, getContext()));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
    }

}
