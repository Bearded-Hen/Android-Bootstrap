package com.example.sample;

import android.os.Bundle;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.support.BootstrapText;

import butterknife.Bind;
import butterknife.OnClick;

import static com.beardedhen.androidbootstrap.font.FontAwesomeIcon.FA_ANDROID;
import static com.beardedhen.androidbootstrap.font.FontAwesomeIcon.FA_APPLE;
import static com.beardedhen.androidbootstrap.font.FontAwesomeIcon.FA_HEART;
import static com.beardedhen.androidbootstrap.font.FontAwesomeIcon.FA_TWITTER;

public class AwesomeTextViewExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_awesome_text_view;
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
                .addIcon(FA_HEART)
                .addText(" going on ")
                .addIcon(FA_TWITTER)
                .build();


        exampleBuilder.setBootstrapText(text);
    }

    @OnClick(R.id.example_fa_text_change) void onChangeClicked() {
        android = !android;
        exampleChange.setIcon(android ? FA_ANDROID : FA_APPLE);
    }

    @OnClick(R.id.example_fa_text_multi_change) void onMultiChangeClicked() {
        wikipedia = !wikipedia;
        String text = wikipedia ? "{fa_image} is in the {fa_cloud}" : "{fa_bank} are on {fa_globe}";
        exampleMultiChange.setMarkdownText(text);
    }

}
