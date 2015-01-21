package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.utils.ImageUtils;

public class BootstrapCircleThumbnail extends FrameLayout
{

    private enum BootstrapCircleType {
        SMALL(  "small",    2,  48), //padding adjustment for small thumbnails
        MEDIUM( "medium",   4,  80),
        LARGE(  "large",    6,  112),
        XLARGE( "xlarge",   8,  176);

        private String type;
        private int padding;
        private int diameter;

        private BootstrapCircleType(String type, int padding, int diameter) {
            this.type = type;
            this.padding = padding;
            this.diameter = diameter;
        }

        public int getDiameter() { // dp
            return diameter;
        }

        public int getPadding() {
            return padding;
        }

        public static BootstrapCircleType getBootstrapCircleTypeFromString(String type) {
            for (BootstrapCircleType value : BootstrapCircleType.values()) {
                if (value.type.equals(type)) {
                    return value;
                }
            }
            return MEDIUM;
        }
    }

    private ImageView image;
    private boolean minimal = false;//minimal means display just the image, no padding
    private int imageWidth;
    private int imageHeight;
    private int padding = 0;
    private LinearLayout placeholder;
    private TextView dimensionsLabel;

    public BootstrapCircleThumbnail(Context context)
    {
        super(context);
        initialise(null);
    }

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise( AttributeSet attrs )
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.BootstrapCircleThumbnail);

        String size = "";
        String text = "";
        int imageDrawable = 0;

        try {
            if (a != null) {
                imageDrawable = a.getResourceId(R.styleable.BootstrapCircleThumbnail_bct_image, 0);

                text = a.getString(R.styleable.BootstrapCircleThumbnail_android_text);
                text = (text == null) ? "" : text;

                size = a.getString(R.styleable.BootstrapCircleThumbnail_bct_size);
                size = (size == null) ? "" : size;

                minimal = a.getBoolean(R.styleable.BootstrapCircleThumbnail_bct_minimal, false);
            }
        }
        finally {
            if (a != null) {
                a.recycle();
            }
        }

        View v = inflater.inflate(R.layout.bootstrap_thumbnail_circle, this, false);
        dimensionsLabel = (TextView) v.findViewById(R.id.dimensionsLabel);

        LinearLayout container = (LinearLayout) v.findViewById(R.id.container);
        placeholder = (LinearLayout) v.findViewById(R.id.placeholder);

        image = (ImageView) v.findViewById(R.id.image);
        float scale = getResources().getDisplayMetrics().density;

        //small image

        BootstrapCircleType type = BootstrapCircleType.getBootstrapCircleTypeFromString(size);

        padding = type.getPadding();
        imageWidth = type.getDiameter();
        imageHeight = type.getDiameter();

        //convert padding to pixels
        int paddingPX = (int)((padding * scale) + 0.5);

        //convert image size to pixels
        int imageSizeWidthPX = (int)((imageWidth * scale) + 0.5);
        int imageSizeHeightPX = (int)((imageHeight * scale) + 0.5);

        //make inner image smaller to compensate for the padding so that entire circle including padding equals the size
        //ex. small image = 48dp, small padding = 4dp, inner image = 48 - (4 * 2) = 40
        if(!this.minimal)
        {
            imageSizeWidthPX = imageSizeWidthPX - (paddingPX * 2);
            imageSizeHeightPX = imageSizeHeightPX - (paddingPX * 2);

            container.setPadding(paddingPX, paddingPX, paddingPX, paddingPX);
            container.setBackgroundResource(R.drawable.thumbnail_circle_container);
        }
        else
        {
            container.setBackgroundResource(R.drawable.thumbnail_circle_minimal);
        }

        //if no image is given
        if(imageDrawable == 0)
        {
            this.image.setVisibility(View.GONE);
            placeholder.setLayoutParams(new LinearLayout.LayoutParams(imageSizeWidthPX, imageSizeHeightPX));
            placeholder.setPadding(paddingPX, paddingPX, paddingPX, paddingPX);

            //set placeholder image
            placeholder.setBackgroundResource(R.drawable.thumbnail_circle);

            dimensionsLabel.setText(text);
        }
        else
        {
            placeholder.setPadding(0, 0, 0, 0);
            dimensionsLabel.setVisibility(View.GONE);
            Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), imageDrawable);

            Bitmap roundBitmap = ImageUtils.getCircleBitmap(bitmap, imageSizeWidthPX, imageSizeHeightPX);
            image.setImageBitmap(roundBitmap);
        }

        this.addView(v);
    }

    public void setImage(int drawable)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), drawable);
        setImage(bitmap);
    }
    
    public void setImage(Bitmap bitmap)
    {
        placeholder.setPadding(0, 0, 0, 0);
        this.dimensionsLabel.setVisibility(View.GONE);
        this.image.setVisibility(View.VISIBLE);

        float scale = getResources().getDisplayMetrics().density;
        
        //convert image size to pixels
        int widthPX = (int)((this.imageWidth * scale) + 0.5);
        int heightPX = (int)((this.imageHeight * scale) + 0.5);
        
        int paddingPX = (int)((this.padding * scale) + 0.5);
        
        if(!this.minimal)
        {
            widthPX = widthPX - (paddingPX * 2);
            heightPX = heightPX - (paddingPX * 2);
        }
        
        Bitmap roundBitmap = ImageUtils.getCircleBitmap(bitmap, widthPX, heightPX);
        image.setVisibility(View.VISIBLE);
        image.setImageBitmap(roundBitmap);

        requestLayout();
        invalidate();
    }

}
