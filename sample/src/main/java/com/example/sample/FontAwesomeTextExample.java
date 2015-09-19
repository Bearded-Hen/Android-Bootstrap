package com.example.sample;

import android.os.Bundle;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.support.BootstrapText;

import butterknife.Bind;
import butterknife.OnClick;

public class FontAwesomeTextExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_fa_text;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFontAwesomeText();
    }


    /**
     * FontAwesomeText example code
     */


    @Bind(R.id.example_fa_text_change) AwesomeTextView exampleChange;
    @Bind(R.id.example_fa_text_flash) AwesomeTextView exampleFlash;
    @Bind(R.id.example_fa_text_rotate) AwesomeTextView exampleRotate;
    @Bind(R.id.example_fa_text_multi_change) AwesomeTextView exampleMultiChange;
    @Bind(R.id.example_fa_text_builder) AwesomeTextView exampleBuilder;

    private boolean android = true;
    private boolean wikipedia = true;

    private void setupFontAwesomeText() {
        exampleFlash.startFlashing(true, AwesomeTextView.AnimationSpeed.FAST);
        exampleRotate.startRotate(true, AwesomeTextView.AnimationSpeed.SLOW);

        BootstrapText text = new BootstrapText.Builder(this)
                .addText("I ")
                .addFaIcon("fa-heart")
                .addText(" going on ")
                .addFaIcon("fa-twitter")
                .build();

        exampleBuilder.setBootstrapText(text);
    }

    @OnClick(R.id.example_fa_text_change) void onChangeClicked() {
        android = !android;
        exampleChange.setIcon(android ? "fa-android" : "fa-apple");
    }

    @OnClick(R.id.example_fa_text_multi_change) void onMultiChangeClicked() {
        wikipedia = !wikipedia;
        String text = wikipedia ? "{fa-image} is in the {fa-cloud}" : "{fa-bank} are on {fa-globe}";
        exampleMultiChange.setMarkdownText(text);
    }

}
