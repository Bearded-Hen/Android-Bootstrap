package com.fractalwrench.androidbootstrap.sample;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

public class BootstrapProgressBarExample extends BaseActivity {

    enum ChangeState {
        FIRST(false, false),
        SECOND(false, true),
        THIRD(true, false),
        FOURTH(true, true);

        private final boolean animated;
        private final boolean striped;

        ChangeState(boolean animated, boolean striped) {
            this.animated = animated;
            this.striped = striped;
        }

        public ChangeState next() {
            switch (this) {
                case FIRST:
                    return SECOND;
                case SECOND:
                    return THIRD;
                case THIRD:
                    return FOURTH;
                case FOURTH:
                    return FIRST;
                default:
                    return FIRST;
            }
        }
    }

    private Random random;
    private ChangeState changeState = ChangeState.FIRST;
    private DefaultBootstrapSize size = DefaultBootstrapSize.MD;

    @Override protected int getContentLayoutId() {
        return R.layout.example_bootstrap_progress_bar;
    }

    @Bind(R.id.example_progress_default) BootstrapProgressBar defaultExample;
    @Bind(R.id.example_progress_animated) BootstrapProgressBar animatedExample;
    @Bind(R.id.example_progress_striped) BootstrapProgressBar stripedExample;
    @Bind(R.id.example_progress_striped_animated) BootstrapProgressBar stripedAnimExample;
    @Bind(R.id.example_progress_change) BootstrapProgressBar changeExample;
    @Bind(R.id.example_size_change) BootstrapProgressBar sizeExample;

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

    @OnClick(R.id.example_progress_change_type_btn) void onAlterProgressBarParameters() {
        changeState = changeState.next();
        changeExample.setStriped(changeState.striped);
        changeExample.setAnimated(changeState.animated);
    }

    @OnClick(R.id.example_progress_change_rounded_btn) void onChangeRoundedProgressBar() {
        changeExample.setRounded(!changeExample.isRounded());
    }

    @OnClick(R.id.example_progress_change_color_btn) void onAlterProgressBarColor() {
        switch ((DefaultBootstrapBrand) changeExample.getBootstrapBrand()) {
            case PRIMARY:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
                break;
            case SUCCESS:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.INFO);
                break;
            case INFO:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.WARNING);
                break;
            case WARNING:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.DANGER);
                break;
            case DANGER:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.SECONDARY);
                break;
            case SECONDARY:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
            case REGULAR:
                changeExample.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
                break;
        }
    }

    @OnClick(R.id.example_size_change_btn) void onSizeExampleChangeClicked() {
        switch (size) {
            case XS:
                size = DefaultBootstrapSize.SM;
                break;
            case SM:
                size = DefaultBootstrapSize.MD;
                break;
            case MD:
                size = DefaultBootstrapSize.LG;
                break;
            case LG:
                size = DefaultBootstrapSize.XL;
                break;
            case XL:
                size = DefaultBootstrapSize.XS;
                break;
        }
        sizeExample.setBootstrapSize(size);
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
