package com.fractalwrench.androidbootstrap.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.BootstrapProgressBarGroup;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class BootstrapProgressBarGroupExample extends BaseActivity {

    @BindView(R.id.example_progress_bar_group_add_group)
    BootstrapProgressBarGroup groupAdd;

    @BindView(R.id.example_progress_bar_group_round_group)
    BootstrapProgressBarGroup groupRound;

    @BindView(R.id.example_progress_bar_group_progress_1)
    BootstrapProgressBar bootstrapProgressBar1;

    @BindView(R.id.example_progress_bar_group_progress_2)
    BootstrapProgressBar bootstrapProgressBar2;

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

    @OnClick(R.id.example_progress_bar_group_progress)
    void onClickProgressChange(){
        Random rand = new Random();
        int progress = rand.nextInt(30) + 10;
        switch(rand.nextInt(2)){
            case 0:
                bootstrapProgressBar1.setProgress(progress);
                break;
            case 1:
                bootstrapProgressBar2.setProgress(progress);
                break;
        }

    }
}
