package com.example.sample;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.enums.DefaultBootstrapTheme;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapButtonExample extends BasePageFragment {

    @Override protected int getLayoutResId() {
        return R.layout.example_bbutton;
    }

    @Bind(R.id.bbutton_example_corners) BootstrapButton exampleCorners;
    @Bind(R.id.bbutton_example_outline) BootstrapButton exampleOutline;
    @Bind(R.id.bbutton_example_size) BootstrapButton exampleSize;
    @Bind(R.id.bbutton_example_theme) BootstrapButton exampleTheme;

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

}
