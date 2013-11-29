package com.beardedhen.androidbootstrap;

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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.R;

public class FontAwesomeText extends FrameLayout {

	private static Typeface font;
	private static Map<String, String> faMap;

	private TextView tv;
	
	private static final String FA_ICON_QUESTION = "fa-question";
	
	public enum AnimationSpeed
	{
		FAST,
		MEDIUM, 
		SLOW;
	}
	
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
		View fontAwesomeTextView = inflator.inflate(R.layout.font_awesome_text, null, false);
		tv = (TextView)fontAwesomeTextView.findViewById(R.id.lblText);
		
		String icon = "";
		float fontSize = 14.0f;
		
		//icon
		if (a.getString(R.styleable.FontAwesomeText_fa_icon) != null) {
			icon = a.getString(R.styleable.FontAwesomeText_fa_icon);
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
		
		setIcon(icon);
		
		tv.setTypeface(font);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
		
		a.recycle();
		addView(fontAwesomeTextView);
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
	
	
	/**
	 * Used to start flashing a FontAwesomeText item
	 * @param context the current applications context
	 * @param forever whether the item should flash repeatedly or just once
	 * @param speed how fast the item should flash, chose between FontAwesomeText.AnimationSpeed.SLOW / 
	 * FontAwesomeText.AnimationSpeed.MEDIUM / FontAwesomeText.AnimationSpeed.FAST 
	 */
	public void startFlashing(Context context, boolean forever, AnimationSpeed speed)
	{

		Animation fadeIn = new AlphaAnimation(0, 1);
	    
		//set up extra variables
		fadeIn.setDuration(50);
	    fadeIn.setRepeatMode(Animation.REVERSE);
	    
	    //default repeat count is 0, however if user wants, set it up to be infinite
	    fadeIn.setRepeatCount(0);
	    if (forever){
	    	fadeIn.setRepeatCount(Animation.INFINITE);
	    }
	    
	    //default speed
	    fadeIn.setStartOffset(1000);
	    
	    //fast
	    if (speed.equals(AnimationSpeed.FAST))
	    {
	    	fadeIn.setStartOffset(200);
	    }
	    
	    //medium
	    if (speed.equals(AnimationSpeed.MEDIUM))
	    {
	    	fadeIn.setStartOffset(500);
	    }

	    //set the new animation to a final animation
	    final Animation animation = fadeIn;
		
	  //run the animation - used to work correctly on older devices
		tv.postDelayed(new Runnable() {
			@Override
			public void run() {
				tv.startAnimation(animation);
			}
		}, 100);
	}
	
	
	/**
	 * Used to start rotating a FontAwesomeText item
	 * @param context the current applications context
	 * @param clockwise true for clockwise, false for anti clockwise spinning
	 * @param speed how fast the item should flash, chose between FontAwesomeText.AnimationSpeed.SLOW / 
	 * FontAwesomeText.AnimationSpeed.MEDIUM / FontAwesomeText.AnimationSpeed.FAST 
	 */
	public void startRotate(Context context, boolean clockwise, AnimationSpeed speed)
	{
		Animation rotate;
		
		//set up the rotation animation
		if (clockwise){
			rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
		} else {
			rotate = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
		}
		
		//set up some extra variables
		rotate.setRepeatCount(Animation.INFINITE);
		rotate.setInterpolator(new LinearInterpolator());
		rotate.setStartOffset(0);
		rotate.setRepeatMode(Animation.RESTART);
		
		//defaults
		rotate.setDuration(2000);
		
		//fast
	    if (speed.equals(AnimationSpeed.FAST))
	    {
	    	rotate.setDuration(500);
	    }
	    
	    //medium
	    if (speed.equals(AnimationSpeed.MEDIUM))
	    {
	    	rotate.setDuration(1000);
	    }
		
	    //send the new animation to a final animation
		final Animation animation = rotate;
		
		//run the animation - used to work correctly on older devices
		tv.postDelayed(new Runnable() {
			@Override
			public void run() {
				tv.startAnimation(animation);
			}
		}, 100);

	}
	
	
	/**
	 * Used to stop animating any FontAwesomeText item
	 */
	public void stopAnimation(){
		//stop the animation
		tv.clearAnimation();
	}
	
	
	/**
	 * Used to set the icon for a FontAwesomeText item
	 * @param faIcon - String value for the icon as per http://fortawesome.github.io/Font-Awesome/cheatsheet/
	 */
	public void setIcon(String faIcon) {
		
		String icon = faMap.get(faIcon);
		
		if (icon == null)
		{
			icon = faMap.get(FA_ICON_QUESTION);
		}
		
		tv.setText(icon);
	}
	
	/**
	 * Used to set the text color of the underlying text view.
	 * @param color - Integer value representing a color resource.
	 */
	public void setTextColor(int color) {
		tv.setTextColor(color);
	}
	
}
