Android-Bootstrap
=================

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/device-2013-11-01-155630_framed.png "Device Image")

#Features

#Coming Soon...

#Installation

download the AndroidBootstrap library, import the library into your Android workspace, on the project you wish to use it in right click properties, add AndroidBootstrap as a library!

*WARNING: YOU MUST ALSO INCLUDE the fontawesome-webfont.ttf FILE INTO YOUR OWN PROJECTS ASSETS*

In each layout file, paste the following two lines below `xmlns:android="http://schemas.android.com/apk/res/android"`

```xml
xmlns:androidbootstrap="http://schemas.android.com/apk/res-auto"
xmlns:fontawesometext="http://schemas.android.com/apk/res-auto"
```

#How to use

## Bootstrap Buttons
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons.png "regular bootstrap buttons")

```xml

<!-- basic button -->
<com.beardedhen.androidbootstrap.BootstrapButton
    android:layout_width="wrap_content"
	android:layout_height="wrap_content"
    android:text="Default"
    androidbootstrap:type="default"
    androidbootstrap:icon_left="fa-heart"
    android:layout_margin="10dp"
/>
```
The above code inserts a default button with a heart icon to the left. The following attributes can be added to any BootstrapButton

`androidbootstrap:type="default"` 
`androidbootstrap:icon_left="fa-heart"` 
`androidbootstrap:icon_right="fa-trophy"`
`androidbootstrap:roundedCorners="true"`
`android:enabled="false"` 
`androidbootstrap:size="large"`

## Rounded Bootstrap Button
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_rounded.png "rounded bootstrap buttons")

## Others
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_others.png "other bootstrap buttons")

## Sizes
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_sizes.png "sized bootstrap buttons")

## Disabled
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/buttons_disabled.png "disabled bootstrap buttons")

## Font Awesome Text
![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/font_awesome_text.png "font_awesome_text")
