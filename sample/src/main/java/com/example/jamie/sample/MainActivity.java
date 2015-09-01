package com.example.jamie.sample;

import android.app.Activity;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.FontAwesomeText;
import com.beardedhen.androidbootstrap.enums.BootstrapContext;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontAwesomeText fa = (FontAwesomeText) findViewById(R.id.fa_text);
        BootstrapButton bb = (BootstrapButton) findViewById(R.id.bb_button);

        fa.setBootstrapText(new BootstrapText.Builder(this)
                                    .addFaIcon("fa-play")
                                    .addText(" in between ")
                                    .addFaIcon("fa-stop")
                                    .build());

        bb.setBootstrapText(new BootstrapText.Builder(this)
                                    .addFaIcon("fa-play")
                                    .addText(" in between ")
                                    .addFaIcon("fa-stop")
                                    .build());

        bb.setBootstrapClass(BootstrapContext.PRIMARY);




    }


}
