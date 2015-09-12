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

    @Bind(R.id.example_progress_bar) BootstrapProgressBar progressBar;

    @OnClick(R.id.example_progress_bar) void onProgressBarClicked() {
        progressBar.setProgress(randomProgress(progressBar.getProgress()));
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
