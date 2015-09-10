package com.example.sample;

import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapHeading;
import com.beardedhen.androidbootstrap.api.defaults.DefaultLabelTheme;

import butterknife.Bind;
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

public class BootstrapLabelExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_blabel;
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
