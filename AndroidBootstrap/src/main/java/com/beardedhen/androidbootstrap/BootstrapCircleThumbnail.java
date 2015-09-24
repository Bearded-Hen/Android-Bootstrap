package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.PlaceholderTextView;

import java.io.Serializable;

// TODO document/finalise

public class BootstrapCircleThumbnail extends ImageView implements BootstrapBrandView, PlaceholderTextView {

    // TODO minimal should be changed for a borderRadius attribute
    // TODO implement BootstrapBrand
    // TODO implement sizing
    // TODO remove autoresizetextview

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapCircleThumbnail";
    private static final String KEY_BORDER_RADIUS = "com.beardedhen.androidbootstrap.BootstrapCircleThumbnail.KEY_BORDER_RADIUS";


    private BootstrapBrand bootstrapBrand;
    private CharSequence placeholderText;
    private float borderRadius;

    private final RectF imageRectF = new RectF();
    private Paint imagePaint;
    private Bitmap sourceBitmap;
    private BitmapShader imageShader;

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
        bundle.putCharSequence(PlaceholderTextView.KEY, placeholderText);
        bundle.putFloat(KEY_BORDER_RADIUS, borderRadius);

        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.placeholderText = bundle.getCharSequence(PlaceholderTextView.KEY);
            this.borderRadius = bundle.getFloat(KEY_BORDER_RADIUS);

            Serializable brand = bundle.getSerializable(BootstrapBrandView.KEY);

            if (brand instanceof BootstrapBrand) {
                this.bootstrapBrand = (BootstrapBrand) brand;
            }
            state = bundle.getParcelable(TAG);
        }
        super.onRestoreInstanceState(state);
        updateBootstrapState();
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapCircleThumbnail);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapCircleThumbnail_bootstrapBrand, -1);
            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);

            this.placeholderText = a.getString(R.styleable.BootstrapCircleThumbnail_placeholderText);
            this.borderRadius = a.getDimension(R.styleable.BootstrapCircleThumbnail_borderRadius, 0);
        }
        finally {
            a.recycle();
        }

        updateBootstrapState();

//        float scale = getResources().getDisplayMetrics().density;

        //small image

//        BootstrapCircleType type = BootstrapCircleType.getBootstrapCircleTypeFromString(size);

//        padding = type.getPadding();
//        imageWidth = type.getDiameter();
//        imageHeight = type.getDiameter();

        //convert padding to pixels
//        int paddingPX = (int) ((padding * scale) + 0.5);
//
//        //convert image size to pixels
//        int imageSizeWidthPX = (int) ((imageWidth * scale) + 0.5);
//        int imageSizeHeightPX = (int) ((imageHeight * scale) + 0.5);

//        //make inner image smaller to compensate for the padding so that entire circle including padding equals the size
//        //ex. small image = 48dp, small padding = 4dp, inner image = 48 - (4 * 2) = 40
//        if (!this.minimal) {
//            imageSizeWidthPX -= (paddingPX * 2);
//            imageSizeHeightPX -= (paddingPX * 2);
//
//            container.setPadding(paddingPX, paddingPX, paddingPX, paddingPX);
//            container.setBackgroundResource(R.drawable.thumbnail_circle_container);
//        }
//        else {
//            container.setBackgroundResource(R.drawable.thumbnail_circle_minimal);
//        }
//
//        //if no image is given
//        if (imageDrawable == 0) {
//            this.image.setVisibility(View.GONE);
//            placeholder.setLayoutParams(new LinearLayout.LayoutParams(imageSizeWidthPX, imageSizeHeightPX));
//            placeholder.setPadding(paddingPX, paddingPX, paddingPX, paddingPX);
//
//            //set placeholder image
//            placeholder.setBackgroundResource(R.drawable.thumbnail_circle);
//
//            dimensionsLabel.setText(text);
//        }
//        else {
//            placeholder.setPadding(0, 0, 0, 0);
//            dimensionsLabel.setVisibility(View.GONE);
//            Bitmap image = BitmapFactory.decodeResource(getContext().getResources(), imageDrawable);
//
//            Bitmap roundBitmap = ImageUtils.getCircleBitmap(image, imageSizeWidthPX, imageSizeHeightPX);
//            image.setImageBitmap(roundBitmap);
//        }
    }

    private void updateBootstrapState() {
        // TODO update state

    }

    @Override public void setScaleType(ScaleType scaleType) {
        if (scaleType != ScaleType.CENTER_CROP) {
            throw new IllegalArgumentException("Only CenterCrop is currently supported by this view");
        }
        else {
            super.setScaleType(scaleType);
        }
    }

    @Override public ScaleType getScaleType() {
        return ScaleType.CENTER_CROP;
    }

    /**
     * @return the image source that should be transformed into a circle bitmap
     */
    @Nullable private Bitmap getBitmapForView() {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        else {
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();

            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawable.draw(new Canvas(bm));
            return bm;
        }
    }

    @Override protected void onDraw(@NonNull Canvas canvas) {
        // Draw the circle image using a Paint with a BitmapShader, avoiding duplicate Bitmaps
        // See http://www.curious-creature.com/2012/12/11/android-recipe-1-image-with-rounded-corners/

        if (imagePaint == null) {
            imagePaint = new Paint();
            imagePaint.setAntiAlias(true);
        }

        if (sourceBitmap != null) {
            imageShader = new BitmapShader(sourceBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            imagePaint.setShader(imageShader);

            float w = getWidth();
            float h = getHeight();

            imageRectF.set(0, 0, w, h);
            canvas.drawCircle(w / 2, h / 2, w / 2, imagePaint);
        }
        else {
            // TODO draw placeholder
        }
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        if (w > h) {
            w = h;
        }
        if (h > w) {
            h = w;
        }
        setMeasuredDimension(w, h);
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
        requestLayout();
        updateBootstrapState();
    }


    /*
     * Getters/Setters
     */


    @Override public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull @Override public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override public void setPlaceholderText(CharSequence text) {
        this.placeholderText = text;
        updateBootstrapState();
    }

    @NonNull @Override public CharSequence getPlaceholderText() {
        return placeholderText;
    }

}
