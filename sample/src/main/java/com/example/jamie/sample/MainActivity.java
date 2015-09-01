package com.example.jamie.sample;

import android.app.Activity;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.FontAwesomeText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontAwesomeText fa = (FontAwesomeText) findViewById(R.id.fa_text);

        fa.setBootstrapText(new BootstrapText.Builder(this)
                                    .addFaIcon("fa-play")
                                    .addText(" in between ")
                                    .addFaIcon("fa-stop")
                                    .build());


    }


}
