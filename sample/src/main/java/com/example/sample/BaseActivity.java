package com.example.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ScrollView;

import butterknife.ButterKnife;

/**
 * Performs ButterKnife binding after adding example views to a scrollview root
 */
abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes protected abstract int getContentLayoutId();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.addView(LayoutInflater.from(this).inflate(getContentLayoutId(), scrollView, false));

        ButterKnife.bind(this);
    }

}
