package com.example.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;

import butterknife.Bind;
import butterknife.OnClick;

import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.DANGER;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.INFO;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.PRIMARY;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.REGULAR;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.SECONDARY;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.SUCCESS;
import static com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand.WARNING;

public class BootstrapCircleThumbnailExample extends BaseActivity {

    private int resId = R.drawable.ladybird;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_circle_thumbnail;
    }

    @Bind(R.id.bcircle_image_change_example) BootstrapCircleThumbnail imageChange;
    @Bind(R.id.bcircle_theme_change_example) BootstrapCircleThumbnail themeChange;
    @Bind(R.id.bcircle_border_change_example) BootstrapCircleThumbnail borderChange;
    @Bind(R.id.bcircle_set_image_bitmap_example) BootstrapCircleThumbnail setBitmapExample;
    @Bind(R.id.bcircle_set_image_drawable_example) BootstrapCircleThumbnail setDrawableExample;
    @Bind(R.id.bcircle_set_image_resource_example) BootstrapCircleThumbnail setResourceExample;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.small_daffodils);
        setBitmapExample.setImageBitmap(bm);

        setDrawableExample.setImageDrawable(getResources().getDrawable(R.drawable.ladybird));
        setResourceExample.setImageResource(R.drawable.caterpillar);
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
                themeChange.setBootstrapBrand(SECONDARY);
                break;
            case SECONDARY:
                themeChange.setBootstrapBrand(REGULAR);
                break;
            case REGULAR:
                themeChange.setBootstrapBrand(PRIMARY);
                break;
        }
    }

    @OnClick(R.id.bcircle_image_change_example) void onImageChangeExampleClicked() {
        switch (resId) {
            case R.drawable.ladybird:
                resId = R.drawable.caterpillar;
                break;
            case R.drawable.caterpillar:
                resId = 0;
                break;
            case 0:
                resId = R.drawable.ladybird;
                break;
        }
        imageChange.setImageResource(resId);
    }

    @OnClick(R.id.bcircle_border_change_example) void onBorderChangeExampleClicked() {
        borderChange.setBorderDisplayed(!borderChange.isBorderDisplayed());
    }

}
