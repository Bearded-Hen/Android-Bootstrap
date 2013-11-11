package com.beardedhen.bbutton;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BootstrapButton extends FrameLayout {

	private static Map<String, BootstrapTypes> bbuttonTypeMap;
	private static Map<String, BootstrapTypes> bbuttonTypeMapRounded;
	private static Typeface font;
	
	private static Map<String, String> faMap;
	
	static{
		
		bbuttonTypeMap = new HashMap<String, BootstrapTypes>();
		
		bbuttonTypeMap.put("default", BootstrapTypes.DEFAULT);
		bbuttonTypeMap.put("primary", BootstrapTypes.PRIMARY);
		bbuttonTypeMap.put("success", BootstrapTypes.SUCCESS);
		bbuttonTypeMap.put("info", BootstrapTypes.INFO);
		bbuttonTypeMap.put("warning", BootstrapTypes.WARNING);
		bbuttonTypeMap.put("danger", BootstrapTypes.DANGER);
		bbuttonTypeMap.put("inverse", BootstrapTypes.INVERSE);
		
		bbuttonTypeMapRounded = new HashMap<String, BootstrapTypes>();
		
		bbuttonTypeMapRounded.put("default", BootstrapTypes.DEFAULT_ROUNDED);
		bbuttonTypeMapRounded.put("primary", BootstrapTypes.PRIMARY_ROUNDED);
		bbuttonTypeMapRounded.put("success", BootstrapTypes.SUCCESS_ROUNDED);
		bbuttonTypeMapRounded.put("info", BootstrapTypes.INFO_ROUNDED);
		bbuttonTypeMapRounded.put("warning", BootstrapTypes.WARNING_ROUNDED);
		bbuttonTypeMapRounded.put("danger", BootstrapTypes.DANGER_ROUNDED);
		bbuttonTypeMapRounded.put("inverse", BootstrapTypes.INVERSE_ROUNDED);
		
		
		faMap = FontAwesome.getFaMap();
		
	}
	
	public BootstrapButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialise(attrs);
	}

	public BootstrapButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialise(attrs);
	}

	public BootstrapButton(Context context) {
		super(context);
		initialise(null);
	}

	//set up the bootstrap types
	private enum BootstrapTypes
	{
		DEFAULT(R.drawable.bbuton_default, R.color.black),
		PRIMARY(R.drawable.bbuton_primary, R.color.white),
		SUCCESS(R.drawable.bbuton_success, R.color.white),
		INFO(R.drawable.bbuton_info, R.color.white),
		WARNING(R.drawable.bbuton_warning, R.color.white),
		DANGER(R.drawable.bbuton_danger, R.color.white),
		INVERSE(R.drawable.bbuton_inverse, R.color.white),
		
		DEFAULT_ROUNDED(R.drawable.bbuton_default_rounded, R.color.black),
		PRIMARY_ROUNDED(R.drawable.bbuton_primary_rounded, R.color.white),
		SUCCESS_ROUNDED(R.drawable.bbuton_success_rounded, R.color.white),
		INFO_ROUNDED(R.drawable.bbuton_info_rounded, R.color.white),
		WARNING_ROUNDED(R.drawable.bbuton_warning_rounded, R.color.white),
		DANGER_ROUNDED(R.drawable.bbuton_danger_rounded, R.color.white),
		INVERSE_ROUNDED(R.drawable.bbuton_inverse_rounded, R.color.white);

		private int backgroundDrawable;
		private int textColour;
		
		BootstrapTypes(int backgroundDrawable, int textColour)
		{
			this.backgroundDrawable = backgroundDrawable;
			this.textColour = textColour;
		}
	}
	
	
	private void initialise( AttributeSet attrs )
	{
		LayoutInflater inflator = (LayoutInflater)getContext().getSystemService(
			    Context.LAYOUT_INFLATER_SERVICE);

		//get font
		readFont(getContext());

		TypedArray a = getContext().obtainStyledAttributes(attrs,
			    R.styleable.BootstrapButton);
		
		//defaults
		BootstrapTypes type = null;
		String bootstrapType = "default";
		String iconLeft = "";
		String iconRight = "";
		String text = "";
		boolean roundedCorners = false;
		float fontSize = 14.0f;
		float scale = getResources().getDisplayMetrics().density; //for padding
		String size = "default";
		int paddingA = (int) (10 *scale + 0.5f);
		int paddingB = (int) (15 *scale + 0.5f);
		
		
		
		//attribute values
		
		if (a.getString(R.styleable.BootstrapButton_type) != null) {
			bootstrapType = a.getString(R.styleable.BootstrapButton_type);
		}
		
		if (a.getString(R.styleable.BootstrapButton_roundedCorners) != null) {
			roundedCorners = a.getBoolean(R.styleable.BootstrapButton_roundedCorners, false) ;
		}
		
		if(a.getString(R.styleable.BootstrapButton_size) != null) {
			size = a.getString(R.styleable.BootstrapButton_size);
		}
		
		if ( a.getString(R.styleable.BootstrapButton_icon_left) != null) {
			iconLeft = faMap.get( a.getString(R.styleable.BootstrapButton_icon_left) );
		}
		
		if(a.getString(R.styleable.BootstrapButton_icon_right) != null) {
			iconRight = faMap.get( a.getString(R.styleable.BootstrapButton_icon_right) );
		}
		
		if(a.getString(R.styleable.BootstrapButton_android_text) != null) {
			text = a.getString(R.styleable.BootstrapButton_android_text);
		}
		
		boolean enabled = true;
		if(a.getString(R.styleable.BootstrapButton_android_enabled) != null) {
			enabled = a.getBoolean(R.styleable.BootstrapButton_android_enabled, true);
		}
		
		if(a.getString(R.styleable.BootstrapButton_android_textSize) != null) {
			
			//font sizes
			String xmlProvidedSize = attrs.getAttributeValue(
					"http://schemas.android.com/apk/res/android", "textSize");
			final Pattern PATTERN_FONT_SIZE = Pattern
					.compile("([0-9]+[.]?[0-9]*)sp");
			Matcher m = PATTERN_FONT_SIZE.matcher(xmlProvidedSize);

			if (m.find()) {

				if (m.groupCount() == 1) {

					fontSize = Float.valueOf(m.group(1));
				}

			}

		}
		
		a.recycle();
		
		
		View v = inflator.inflate(R.layout.bootstrap_button, null, false);
		
		//set up font sizes and padding for different button sizes
		if(size.equals("large")){
			fontSize = 20.0f;
			paddingA = (int) (15 *scale + 0.5f);;
			paddingB = (int) (20 *scale + 0.5f);;
		}
		
		if(size.equals("small")){
			fontSize = 12.0f;
			paddingA = (int) (5 *scale + 0.5f);;
			paddingB = (int) (10 *scale + 0.5f);;
		}
		
		if(size.equals("xsmall")){
			fontSize = 10.0f;
			paddingA = (int) (2 *scale + 0.5f);;
			paddingB = (int) (5 *scale + 0.5f);;
		}
	
		//get layout items
		ViewGroup layout = (ViewGroup) v.findViewById(R.id.layout);
		TextView lblLeft = (TextView) v.findViewById(R.id.lblLeft);
		TextView lblMiddle = (TextView) v.findViewById(R.id.lblMiddle);
		TextView lblRight = (TextView) v.findViewById(R.id.lblRight);

		//get the correct background type
		if(roundedCorners == true)
		{
			type = bbuttonTypeMapRounded.get(bootstrapType);
		} else {
			type = bbuttonTypeMap.get(bootstrapType);
		}
		
		//set up as default
		if (type == null)
		{
			type = BootstrapTypes.DEFAULT;
		}
	
		//apply the background type
		layout.setBackgroundResource(type.backgroundDrawable);
		lblLeft.setTextColor(getResources().getColor(type.textColour));
		lblMiddle.setTextColor(getResources().getColor(type.textColour));
		lblRight.setTextColor(getResources().getColor(type.textColour));
		
		//set the font awesome icon typeface
		lblLeft.setTypeface(font);
		lblRight.setTypeface(font);
		
		//set up the font size
		lblLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        lblRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
		
        boolean onlyIcon = true;
        
        //set the text 
        if(text.length() > 0){
        	lblMiddle.setText(text );
        	lblMiddle.setVisibility(View.VISIBLE);
        	onlyIcon = false;
        }

        //set up the padding
        
        if (iconLeft.length() > 0) {
        	lblLeft.setText(iconLeft);
        	lblLeft.setVisibility(View.VISIBLE);
        	
        	if (onlyIcon == false){
        		lblLeft.setPadding(paddingB, 0, 0, 0);
        	} else {
        		lblLeft.setPadding(paddingB, 0, paddingB, 0);
        	}
        	
        	//padding for symmetry
        	if ( ( iconRight.length() == 0) && onlyIcon == false ) {
        		lblMiddle.setPadding(paddingA, 0, (int) paddingB, 0);
        	}
        	
        }
         
        if (iconRight.length() > 0) {
        	lblRight.setText(iconRight);
        	lblRight.setVisibility(View.VISIBLE);
        	
        	if (onlyIcon == false){
        		lblRight.setPadding(0, 0, paddingB, 0);
        	}else {
        		lblRight.setPadding(paddingB, 0, paddingB, 0);
        	}

        	//padding for symmetry
        	if ( (iconLeft.length() == 0) && onlyIcon == false ) {
        		lblMiddle.setPadding(paddingB, 0, (int) paddingA, 0);
        	}
        }
        
        if(iconLeft.length() > 0 && iconRight.length() > 0 )
        {
        	lblMiddle.setPadding(paddingA, 0, paddingA, 0);
        }
        
        layout.setEnabled(enabled);

        layout.setPadding(0, paddingB, 0, paddingB);
        
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
