package com.example.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapProgressExample extends BaseActivity {

    private Random random;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bprogress;
    }

    @Bind(R.id.example_progress_default) BootstrapProgressBar defaultExample;
    @Bind(R.id.example_progress_animated) BootstrapProgressBar animatedExample;
    @Bind(R.id.example_progress_striped) BootstrapProgressBar stripedExample;
    @Bind(R.id.example_progress_striped_animated) BootstrapProgressBar stripedAnimExample;

    @OnClick(R.id.example_progress_default_btn) void onDefaultClicked() {
        defaultExample.setProgress(randomProgress(defaultExample.getProgress()));
    }

    @OnClick(R.id.example_progress_animated_btn) void onAnimatedClicked() {
        animatedExample.setProgress(randomProgress(animatedExample.getProgress()));
    }

    @OnClick(R.id.example_progress_striped_btn) void onStripedClicked() {
        stripedExample.setProgress(randomProgress(stripedExample.getProgress()));
    }

    @OnClick(R.id.example_progress_striped_animated_btn) void onStripedAnimClicked() {
        stripedAnimExample.setProgress(randomProgress(stripedAnimExample.getProgress()));
    }

    private int randomProgress(int currentProgress) {
        if (random == null) {
            random = new Random();
        }

        int prog = currentProgress + random.nextInt(20);

        if (prog > 100) {
            prog -= 100;
        }

        return prog;
    }
}
