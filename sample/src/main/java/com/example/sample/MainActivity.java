package com.example.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.view_pager) ViewPager viewPager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.setAdapter(new ExamplePageAdapter(getSupportFragmentManager()));
    }

    private static class ExamplePageAdapter extends FragmentStatePagerAdapter {

        public ExamplePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FontAwesomeTextExample();
                case 1:
                    return new BootstrapButtonExample();
                case 2:
                    return new BootstrapLabelExample();
                default:
                    return null;
            }
        }

        @Override public int getCount() {
            return 3;
        }
    }

}