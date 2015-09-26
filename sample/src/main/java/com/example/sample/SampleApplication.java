package com.example.sample;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * A custom application class, which performs setup of the Typefaces used as Icon Sets.
 */
public class SampleApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        // setup FontAwesome font
        TypefaceProvider.registerDefaultIconSets();
    }

}
