package com.fractalwrench.androidbootstrap.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapThumbnail;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

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
    private DefaultBootstrapSize size = DefaultBootstrapSize.MD;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_thumbnail;
    }

    @Bind(R.id.bthumb_image_change_example) BootstrapThumbnail imageChange;
    @Bind(R.id.bthumb_theme_change_example) BootstrapThumbnail themeChange;
    @Bind(R.id.bthumb_border_change_example) BootstrapThumbnail borderChange;
    @Bind(R.id.bthumb_rounded_change_example) BootstrapThumbnail roundedChange;
    @Bind(R.id.bthumb_size_change_example) BootstrapThumbnail sizeChange;
    @Bind(R.id.bthumb_set_image_bitmap_example) BootstrapThumbnail setBitmapExample;
    @Bind(R.id.bthumb_set_image_drawable_example) BootstrapThumbnail setDrawableExample;
    @Bind(R.id.bthumb_set_image_resource_example) BootstrapThumbnail setResourceExample;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.small_daffodils);
        setBitmapExample.setImageBitmap(bm);

        setDrawableExample.setImageDrawable(getResources().getDrawable(R.drawable.ladybird));
        setResourceExample.setImageResource(R.drawable.caterpillar);
        sizeChange.setLayoutParams(getLayoutParams(size.scaleFactor()));
    }

    private LinearLayout.LayoutParams getLayoutParams(float factor) {
        float baselineSize = 300;
        float size = baselineSize * factor;
        return new LinearLayout.LayoutParams((int)size, (int)size);
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

    @OnClick(R.id.bthumb_border_change_example) void onBorderChangeExampleClicked() {
        borderChange.setBorderDisplayed(!borderChange.isBorderDisplayed());
    }

    @OnClick(R.id.bthumb_size_change_example) void onSizeChangeExampleClicked() {
        switch (size) {
            case XS:
                size = DefaultBootstrapSize.SM;
                break;
            case SM:
                size = DefaultBootstrapSize.MD;
                break;
            case MD:
                size = DefaultBootstrapSize.LG;
                break;
            case LG:
                size = DefaultBootstrapSize.XL;
                break;
            case XL:
                size = DefaultBootstrapSize.XS;
                break;
        }
        sizeChange.setBootstrapSize(size);
        sizeChange.setLayoutParams(getLayoutParams(size.scaleFactor()));
    }

}
