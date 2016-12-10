package com.fractalwrench.androidbootstrap.sample;

import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapBadge;
import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class BootstrapBadgeExample extends BaseActivity {

    @BindView(R.id.xml_badge_button) BootstrapButton xmlBadgeButton;
    @BindView(R.id.java_badge_button) BootstrapButton javaBadgeButton;
    @BindView(R.id.lonely_badge) BootstrapBadge lonelyBadge;

    @Override
    protected int getContentLayoutId() {
        return R.layout.example_bootstrap_badge;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BootstrapBadge badgeThird = new BootstrapBadge(this);
        badgeThird.setBadgeText("Hi!");
        javaBadgeButton.setBadge(badgeThird);
    }

    @OnClick(R.id.lonely_badge)
    void onLonelyButtonClicked() {
        lonelyBadge.setBadgeText(String.valueOf(new Random().nextInt()));
    }

    @OnClick(R.id.xml_badge_button)
    void onXmlButtonClicked() {
        xmlBadgeButton.setBadgeText(String.valueOf(new Random().nextInt()));
    }

    @OnClick(R.id.java_badge_button)
    void onJavaButtonClicked() {
        javaBadgeButton.setBadgeText(String.valueOf(new Random().nextInt()));
    }

}
