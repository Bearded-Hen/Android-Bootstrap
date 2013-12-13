package com.beardedhen.androidbootstrap;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BootstrapThumbnail extends FrameLayout
{
	private static final int DEFAULT_WIDTH = 150; //width of thumbnail when no width is given
	private static final int DEFAULT_HEIGHT = 150;//height of thumbnail when no height is given
	private static final int DEFAULT_MAX_PADDING = 8; //8dp is max padding size when padding isn't specified by user
	private static final int DEFAULT_MIN_PADDING = 4; //4dp
	private static final String DEFAULT_TYPE = "rounded";
	
	private static Map<String, ThumbnailTypes> bThumbnailTypeMap;
	private static Typeface font;
	private ViewGroup container;
	private LinearLayout placeholder;
	private TextView dimensionsLabel;
	private boolean roundedCorners = true;
	
	static{	
		bThumbnailTypeMap = new HashMap<String, ThumbnailTypes>();
		
		bThumbnailTypeMap.put("rounded", ThumbnailTypes.ROUNDED);//default is rounded if user doesn't specify to use square
		bThumbnailTypeMap.put("square", ThumbnailTypes.SQUARE);
	}
	
	public BootstrapThumbnail(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
		initialise(attrs);
	}
	
	public BootstrapThumbnail(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		initialise(attrs);
	}
	
	public BootstrapThumbnail(Context context) 
	{
		super(context);
		initialise(null);
	}
	
	public void setImage(int drawable)
	{
		this.placeholder.setBackgroundResource(drawable);
        invalidate();
        requestLayout();
	}
	
	//set up the bootstrap types
	private enum ThumbnailTypes
	{		
		ROUNDED(R.drawable.bthumbnail_container_rounded, R.drawable.bthumbnail_placeholder_default),
		SQUARE(R.drawable.bthumbnail_container_square, R.drawable.bthumbnail_placeholder_default);
		
		private int containerDrawable;
		private int placeholderDrawable;

		ThumbnailTypes(int containerDrawable, int placeholderDrawable)
		{
			this.containerDrawable = containerDrawable;
			this.placeholderDrawable = placeholderDrawable;
		}
	}
	
	private void initialise( AttributeSet attrs )
	{
		LayoutInflater inflator = (LayoutInflater)getContext().getSystemService(
			    Context.LAYOUT_INFLATER_SERVICE);
		
		readFont(getContext());

		TypedArray a = getContext().obtainStyledAttributes(attrs,
			    R.styleable.BootstrapThumbnail);
		
		//defaults
		ThumbnailTypes type = null;
		String thumbnailType = DEFAULT_TYPE;
		String text = "";
		int imageDrawable = 0;
		float scale = getResources().getDisplayMetrics().density; //for padding
		int width = DEFAULT_WIDTH;
		int height = DEFAULT_HEIGHT;	
		int padding = 0;
		int paddingDP = 0;

		//attribute values	
		if(a.getString(R.styleable.BootstrapThumbnail_bt_width) != null) {
			width = (int) a.getDimension(R.styleable.BootstrapThumbnail_bt_width, 0);
			Log.v("width", Integer.toString(width));
		}
		
		if(a.getString(R.styleable.BootstrapThumbnail_bt_height) != null) {
			height = (int) a.getDimension(R.styleable.BootstrapThumbnail_bt_height, 0);
		}
		
		if(a.getString(R.styleable.BootstrapThumbnail_bt_inside_padding) != null) {
			paddingDP = (int) a.getDimension(R.styleable.BootstrapThumbnail_bt_inside_padding, 0);
		}
		else{
			padding = (int) (((Math.sqrt(width * height)) / 100) * 2);
			if(padding > DEFAULT_MAX_PADDING)
				padding = DEFAULT_MAX_PADDING;
			if(padding < DEFAULT_MIN_PADDING)
				padding = DEFAULT_MIN_PADDING;
			
			paddingDP = (int) (padding * scale + 0.5f);//container padding in DP
		}
		
		if(a.getString(R.styleable.BootstrapThumbnail_bt_roundedCorners) != null){
			roundedCorners = a.getBoolean(R.styleable.BootstrapThumbnail_bt_roundedCorners, false) ;
		}
		
		if(a.getString(R.styleable.BootstrapThumbnail_bt_image) != null){
			imageDrawable = a.getResourceId(R.styleable.BootstrapThumbnail_bt_image, 0);
		}
	
		a.recycle();
		
		text = (int)(width/scale) + "x" + (int)(height/scale);
		View v = inflator.inflate(R.layout.bootstrap_thumbnail, null, false);
	
		//get layout items
		container = (ViewGroup) v.findViewById(R.id.container);
		placeholder = (LinearLayout) v.findViewById(R.id.placeholder);
		dimensionsLabel = (TextView) v.findViewById(R.id.dimensionsLabel);
		
		Log.v("size", "width:" + width + " height:" + height);
		
		
		type = bThumbnailTypeMap.get(thumbnailType);

		//get the correct background type
		if(roundedCorners == true)
		{
			type = bThumbnailTypeMap.get("rounded");
		} else {
			type = bThumbnailTypeMap.get("square");
		}
		
		//apply the background type
		container.setBackgroundResource(type.containerDrawable);
		
		//if no image is provided by user
		if(imageDrawable == 0){
			//set default grey placeholder background
			placeholder.setBackgroundResource(type.placeholderDrawable);
			
			//set the text 
	        if(text.length() > 0){        	
	        	dimensionsLabel.setText(text);
	        	dimensionsLabel.setVisibility(View.VISIBLE);        	
	        }
		}
		else{		
			//set background to user's provided image
			placeholder.setBackgroundResource(imageDrawable);
			
			//remove textview dimensions
			dimensionsLabel.setVisibility(View.GONE);
		}
			
		//placeholder padding
		int paddingP = (int) (((Math.sqrt(width * height)) / 100) * 4);

		//convert to DP	    
	    int paddingDPP = (int) (paddingP * scale + 0.5f);//placeholder padding in DP

		container.setPadding(paddingDP, paddingDP, paddingDP, paddingDP);
		placeholder.setPadding(paddingDPP, paddingDPP, paddingDPP, paddingDPP);
		
		placeholder.setLayoutParams(new LinearLayout.LayoutParams(width,height));
		
		//set the font awesome icon typeface
		dimensionsLabel.setTypeface(font);

        this.setClickable(true);
                
		addView(v);
	}
	
	//static class to read in font
	private static void readFont(Context context)
	{		
		if(font == null){	
			try {
			font = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
			} catch (Exception e) {
                Log.e("BootstrapButton", "Could not get typeface because " + e.getMessage());
                font = Typeface.DEFAULT;
            }
		}

	}
}
