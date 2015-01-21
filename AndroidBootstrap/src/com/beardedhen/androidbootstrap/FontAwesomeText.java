package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FontAwesomeText extends FrameLayout {

	private TextView tv;
	
	public enum AnimationSpeed
	{
		FAST    (500,   200),
		MEDIUM  (1000,  500),
		SLOW    (2000,  1000);

        private long rotateDuration;
        private long flashDuration;

        private AnimationSpeed(long rotateDuration, long flashDuration) {
            this.rotateDuration = rotateDuration;
            this.flashDuration = flashDuration;
        }

        public long getRotateDuration() {
            return rotateDuration;
        }

        public long getFlashDuration() {
            return flashDuration;
        }
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
	
	private void initialise(AttributeSet attrs)
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());

        View fontAwesomeTextView = inflater.inflate(R.layout.font_awesome_text, this, false);
        tv = (TextView) fontAwesomeTextView.findViewById(R.id.lblText);

        float fontSize = FontAwesome.DEFAULT_FONT_SIZE;
        String icon = "";

        TypedArray a = getContext().obtainStyledAttributes(attrs,  R.styleable.FontAwesomeText);

        try {
            if (a != null) {
                // icon
                icon = a.getString(R.styleable.FontAwesomeText_fa_icon);
                icon = (icon == null) ? "" : icon;

                //font size
                if (a.getString(R.styleable.FontAwesomeText_android_textSize) != null) {
                    float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
                    float defaultDimen = FontAwesome.DEFAULT_FONT_SIZE * scaledDensity;

                    float rawSize = a.getDimension(R.styleable.FontAwesomeText_android_textSize, defaultDimen);
                    fontSize = rawSize / scaledDensity;
                }

                //text colour
                if (a.getString(R.styleable.FontAwesomeText_android_textColor) != null) {
                    tv.setTextColor(a.getColor(R.styleable.FontAwesomeText_android_textColor, R.color.bbutton_inverse));
                }
            }
        }
        finally {
            if (a != null) {
                a.recycle();
            }
        }

        setIcon(icon);
        tv.setTypeface(FontAwesome.getFont(getContext()));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);

        addView(fontAwesomeTextView);
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

        fadeIn.setStartOffset(speed.getFlashDuration());

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
		rotate.setDuration(speed.getRotateDuration());
		
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
		tv.setText(FontAwesome.getUnicode(faIcon));
	}
	
	/**
	 * Used to set the text color of the underlying text view.
	 * @param color - Integer value representing a color resource.
	 */
	public void setTextColor(int color) {
		tv.setTextColor(color);
	}

	/**
	 * Used to set the text size of the underlying text view.
	 * @param unit - Integer value representing a unit size
	 * @param size - Float value representing text size
	 */
	public void setTextSize(int unit, float size) {
		tv.setTextSize(unit, size);
	}
	
}
