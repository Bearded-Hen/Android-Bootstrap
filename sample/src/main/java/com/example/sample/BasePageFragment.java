package com.example.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import butterknife.ButterKnife;

abstract class BasePageFragment extends Fragment {

    protected abstract @LayoutRes int getLayoutResId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = (ScrollView) inflater.inflate(R.layout.page_container, container, false);

        View example = inflater.inflate(getLayoutResId(), scrollView, false);
        scrollView.addView(example);

        ButterKnife.bind(this, scrollView);
        return scrollView;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
