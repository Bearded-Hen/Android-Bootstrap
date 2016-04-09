package com.fractalwrench.androidbootstrap.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapBadge;
import com.beardedhen.androidbootstrap.BootstrapButton;

public class BootstrapBadgeExample extends Activity {
    TextView label;
    BootstrapBadge firstBadge;
    BootstrapBadge badgeSecond;
    BootstrapBadge badgeThird;
    BootstrapButton firstButton;
    BootstrapButton secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_bootstrap_badge);

        firstBadge = (BootstrapBadge) findViewById(R.id.lonely_badge);
        label = (TextView) findViewById(R.id.simple_text_view);
        firstButton = (BootstrapButton) findViewById(R.id.first_button);
        secondButton = (BootstrapButton) findViewById(R.id.second_button);

        badgeSecond = new BootstrapBadge(this);
        badgeThird = new BootstrapBadge(this);

        badgeSecond.setAllowZeroValue(false);
        badgeThird.setAllowZeroValue(true);

        firstButton.setBadge(badgeSecond);
        secondButton.setBadge(badgeThird);

        firstButton.setBadgeCount(3);
        firstBadge.setBadgeCount(10);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstButton.setBadgeCount(firstButton.getBadgeCount() - 1);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondButton.setBadgeCount(secondButton.getBadgeCount() + 1);
            }
        });
    }
}
