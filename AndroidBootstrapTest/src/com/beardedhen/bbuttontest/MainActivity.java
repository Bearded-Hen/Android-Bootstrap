package com.beardedhen.bbuttontest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.beardedhen.bbutton.BootstrapButton;
import com.beardedhen.bbutton.FontAwesomeText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get access to some FontAwesomeText items in the layout
		FontAwesomeText tv1 = (FontAwesomeText) findViewById(R.id.lblOne);
		FontAwesomeText tv2 = (FontAwesomeText) findViewById(R.id.lblTwo);
		FontAwesomeText tv3 = (FontAwesomeText) findViewById(R.id.lblThree);
		
		//flashing forever FAST
		tv1.startFlashing(this, true, FontAwesomeText.AnimationSpeed.FAST);
		
		//rotating clockwise slowly
		tv2.startRotate(this, true, FontAwesomeText.AnimationSpeed.SLOW);
		
		//rotating anti-clockwise at medium speed
		tv3.startRotate(this, false, FontAwesomeText.AnimationSpeed.MEDIUM);
		
		BootstrapButton button = (BootstrapButton)findViewById(R.id.btnOne);
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("BButton", "pressed button");	
			}
		});
		
	}

}
