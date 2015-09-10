package com.beardedhen.androidbootstrap.api.view;

public interface ProgressView {

    void setProgress(int progress);

    int getProgress();

    void setStriped(boolean striped);

    boolean isStriped();

    void setAnimated(boolean animated);

    boolean isAnimated();



    // TODO contextual colors

}
