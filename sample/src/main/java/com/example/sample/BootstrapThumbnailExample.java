package com.example.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapThumbnail;
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

public class BootstrapThumbnailExample extends BaseActivity {

    private int resId = R.drawable.ladybird;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_thumbnail;
    }

    @Bind(R.id.bthumb_image_change_example) BootstrapThumbnail imageChange;
    @Bind(R.id.bthumb_theme_change_example) BootstrapThumbnail themeChange;
    @Bind(R.id.bthumb_rounded_change_example) BootstrapThumbnail roundedChange;
    @Bind(R.id.bthumb_set_image_bitmap_example) BootstrapThumbnail setBitmapExample;
    @Bind(R.id.bthumb_set_image_drawable_example) BootstrapThumbnail setDrawableExample;
    @Bind(R.id.bthumb_set_image_resource_example) BootstrapThumbnail setResourceExample;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.small_daffodils);
        setBitmapExample.setImageBitmap(bm);

        setDrawableExample.setImageDrawable(getResources().getDrawable(R.drawable.ladybird));
        setResourceExample.setImageResource(R.drawable.caterpillar);
    }

    @OnClick(R.id.bthumb_theme_change_example) void onThemeChangeExampleClicked() {
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

    @OnClick(R.id.bthumb_image_change_example) void onImageChangeExampleClicked() {
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

    @OnClick(R.id.bthumb_rounded_change_example) void onRoundedChangeExampleClicked() {
        roundedChange.setRounded(!roundedChange.isRounded());
    }

}
