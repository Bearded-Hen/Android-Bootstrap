package com.example.sample;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;

import butterknife.Bind;
import butterknife.OnClick;

import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.DANGER;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.INFO;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.PRIMARY;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.REGULAR;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.SUCCESS;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.WARNING;

public class BootstrapCircleThumbnailExample extends BaseActivity {

    private boolean showingBorder;
    private boolean showRed;
    private boolean originalImage = true;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_circle_thumbnail;
    }

    @Bind(R.id.bcircle_border_change_example) BootstrapCircleThumbnail borderChange;
    @Bind(R.id.bcircle_color_change_example) BootstrapCircleThumbnail colorChange;
    @Bind(R.id.bcircle_image_change_example) BootstrapCircleThumbnail imageChange;
    @Bind(R.id.bcircle_theme_change_example) BootstrapCircleThumbnail themeChange;

    @OnClick(R.id.bcircle_border_change_example) void onBorderChangeExampleClicked() {
        float px = 20;
        showingBorder = !showingBorder;
        borderChange.setBorderWidth(showingBorder ? px : 0);
    }

    @OnClick(R.id.bcircle_color_change_example) void onColorChangeExampleClicked() {
        showRed = !showRed;
        int resId = (showRed) ? R.color.bootstrap_brand_danger : R.color.bootstrap_brand_primary;
        colorChange.setBorderColor(getResources().getColor(resId));
    }

    @OnClick(R.id.bcircle_theme_change_example) void onThemeChangeExampleClicked() {
        switch ((DefaultBootstrapBrand) themeChange.getBootstrapBrand()) {
            case PRIMARY:
                themeChange.setBootstrapBrand(SUCCESS);
                break;
            case SUCCESS:
                themeChange.setBootstrapBrand(INFO);
                break;
            case INFO:
                themeChange.setBootstrapBrand(WARNING);
                break;
            case WARNING:
                themeChange.setBootstrapBrand(DANGER);
                break;
            case DANGER:
                themeChange.setBootstrapBrand(REGULAR);
                break;
            case REGULAR:
                themeChange.setBootstrapBrand(PRIMARY);
                break;
        }
    }

    @OnClick(R.id.bcircle_image_change_example) void onImageChangeExampleClicked() {
        originalImage = !originalImage;
        int resId = originalImage ? R.drawable.ladybird : R.drawable.caterpillar;
        imageChange.setImageResource(resId);
    }


}
