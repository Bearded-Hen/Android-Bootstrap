package com.example.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapText;
import com.beardedhen.androidbootstrap.FontAwesomeText;
import com.beardedhen.androidbootstrap.api.BootstrapSize;
import com.beardedhen.androidbootstrap.api.BootstrapTheme;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapTheme;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupCustomStyle();
        setupFontAwesomeText();
    }


    /*
     * BootstrapButton example code
     */


    @Bind(R.id.bbutton_example_corners) BootstrapButton exampleCorners;
    @Bind(R.id.bbutton_example_outline) BootstrapButton exampleOutline;
    @Bind(R.id.bbutton_example_size) BootstrapButton exampleSize;
    @Bind(R.id.bbutton_example_theme) BootstrapButton exampleTheme;
    @Bind(R.id.example_bbutton_custom_style) BootstrapButton exampleCustomStyle;

    @OnClick(R.id.bbutton_example_corners) void onCornersExampleClicked() {
        exampleCorners.setRoundedCorners(!exampleCorners.isRoundedCorners());
    }

    @OnClick(R.id.bbutton_example_outline) void onOutlineExampleClicked() {
        exampleOutline.setShowOutline(!exampleOutline.isShowOutline());
    }

    @OnClick(R.id.bbutton_example_size) void onSizeExampleClicked() {
        switch ((DefaultBootstrapSize) exampleSize.getBootstrapSize()) {
            case MEDIUM:
                exampleSize.setBootstrapSize(DefaultBootstrapSize.SMALL);
                break;
            case SMALL:
                exampleSize.setBootstrapSize(DefaultBootstrapSize.LARGE);
                break;
            case LARGE:
                exampleSize.setBootstrapSize(DefaultBootstrapSize.MEDIUM);
                break;
        }
    }

    @OnClick(R.id.bbutton_example_theme) void onThemeExampleClicked() {
        switch ((DefaultBootstrapTheme) exampleTheme.getBootstrapTheme()) {
            case PRIMARY:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.SECONDARY);
                break;
            case SECONDARY:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.SUCCESS);
                break;
            case SUCCESS:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.WARNING);
                break;
            case WARNING:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.DANGER);
                break;
            case DANGER:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.LINK);
                break;
            case LINK:
                exampleTheme.setBootstrapTheme(DefaultBootstrapTheme.PRIMARY);
                break;
        }
    }

    private void setupCustomStyle() {
        // create a custom bootstrap size
        exampleCustomStyle.setBootstrapSize(new BootstrapSize() {
            @Override public int buttonFontSize(Context context) {
                return 24;
            }

            @Override public int buttonVerticalPadding(Context context) {
                return 20; // (in production use R.dimen values rather than raw pixel values)
            }

            @Override public int buttonHorizontalPadding(Context context) {
                return 40;
            }

            @Override public int buttonCornerRadius(Context context) {
                return 20;
            }

            @Override public int buttonLineHeight(Context context) {
                return 8;
            }
        });


        // create a Bootstrap Theme with holo colors
        exampleCustomStyle.setBootstrapTheme(new BootstrapTheme() {
            @Override public int defaultFill(Context context) {
                return context.getResources().getColor(R.color.custom_default_fill);
            }

            @Override public int defaultEdge(Context context) {
                return context.getResources().getColor(R.color.custom_default_edge);
            }

            @Override public int activeFill(Context context) {
                return context.getResources().getColor(R.color.custom_active_fill);
            }

            @Override public int activeEdge(Context context) {
                return context.getResources().getColor(R.color.custom_active_edge);
            }

            @Override public int textColor(Context context) {
                return context.getResources().getColor(R.color.white);
            }

            @Override public int disabledFill(Context context) {
                return context.getResources().getColor(R.color.custom_disabled_fill);
            }

            @Override public int disabledEdge(Context context) {
                return context.getResources().getColor(R.color.custom_disabled_edge);
            }
        });
    }


    /**
     * FontAwesomeText example code
     */


    @Bind(R.id.example_fa_text_change) FontAwesomeText exampleChange;
    @Bind(R.id.example_fa_text_flash) FontAwesomeText exampleFlash;
    @Bind(R.id.example_fa_text_rotate) FontAwesomeText exampleRotate;
    @Bind(R.id.example_fa_text_multi_change) FontAwesomeText exampleMultiChange;
    @Bind(R.id.example_fa_text_builder) FontAwesomeText exampleBuilder;

    private boolean android = true;
    private boolean wikipedia = true;

    private void setupFontAwesomeText() {
        exampleFlash.startFlashing(true, FontAwesomeText.AnimationSpeed.FAST);
        exampleRotate.startRotate(true, FontAwesomeText.AnimationSpeed.SLOW);

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