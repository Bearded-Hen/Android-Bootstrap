package com.example.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingPageActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.example_bootstrap_button) void onBootstrapButtonExampleClicked() {
        startActivity(new Intent(this, BootstrapButtonExample.class));
    }

    @OnClick(R.id.example_fontawesometext) void onFontAwesomeTextExampleClicked() {
        startActivity(new Intent(this, FontAwesomeTextExample.class));
    }

    @OnClick(R.id.example_bootstrap_label) void onBootstrapLabelExampleClicked() {
        startActivity(new Intent(this, BootstrapLabelExample.class));
    }

    @OnClick(R.id.example_bootstrap_progress) void onBootstrapProgressExampleClicked() {
        startActivity(new Intent(this, BootstrapProgressExample.class));
    }

}