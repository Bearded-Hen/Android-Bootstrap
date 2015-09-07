package com.example.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme;
import com.beardedhen.androidbootstrap.support.BootstrapText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H1;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H2;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H3;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H4;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H5;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading.H6;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.DANGER;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.DEFAULT;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.INFO;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.PRIMARY;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.SUCCESS;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme.WARNING;

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


    /**
     * BootstrapLabel example code
     */


    @Bind(R.id.example_blabel_change_color) BootstrapLabel lblChangeColor;
    @Bind(R.id.example_blabel_change_heading) BootstrapLabel lblChangeHeading;
    @Bind(R.id.example_blabel_change_rounded) BootstrapLabel lblChangeRounded;

    @OnClick(R.id.example_blabel_change_heading) void onHeadingChangeClicked() {
        switch ((DefaultBootstrapHeading) lblChangeHeading.getBootstrapHeading()) {
            case H1:
                lblChangeHeading.setBootstrapHeading(H2);
                break;
            case H2:
                lblChangeHeading.setBootstrapHeading(H3);
                break;
            case H3:
                lblChangeHeading.setBootstrapHeading(H4);
                break;
            case H4:
                lblChangeHeading.setBootstrapHeading(H5);
                break;
            case H5:
                lblChangeHeading.setBootstrapHeading(H6);
                break;
            case H6:
                lblChangeHeading.setBootstrapHeading(H1);
                break;
            default:
                lblChangeHeading.setBootstrapHeading(H1);
                break;
        }
    }

    @OnClick(R.id.example_blabel_change_color) void onColorChangeClicked() {
        switch ((DefaultLabelTheme) lblChangeColor.getLabelTheme()) {
            case DEFAULT:
                lblChangeColor.setLabelTheme(PRIMARY);
                break;
            case PRIMARY:
                lblChangeColor.setLabelTheme(SUCCESS);
                break;
            case SUCCESS:
                lblChangeColor.setLabelTheme(INFO);
                break;
            case INFO:
                lblChangeColor.setLabelTheme(WARNING);
                break;
            case WARNING:
                lblChangeColor.setLabelTheme(DANGER);
                break;
            case DANGER:
                lblChangeColor.setLabelTheme(DEFAULT);
                break;
            default:
                lblChangeColor.setLabelTheme(PRIMARY);
                break;
        }
    }

    @OnClick(R.id.example_blabel_change_rounded) void onRoundedChangeClicked() {
        lblChangeRounded.setRoundedCorners(!lblChangeRounded.isRoundedCorners());
    }

}