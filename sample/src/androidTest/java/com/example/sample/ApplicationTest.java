package com.example.sample;

import android.app.Application;
import android.graphics.Typeface;
import android.test.ApplicationTestCase;

import com.beardedhen.androidbootstrap.font.FontIconSet;
import com.beardedhen.androidbootstrap.font.TypefaceProvider;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * Check registered typefaces are in the assets directory
     */
    public void testTypefacePresent() {
        TypefaceProvider.registerDefaultIconSets();
        for (FontIconSet set : TypefaceProvider.getRegisteredIconSets()) {
            Typeface typeface = TypefaceProvider.getTypeface(getContext(), set.fontPath());
            assertNotNull(typeface);
        }
    }

}