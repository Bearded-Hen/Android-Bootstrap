package com.example.sample;

import android.content.Context;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapTheme;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapTheme;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapButtonExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_bbutton;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupCustomStyle();
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

}
