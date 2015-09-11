package com.example.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapProgressExample extends BaseActivity {

    @Override protected int getContentLayoutId() {
        return R.layout.example_bprogress;
    }

    @Bind(R.id.example_progress_bar) BootstrapProgressBar progressBar;

    @OnClick(R.id.example_progress_bar) void onProgressBarClicked() {
        progressBar.setProgress(randomProgress());
    }

    private int randomProgress() {
        return new Random().nextInt(100);
    }
}
