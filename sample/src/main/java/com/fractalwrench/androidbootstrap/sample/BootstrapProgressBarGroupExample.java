package com.fractalwrench.androidbootstrap.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.BootstrapProgressBarGroup;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapProgressBarGroupExample extends BaseActivity {

    @Bind(R.id.sample_progress_bar_group_add_group)
    BootstrapProgressBarGroup group;

    @Override
    protected int getContentLayoutId() {
        return R.layout.example_bootstrap_progress_bar_group;
    }

    @OnClick(R.id.sample_progress_bar_group_add)
    void addToGroup(){
        BootstrapProgressBar bar = new BootstrapProgressBar(this);
        bar.setProgress(10);
        bar.setBootstrapBrand(DefaultBootstrapBrand.WARNING);
        if(group.getCumulativeProgress() + 10 < 100) {
            group.addView(bar);
        }
    }
}
