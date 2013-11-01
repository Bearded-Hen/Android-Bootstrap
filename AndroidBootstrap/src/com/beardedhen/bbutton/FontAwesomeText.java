package com.beardedhen.bbutton;

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
import android.widget.FrameLayout;
import android.widget.TextView;

public class FontAwesomeText extends FrameLayout {

	private static Typeface font;
	private static Map<String, String> faMap;
	
	static{
		faMap = FontAwesome.getFaMap();
	}
	
	public FontAwesomeText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialise(attrs);
	}

	public FontAwesomeText(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialise(attrs);
	}

	public FontAwesomeText(Context context) {
		super(context);
		initialise(null);
	}


	
	
	private void initialise( AttributeSet attrs )
	{
		LayoutInflater inflator = (LayoutInflater)getContext().getSystemService(
			    Context.LAYOUT_INFLATER_SERVICE);

		//get font
		readFont(getContext());

		TypedArray a = getContext().obtainStyledAttributes(attrs,  R.styleable.FontAwesomeText);

		//inflate the view
		View v = inflator.inflate(R.layout.font_awesome_text, null, false);
		TextView tv = (TextView)v.findViewById(R.id.lblText);
		
		String icon = "";
		float fontSize = 14.0f;
		
		//icon
		if (a.getString(R.styleable.FontAwesomeText_icon) != null) {
			icon = faMap.get( a.getString(R.styleable.FontAwesomeText_icon) );
		}
		
		//font size
		if (a.getString(R.styleable.FontAwesomeText_android_textSize) != null) {

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
		
		//text colour
		if(a.getString(R.styleable.FontAwesomeText_android_textColor) != null){
			tv.setTextColor(a.getColor(R.styleable.FontAwesomeText_android_textColor, R.color.bbutton_inverse));
		}
		
		tv.setText(icon);
		tv.setTypeface(font);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
		
		a.recycle();
		addView(v);
	}

	private static void readFont(Context context)
	{
		
		if(font == null){	
			try {
			font = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
			} catch (Exception e) {
                Log.e("BButton", "Could not get typeface because " + e.getMessage());
                font = Typeface.DEFAULT;
            }
		}

	}
	
}
