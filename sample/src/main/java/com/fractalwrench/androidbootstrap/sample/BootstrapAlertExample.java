package com.fractalwrench.androidbootstrap.sample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapAlert;

import butterknife.BindView;
import butterknife.OnClick;

public class BootstrapAlertExample extends BaseActivity {

    public static final String TAG = "BootstrapAlertExample";

    @BindView(R.id.dynamic_alert) BootstrapAlert alert;

    @Override
    protected int getContentLayoutId() {
        return R.layout.example_bootstrap_alert;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alert.setVisibilityChangeListener(new BootstrapAlert.VisibilityChangeListener() {
            @Override
            public void onAlertDismissStarted(BootstrapAlert alert) {
                Log.d(TAG, "Started dismissing alert!");
            }

            @Override
            public void onAlertDismissCompletion(BootstrapAlert alert) {
                Log.d(TAG, "Finished dismissing alert!");
            }

            @Override
            public void onAlertAppearStarted(BootstrapAlert alert) {
                Log.d(TAG, "Started appearing alert!");
            }

            @Override
            public void onAlertAppearCompletion(BootstrapAlert alert) {
                Log.d(TAG, "Finished appearing alert!");
            }
        });
    }

    @OnClick(R.id.interactive_button)
    void onInteractiveButtonClicked() {
        if (View.GONE == alert.getVisibility()) {
            alert.show(true);
        }
        else {
            alert.dismiss(true);
        }
    }

}
