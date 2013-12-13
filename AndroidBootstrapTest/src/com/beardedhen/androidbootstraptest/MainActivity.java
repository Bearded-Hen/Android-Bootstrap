package com.beardedhen.androidbootstraptest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.FontAwesomeText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get access to some FontAwesomeText items in the layout
		final FontAwesomeText tv1 = (FontAwesomeText) findViewById(R.id.lblOne);
		FontAwesomeText tv2 = (FontAwesomeText) findViewById(R.id.lblTwo);
		FontAwesomeText tv3 = (FontAwesomeText) findViewById(R.id.lblThree);
		
		//flashing forever FAST
		tv1.startFlashing(this, true, FontAwesomeText.AnimationSpeed.FAST);
		
		//rotating clockwise slowly
		tv2.startRotate(this, true, FontAwesomeText.AnimationSpeed.SLOW);
		
		//rotating anti-clockwise at medium speed
		tv3.startRotate(this, false, FontAwesomeText.AnimationSpeed.MEDIUM);
		
		final BootstrapEditText txtOne = (BootstrapEditText)findViewById(R.id.txtOne);
		
		txtOne.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	//not needed
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){
	        	//not needed
	        }
	        public void onTextChanged(CharSequence s, int start, int before, int count){
	        	//not needed
	        	Log.d("BButton", s.toString());
	        	if(s.toString().length() > 4)
	        	{
	        		txtOne.setSuccess();
	        	}
	        }
	    }); 
		
		
		final BootstrapButton button1 = (BootstrapButton)findViewById(R.id.btnOne);
		final BootstrapButton button2 = (BootstrapButton)findViewById(R.id.btnTwo);
		final BootstrapButton button3 = (BootstrapButton)findViewById(R.id.btnThree);
		final BootstrapButton buttonBig = (BootstrapButton)findViewById(R.id.btnBig);
		
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("BButton", "pressed button 1");
				//change button 1's text, left icon, and type
				button1.setText("hello");
				button1.setLeftIcon("fa-star");
				button1.setBootstrapType("success");
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("BButton", "pressed button 2");	
				//disable the button
				button2.setBootstrapButtonEnabled(false);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("BButton", "pressed button 3");	
				//change the first FontAwesomeText to a star
				tv1.setIcon("fa-star");
			}
		});
		
		buttonBig.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("BButton", "pressed button big");	
				buttonBig.setTextGravity("center");
			}
		});
		
		
		
	}

}
