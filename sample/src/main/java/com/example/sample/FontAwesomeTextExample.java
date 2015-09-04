package com.example.sample;

import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.FontAwesomeText;

import butterknife.Bind;
import butterknife.OnClick;

public class FontAwesomeTextExample extends BasePageFragment {

    @Override protected int getLayoutResId() {
        return R.layout.example_fa_text;
    }

    @Bind(R.id.example_fa_text_change) FontAwesomeText exampleChange;
    @Bind(R.id.example_fa_text_flash) FontAwesomeText exampleFlash;
    @Bind(R.id.example_fa_text_rotate) FontAwesomeText exampleRotate;
    @Bind(R.id.example_fa_text_multi_change) FontAwesomeText exampleMultiChange;
    @Bind(R.id.example_fa_text_builder) FontAwesomeText exampleBuilder;

    private boolean android = true;
    private boolean wikipedia = true;

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exampleFlash.startFlashing(true, FontAwesomeText.AnimationSpeed.FAST);
        exampleRotate.startRotate(true, FontAwesomeText.AnimationSpeed.SLOW);

        BootstrapText text = new BootstrapText.Builder(getActivity())
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
