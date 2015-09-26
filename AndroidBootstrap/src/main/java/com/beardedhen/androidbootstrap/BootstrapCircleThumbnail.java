package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BorderView;

import java.io.Serializable;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

/**
 * BootstrapCircleThumbnails display a circular image with an optional border, that can be themed
 * using BootstrapBrand colors. The view extends ImageView, and will automatically center crop &
 * scale images.
 */
public class BootstrapCircleThumbnail extends ImageView implements BootstrapBrandView, BorderView {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapCircleThumbnail";

    private BootstrapBrand bootstrapBrand;
    private float borderWidth;
    private int borderColor;

    private final RectF imageRectF = new RectF();
    private final Matrix matrix = new Matrix();

    private final Paint imagePaint = new Paint();
    private final Paint placeholderPaint = new Paint();
    private final Paint borderPaint = new Paint();

    private Bitmap sourceBitmap;

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

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putSerializable(BootstrapBrandView.KEY, bootstrapBrand);
        bundle.putFloat(BorderView.KEY_WIDTH, borderWidth);
        bundle.putInt(BorderView.KEY_COLOR, borderColor);

        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.borderWidth = bundle.getFloat(BorderView.KEY_WIDTH);
            this.borderColor = bundle.getInt(BorderView.KEY_COLOR);

            Serializable brand = bundle.getSerializable(BootstrapBrandView.KEY);

            if (brand instanceof BootstrapBrand) {
                this.bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateImageState();
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapCircleThumbnail);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapCircleThumbnail_bootstrapBrand, -1);
            this.borderColor = a.getColor(R.styleable.BootstrapCircleThumbnail_borderColor, -1);
            this.borderWidth = a.getDimension(R.styleable.BootstrapCircleThumbnail_borderWidth, -1);

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
        updateImageState();
    }

    /**
     * This method is called when the Circle Image needs to be recreated due to changes in size etc.
     * <p/>
     * A Paint object uses a BitmapShader to draw a center-cropped, circular image onto the View
     * Canvas. A Matrix on the BitmapShader scales the original Bitmap to match the current view
     * bounds, avoiding any inefficiencies in duplicating Bitmaps.
     * <p/>
     * <a href="http://www.curious-creature.com/2012/12/11/android-recipe-1-image-with-rounded-corners">
     * Further reading</a>
     */
    private void updateImageState() {
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
        invalidate();
    }

    @Override protected void onDraw(@NonNull Canvas canvas) {
        float viewWidth = getWidth();
        float viewHeight = getHeight();

        if ((int) viewWidth <= 0 || (int) viewHeight <= 0) {
            return;
        }

        // draw the image paint first, then draw a border as a Stroke paint (if needed)
        boolean hasBorder = borderWidth > 0;
        float center = viewWidth / 2;
        float imageRadius = center;

        if (hasBorder) {
            imageRadius -= borderWidth;
        }

        setupPaints();

        Paint paint = (sourceBitmap == null) ? placeholderPaint : imagePaint;
        canvas.drawCircle(center, center, imageRadius, paint);

        if (hasBorder) {
            canvas.drawCircle(center, center, center - (borderWidth / 2), borderPaint); // draw border
        }
    }

    private void setupPaints() {
        int strokeColor = (borderColor != -1) ? borderColor : bootstrapBrand.defaultEdge(getContext());
        int placeholderColor = getContext().getResources().getColor(R.color.bootstrap_gray_light);

        borderPaint.setColor(strokeColor);
        borderPaint.setAntiAlias(true);
        borderPaint.setStrokeWidth(borderWidth);
        borderPaint.setStyle(Paint.Style.STROKE);
        imagePaint.setAntiAlias(true);

        placeholderPaint.setColor(placeholderColor);
        placeholderPaint.setAntiAlias(true);
        placeholderPaint.setStyle(Paint.Style.FILL);
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

    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateImageState();
    }

    @Override public void setScaleType(ScaleType scaleType) {
        if (scaleType != CENTER_CROP) {
            throw new IllegalArgumentException("Only CenterCrop is currently supported by this view");
        }
        else {
            super.setScaleType(scaleType);
        }
    }

    @Override public ScaleType getScaleType() {
        return CENTER_CROP;
    }

    /**
     * @return the original Bitmap source that will be drawn as a circular image
     */
    @Nullable private Bitmap getBitmapForView() {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        else {
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();

            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawable.draw(new Canvas(bm));
            return bm;
        }
    }

    /*
     * Image setter overrides
     */

    @Override public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        onSourceBitmapUpdate(bm);
    }

    @Override public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        onSourceBitmapUpdate(getBitmapForView());
    }

    @Override public void setImageResource(int resId) {
        super.setImageResource(resId);
        onSourceBitmapUpdate(getBitmapForView());
    }

    @Override public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        onSourceBitmapUpdate(getBitmapForView());
    }

    private void onSourceBitmapUpdate(Bitmap bitmap) {
        sourceBitmap = bitmap;
        updateImageState();
    }

    /*
     * Getters/Setters
     */

    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        this.borderColor = -1;
        invalidate();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override @ColorInt public int getBorderColor() {
        return borderColor;
    }

    @Override public void setBorderColor(@ColorInt int borderColor) {
        this.borderColor = borderColor;
        invalidate();
    }

    @Override public float getBorderWidth() {
        return borderWidth;
    }

    @Override public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        updateImageState();
    }

}
