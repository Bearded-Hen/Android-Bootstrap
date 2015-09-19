package com.example.sample;

import android.content.Context;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

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
        exampleCorners.setRounded(!exampleCorners.isRounded());
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
        switch ((DefaultBootstrapBrand) exampleTheme.getBootstrapBrand()) {
            case PRIMARY:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
                break;
            case SUCCESS:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.WARNING);
                break;
            case WARNING:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.DANGER);
                break;
            case DANGER:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.INFO);
                break;
            case INFO:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
                break;
            case REGULAR:
                exampleTheme.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
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
        exampleCustomStyle.setBootstrapBrand(new BootstrapBrand() {
            @Override public int defaultFill(Context context) {
                return context.getResources().getColor(R.color.custom_default_fill);
            }

            @Override public int defaultEdge(Context context) {
                return context.getResources().getColor(R.color.custom_default_edge);
            }

            @Override public int defaultTextColor(Context context) {
                return context.getResources().getColor(R.color.white);
            }

            @Override public int activeFill(Context context) {
                return context.getResources().getColor(R.color.custom_active_fill);
            }

            @Override public int activeEdge(Context context) {
                return context.getResources().getColor(R.color.custom_active_edge);
            }

            @Override public int activeTextColor(Context context) {
                return context.getResources().getColor(R.color.black);
            }

            @Override public int disabledFill(Context context) {
                return context.getResources().getColor(R.color.custom_disabled_fill);
            }

            @Override public int disabledEdge(Context context) {
                return context.getResources().getColor(R.color.custom_disabled_edge);
            }

            @Override public int disabledTextColor(Context context) {
                return context.getResources().getColor(R.color.bootstrap_gray);
            }
        });
    }

}
