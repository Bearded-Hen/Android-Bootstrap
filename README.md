Android-Bootstrap
=================


![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/device_image.png "Device Image")


Getting Started
=============

## Installation

### Gradle

If you're using Gradle you can simply add the following line to `build.gradle`:

```java
dependencies {
   compile 'com.beardedhen:androidbootstrap:+'
}
```

### Library Project

Alternatively you can use Android Bootstrap as a library project by downloading the source and linking to it in Eclipse.


### Four more steps

1. Copy [__fontawesome-webfont.ttf__](https://github.com/Bearded-Hen/Android-Bootstrap/raw/master/fontawesome-webfont.ttf) into the __assets folder__ of your project, as otherwise  __FontAwesome won't work__.

2. Paste the following XML into a layout file to create a BootstrapButton:
   
   ```xml
<!-- basic button -->
<com.beardedhen.androidbootstrap.BootstrapButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:text="Success"
    bootstrap:bb_icon_right="fa-android"
    bootstrap:bb_type="success"
/>
```

3. Add the bootstrap namespace to the root view of your layout:
   
   ```xml
xmlns:bootstrap="http://schemas.android.com/apk/res-auto"
```

4. Build and run the app. 

## More Information

For further information and examples please look at the test project or the [wiki](https://github.com/Bearded-Hen/Android-Bootstrap/wiki):
* [bootstrap buttons](https://github.com/Bearded-Hen/Android-Bootstrap/wiki/Bootstrap-Button)
* [font awesome texts](https://github.com/Bearded-Hen/Android-Bootstrap/wiki/Font-Awesome-Text)
* [bootstrap edit texts](https://github.com/Bearded-Hen/Android-Bootstrap/wiki/Bootstrap-Edit-Text)
* [boostrap thumbnails](https://github.com/Bearded-Hen/Android-Bootstrap/wiki/Bootstrap-Thumbnail)


If you have any questions, issues, or just want to let us know where you're using Android Bootstrap tweet us at [@BeardedHen](https://twitter.com/beardedhen), email support@beardedhen.com, or head over to our [website](http://beardedhen.com/) to see more of our creations.

#Apps Using Android-Bootstrap

[Forms on Mobile - Lite](https://play.google.com/store/apps/details?id=com.formsonmobile.lite.contactsdetails)


#Features
* Uses min SDK 7 which is Android 2.1 (Tested on a device running Android 2.2)
* Bootstrap buttons as per Bootstrap v3
* Rounded buttons
* Disabled buttons
* Various sized buttons (large to extra small)
* Just text buttons
* Left, right, left and right, or just icon button
* Font Awesome text as per Font Awesome v4
* Animations to Font Awesome Text items
* EditText backgrounds and states


#Examples

Check out the __AndroidBootstrapTest__ project. Inside __activity_main.xml__ you will find examples of how to achieve the following buttons:

Bootstrap Buttons

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons.png "regular bootstrap buttons")

Rounded Bootstrap Button

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_rounded.png "rounded bootstrap buttons")

Others

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_others.png "other bootstrap buttons")

Sizes

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_sizes.png "sized bootstrap buttons")

Disabled

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_disabled.png "disabled bootstrap buttons")

Font Awesome Text

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/font_awesome_text.png "font_awesome_text")

EditText

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_edit_text.png "edit text backgrounds")

Rounded Edit text
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/bootstrap_edit_text_rounded.png "edit text backgrounds rounded")

Thumbnail Square
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/thumbnail_square.png "edit text backgrounds rounded")

Thumbnails Rounded
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/thumbnail_rounded.png "edit text backgrounds rounded")

Thumbnails Rounded
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/thumbnail_rounded.png "edit text backgrounds rounded")

Circle Thumbnails
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/thumbnails_circle.png "circle thumbnails")

Circle Thumbnails Minimal
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/thumbnails_circle_minimal.png "circle thumbnails minimal")
