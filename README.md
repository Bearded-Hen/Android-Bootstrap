Android-Bootstrap
=================
Android Bootstrap is an Android library which provides custom views styled according to the
 [Twitter Bootstrap Specification](http://getbootstrap.com/). This allows you to spend more time
  on development rather than trying to get a consistent theme across your app, especially if you are already familiar with the Bootstrap Framework.
  
Quick Start
===========
 [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.beardedhen/androidbootstrap/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.beardedhen/androidbootstrap)
 [![CircleCI](https://circleci.com/gh/Bearded-Hen/Android-Bootstrap/tree/develop.svg?style=shield)](https://circleci.com/gh/Bearded-Hen/Android-Bootstrap/tree/develop)
 <a href="http://www.methodscount.com/?lib=com.beardedhen%3Aandroidbootstrap%3A%2B"><img src="https://img.shields.io/badge/Methods and size-core: 913 | deps: 10417 | 431 KB-e91e63.svg"/></a>
 
 Add the following dependency to your build.gradle, ensuring you replace 'X.X.X' with the latest version on the button above:
 
 ```java
 dependencies {
    compile 'com.beardedhen:androidbootstrap:{X.X.X}'
 }
 ```
 
 You should also override your application class with the following:
 
 ```java
 public class SampleApplication extends Application {
     @Override public void onCreate() {
         super.onCreate();
         TypefaceProvider.registerDefaultIconSets();
     }
 }
 ```
 
 You should then checkout the library and investigate the sample code, which covers most of the features.
 The sample app is also available on [Google Play](https://play.google.com/store/apps/details?id=com.fractalwrench.androidbootstrap.sample).
 
Support
==============
If you have a question about how to use the project, please ask a question on [StackOverflow](http://stackoverflow.com/questions/tagged/android-bootstrap-widgets), using the tag **android-bootstrap-widgets**.

If you think you have found a bug in the library, you should [create a new issue](https://github.com/Bearded-Hen/Android-Bootstrap/issues/new) instead.
 
Javadoc
============
The javadoc for the project is hosted on [Github](http://bearded-hen.github.io/Android-Bootstrap/).

Examples
============

### BootstrapButton
A button that supports Glyph icons, and is themeable using Bootstrap Brands.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="BootstrapButton"
    app:bootstrapBrand="success"
    app:bootstrapSize="lg"
    app:buttonMode="regular"
    app:showOutline="false"
    app:roundedCorners="true"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_button.png" width="450" alt="BootstrapButton">

###BootstrapButtonGroup
Allows BootstrapButtons to be grouped together and their attributes controlled en masse.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapButtonGroup
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="BootstrapButtonGroup"
    android:orientation="vertical"
    app:bootstrapBrand="success"
    app:bootstrapSize="lg"
    app:roundedCorners="true"
    >
    <com.beardedhen.androidbootstrap.BootstrapButton
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="BootstrapButton 1"
       />
    <com.beardedhen.androidbootstrap.BootstrapButton
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="BootstrapButton 2"
       />
</com.beardedhen.androidbootstrap.BootstrapButtonGroup>
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_button_group.png" width="450" alt="BootstrapButtonGroup">


### AwesomeTextView
A text widget that displays Glyph icons, and is themeable using Bootstrap Brands.
   ```xml
<com.beardedhen.androidbootstrap.AwesomeTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:bootstrapBrand="success"
    app:fontAwesomeIcon="fa_android"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/awesome_text_view.png" width="450" alt="AwesomeTextView">

###BootstrapProgressBar
Displays progress in a bar from 0-100, and animates updates to the current progress.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapProgressBar
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:animated="true"
    app:bootstrapBrand="warning"
    app:progress="78"
    app:striped="true"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_progress_bar.png" width="450" alt="BootstrapProgressBar">

### BootstrapProgressBarGroup
Allows BootstrapProgressBars to be group together to have the effect of <a href="http://getbootstrap.com/components/#progress-stacked">stacked progress bar</a>.
   ```xml
        <com.beardedhen.androidbootstrap.BootstrapProgressBarGroup
            android:id="@+id/example_progress_bar_group_round_group"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center_vertical"
            app:bootstrapSize="md"
            app:bootstrapMaxProgress="100">

            <com.beardedhen.androidbootstrap.BootstrapProgressBar
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                app:bootstrapBrand="success"
                app:bootstrapProgress="20"
                />

            <com.beardedhen.androidbootstrap.BootstrapProgressBar
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                app:bootstrapBrand="danger"
                app:bootstrapProgress="20"
                />

            </com.beardedhen.androidbootstrap.BootstrapProgressBarGroup>
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_progress_bar_group.png" width="450" alt="BootstrapProgressBarGroup">

###BootstrapLabel
Displays non-clickable text in a widget similar to the BootstrapButton, sizable using H1-H6 elements.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapLabel
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:bootstrapBrand="primary"
    app:bootstrapHeading="h3"
    app:roundedCorners="true"
    android:text="Bootstrap Label"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_label.png" width="450" alt="BootstrapLabel">

### BootstrapEditText
Allows editing of text in a widget themed using BootstrapBrand.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapEditText
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:bootstrapSize="md"
    app:bootstrapBrand="info"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_edit_text.png" width="450" alt="BootstrapEditText">

###BootstrapCircleThumbnail
Displays images in a center-cropped Circular View, themed with BootstrapBrand.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapCircleThumbnail
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/my_drawable"
    app:bootstrapBrand="danger"
    app:hasBorder="true"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_circle_thumbnail.png" width="450" alt="BootstrapCircleThumbnail">

### BootstrapThumbnail
Displays images in a rectangular View, themed with BootstrapBrand.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapThumbnail
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/my_drawable"
    app:bootstrapBrand="info"
    app:hasBorder="true"
    />
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_thumbnail.png" width="450" alt="BootstrapThumbnail">

###BootstrapWell
Displays a view in a themed container.

```xml
<com.beardedhen.androidbootstrap.BootstrapWell
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_margin="8dp"
        app:bootstrapSize="xl">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="right"
            android:text="Look, I'm in a large well!"
            />
    </com.beardedhen.androidbootstrap.BootstrapWell>
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_well.png" width="450" alt="BootstrapWell">


###BootstrapDropDown
Displays a view with dropdown options, supplied by an array of strings.

```xml
<com.beardedhen.androidbootstrap.BootstrapDropDown
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="8dp"
                app:bootstrapText="Medium {fa_thumbs_o_up}"
                app:bootstrapBrand="regular"
                app:roundedCorners="true"
                app:bootstrapSize="md"
                app:dropdownResource="@array/bootstrap_dropdown_example_data"
                app:bootstrapExpandDirection="down"/>
```
<img src="https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_dropdown.png" width="450" alt="BootstrapDropdown">

 Custom Styles
============
Custom styles can be applied to any of the views in this library by creating a class which implements
BootstrapBrand, and setting it on the View. Please see the sample code of BootstrapButton for more detail.

 ```java

     class CustomBootstrapStyle implements BootstrapBrand {
         // specify desired colors here
     }

     BootstrapButton btn = new BootstrapButton(context);
     btn.setBootstrapBrand(new CustomBootstrapStyle(this);
 ```




Contributing
============
Contributions are very welcome! There are 3 main ways you can help out:

1. Add more Icon Typefaces, using the instructions [here](https://github.com/Bearded-Hen/Android-Bootstrap/blob/master/ADD_FONT.md)
2. Help implement views which are present in the  [Twitter Bootstrap Specification](http://getbootstrap.com/) but are not yet in this library.
3. Raise an issue if you see a bug or are unsure on how something works, or even better - send a pull-request with a fix!

Versioning
==========
This project uses [Semantic Versioning](http://semver.org/). There are several breaking changes in V2.X of the library, including:

- AwesomeTextView replaces FontAwesomeText
- Various altered method signatures/attributes for views
- Global BootstrapBrand/BootstrapSize attributes replace view-specific enums

Please consider what effect these changes might have on your app before upgrading!

Contact
=======
If you have any questions, issues, or just want to let us know where you're using Android Bootstrap
 tweet us at [@BeardedHen](https://twitter.com/beardedhen), email support@beardedhen.com,
  or head over to our [website](http://beardedhen.com/) to see more of our creations.

Hall of Fame
======
Checkout [AppBrain](http://www.appbrain.com/stats/libraries/details/androidbootstrap/android-bootstrap) to see some of the apps which use Android Bootstrap!

