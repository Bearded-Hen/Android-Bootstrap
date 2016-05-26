package com.fractalwrench.androidbootstrap.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.BootstrapProgressBarGroup;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapProgressBarGroupExample extends BaseActivity {

    @Bind(R.id.example_progress_bar_group_add_group)
    BootstrapProgressBarGroup groupAdd;

    @Bind(R.id.example_progress_bar_group_round_group)
    BootstrapProgressBarGroup groupRound;

    boolean rounded = false;

    @Override
    protected int getContentLayoutId() {
        return R.layout.example_bootstrap_progress_bar_group;
    }

    @OnClick(R.id.example_progress_bar_group_add)
    void addToGroup(){
        Random rand = new Random();
        BootstrapProgressBar bar = new BootstrapProgressBar(this);
        bar.setProgress(10);
        int brand = 5;
        while (brand == 5) {
            brand = rand.nextInt(7);
        }
        bar.setBootstrapBrand(DefaultBootstrapBrand.fromAttributeValue(brand));

        if(groupAdd.getCumulativeProgress() + 10 <= 100) {
            groupAdd.addView(bar);
        }else{
            groupAdd.removeViews(2, groupAdd.getChildCount() - 3);
        }
    }

    @OnClick(R.id.example_progress_bar_group_round)
    void onRoundClick(){
        rounded = !rounded;
        groupRound.setRounded(rounded);
    }
}
