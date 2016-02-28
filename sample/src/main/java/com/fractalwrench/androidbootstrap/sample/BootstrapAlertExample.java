package com.fractalwrench.androidbootstrap.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beardedhen.androidbootstrap.BootstrapAlert;

public class BootstrapAlertExample extends Activity {

    private BootstrapAlert alert;
    private Button interactiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_bootstrap_alert);
        alert = (BootstrapAlert) findViewById(R.id.dynamic_alert);
        interactiveButton = (Button) findViewById(R.id.interactive_button);
        interactiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alert.isHidden()) {
                    alert.show();
                } else {
                    alert.hide();
                }
            }
        });
    }
}
