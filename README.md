Android-Bootstrap
=================
Android Bootstrap is a library which provides several custom views styled according to the
 [Twitter Bootstrap Specification](http://getbootstrap.com/). This allows you to spend more time
  on development rather than trying to get a consistent theme across your app.
  
  
Quick Start
===========
 [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.beardedhen/androidbootstrap/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.beardedhen/androidbootstrap)
 
 Add the following dependency to your build.gradle:
 
 ```java
 dependencies {
    compile 'com.beardedhen:androidbootstrap:2.0.0'
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


Examples
============

###BootstrapButton
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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_button.png "BootstrapButton")


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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_button_group.png "BootstrapButtonGroup")


###AwesomeTextView
A text widget that displays Glyph icons, and is themeable using Bootstrap Brands.
   ```xml
<com.beardedhen.androidbootstrap.AwesomeTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:bootstrapBrand="success"
    app:fontAwesomeIcon="fa_android"
    />
```
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/awesome_text_view.png "AwesomeTextView")


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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_progress_bar.png "BootstrapProgressBar")


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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_label.png "BootstrapLabel")


###BootstrapEditText
Allows editing of text in a widget themed using BootstrapBrand.
   ```xml
<com.beardedhen.androidbootstrap.BootstrapEditText
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:bootstrapSize="md"
    app:bootstrapBrand="info"
    />
```
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_edit_text.png "BootstrapEditText")


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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_circle_thumbnail.png "BootstrapCircleThumbnail")


###BootstrapThumbnail
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
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_thumbnail.png "BootstrapThumbnail")
