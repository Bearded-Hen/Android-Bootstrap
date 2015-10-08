package com.fractalwrench.androidbootstrap.sample;

import android.os.Bundle;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapText;

import butterknife.Bind;
import butterknife.OnClick;

import static com.beardedhen.androidbootstrap.font.FontAwesome.FA_ANCHOR;
import static com.beardedhen.androidbootstrap.font.FontAwesome.FA_ANDROID;
import static com.beardedhen.androidbootstrap.font.FontAwesome.FA_APPLE;
import static com.beardedhen.androidbootstrap.font.FontAwesome.FA_HEART;
import static com.beardedhen.androidbootstrap.font.FontAwesome.FA_TWITTER;
import static com.beardedhen.androidbootstrap.font.Typicon.TY_CODE;

public class AwesomeTextViewExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_awesome_text_view;
    }

    @Bind(R.id.example_fa_text_change) AwesomeTextView exampleChange;
    @Bind(R.id.example_fa_text_flash) AwesomeTextView exampleFlash;
    @Bind(R.id.example_fa_text_rotate) AwesomeTextView exampleRotate;
    @Bind(R.id.example_fa_text_multi_change) AwesomeTextView exampleMultiChange;
    @Bind(R.id.example_fa_text_builder) AwesomeTextView exampleBuilder;
    @Bind(R.id.example_mix_and_match) AwesomeTextView mixAndMatch;

    private boolean android = true;
    private boolean wikipedia = true;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFontAwesomeText();
    }

    private void setupFontAwesomeText() {
        exampleFlash.startFlashing(true, AwesomeTextView.AnimationSpeed.FAST);
        exampleRotate.startRotate(true, AwesomeTextView.AnimationSpeed.SLOW);

        BootstrapText text = new BootstrapText.Builder(this)
                .addText("I ")
                .addFontAwesomeIcon(FA_HEART)
                .addText(" going on ")
                .addFontAwesomeIcon(FA_TWITTER)
                .build();

        exampleBuilder.setBootstrapText(text);

        mixAndMatch.setBootstrapText(new BootstrapText.Builder(this)
                .addFontAwesomeIcon(FA_ANCHOR)
                .addTypicon(TY_CODE)
                .build());
    }

    @OnClick(R.id.example_fa_text_change) void onChangeClicked() {
        android = !android;
        exampleChange.setFontAwesomeIcon(android ? FA_ANDROID : FA_APPLE);
    }

    @OnClick(R.id.example_fa_text_multi_change) void onMultiChangeClicked() {
        wikipedia = !wikipedia;
        String text = wikipedia ? "{fa_image} is in the {fa_cloud}" : "{fa_bank} are on {fa_globe}";
        exampleMultiChange.setMarkdownText(text);
    }

}
