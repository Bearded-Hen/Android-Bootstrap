package com.example.sample;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapButtonGroup;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapButtonGroupExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_button_group;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Bind(R.id.bbutton_group_orientation_change) BootstrapButtonGroup orientationChange;
    @Bind(R.id.bbutton_group_size_change) BootstrapButtonGroup sizeChange;
    @Bind(R.id.bbutton_group_outline_change) BootstrapButtonGroup outlineChange;
    @Bind(R.id.bbutton_group_rounded_change) BootstrapButtonGroup roundedChange;
    @Bind(R.id.bbutton_group_brand_change) BootstrapButtonGroup brandChange;
    @Bind(R.id.bbutton_group_child_change) BootstrapButtonGroup childChange;

    @OnClick(R.id.bbutton_group_orientation_change_btn) void onOrientationChangeExampleClicked() {
        boolean isHorizontal = orientationChange.getOrientation() == LinearLayout.HORIZONTAL;
        int newOrientation = isHorizontal ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL;
        orientationChange.setOrientation(newOrientation);
    }

    @OnClick(R.id.bbutton_group_outline_change_btn) void onOutlineChangeExampleClicked() {
        outlineChange.setShowOutline(!outlineChange.isShowOutline());
    }

    @OnClick(R.id.bbutton_group_rounded_change_btn) void onRoundedChangeExampleClicked() {
        roundedChange.setRounded(!roundedChange.isRounded());
    }

    @OnClick(R.id.bbutton_group_child_add_btn) void onChildAddExampleClicked() {
        int count = childChange.getChildCount();

        BootstrapButton button = new BootstrapButton(this);
        button.setText(String.format("%d", count + 1));

        childChange.addView(button);
    }

    @OnClick(R.id.bbutton_group_child_remove_btn) void onChildRemoveExampleClicked() {
        int count = childChange.getChildCount();

        if (count > 0) {
            childChange.removeViewAt(count - 1);
        }
    }

    @OnClick(R.id.bbutton_group_brand_change_btn) void onBrandChangeExampleClicked() {
        switch ((DefaultBootstrapBrand) brandChange.getBootstrapBrand()) {

            case PRIMARY:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
                break;
            case SUCCESS:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.INFO);
                break;
            case INFO:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.WARNING);
                break;
            case WARNING:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.DANGER);
                break;
            case DANGER:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.SECONDARY);
                break;
            case SECONDARY:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
                break;
            case REGULAR:
                brandChange.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
                break;
        }
    }

    @OnClick(R.id.bbutton_group_size_change_btn) void onSizeChangeExampleClicked() {
        switch ((DefaultBootstrapSize) sizeChange.getBootstrapSize()) {
            case MEDIUM:
                sizeChange.setBootstrapSize(DefaultBootstrapSize.SMALL);
                break;
            case SMALL:
                sizeChange.setBootstrapSize(DefaultBootstrapSize.LARGE);
                break;
            case LARGE:
                sizeChange.setBootstrapSize(DefaultBootstrapSize.MEDIUM);
                break;
        }
    }

}
