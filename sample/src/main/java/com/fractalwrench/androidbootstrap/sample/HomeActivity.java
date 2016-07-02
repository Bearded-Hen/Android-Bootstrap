package com.fractalwrench.androidbootstrap.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.github_btn) void onGithubClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW); startActivity(intent);
        intent.setData(Uri.parse("https://github.com/Bearded-Hen/Android-Bootstrap"));
        startActivity(intent);
    }

    @OnClick(R.id.example_bootstrap_button) void onBootstrapButtonExampleClicked() {
        startActivity(new Intent(this, BootstrapButtonExample.class));
    }

    @OnClick(R.id.example_fontawesometext) void onFontAwesomeTextExampleClicked() {
        startActivity(new Intent(this, AwesomeTextViewExample.class));
    }

    @OnClick(R.id.example_bootstrap_label) void onBootstrapLabelExampleClicked() {
        startActivity(new Intent(this, BootstrapLabelExample.class));
    }

    @OnClick(R.id.example_bootstrap_progress) void onBootstrapProgressExampleClicked() {
        startActivity(new Intent(this, BootstrapProgressBarExample.class));
    }

    @OnClick(R.id.example_bootstrap_progress_group) void onBootstrapProgressGroupExampleClicked() {
        startActivity(new Intent(this, BootstrapProgressBarGroupExample.class));
    }

    @OnClick(R.id.example_bootstrap_btn_group) void onBootstrapButtonGroupExampleClicked() {
        startActivity(new Intent(this, BootstrapButtonGroupExample.class));
    }

    @OnClick(R.id.example_bootstrap_cricle_thumbnail) void onBootstrapCircleThumbnailExampleClicked() {
        startActivity(new Intent(this, BootstrapCircleThumbnailExample.class));
    }

    @OnClick(R.id.example_bootstrap_edit_text) void onBootstrapEditTextExampleClicked() {
        startActivity(new Intent(this, BootstrapEditTextExample.class));
    }

    @OnClick(R.id.example_bootstrap_thumbnail) void onBootstrapThumbnailExampleClicked() {
        startActivity(new Intent(this, BootstrapThumbnailExample.class));
    }

    @OnClick(R.id.example_bootstrap_well) void onBootstrapWellExampleClicked() {
        startActivity(new Intent(this, BootstrapWellExample.class));
    }

    @OnClick(R.id.example_bootstrap_dropdown) void onBootstrapDropdownExampleClicked() {
        startActivity(new Intent(this, BootstrapDropDownExample.class));
    }
    @OnClick(R.id.example_bootstrap_alert) void onBootstrapAlertExampleClicked() {
        startActivity(new Intent(this, BootstrapAlertExample.class));
    }

    @OnClick(R.id.example_bootstrap_badge) void onBootstrapBadgeExampleClicked() {
        startActivity(new Intent(this, BootstrapBadgeExample.class));
    }

}