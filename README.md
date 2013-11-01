Android-Bootstrap
=================

![alt text](https://raw.github.com/Bearded-Hen/Android-Bootstrap/master/images/device-2013-11-01-155630_framed.png "Device Image")

#Features

#Coming Soon...

#Installation

download the AndroidBootstrap library, import the library into your Android workspace, on the project you wish to use it in right click properties, add AndroidBootstrap as a library!

*WARNING: YOU MUST ALSO INCLUDE THE fontawesome-webfont.ttf FILE INTO YOUR OWN PROJECTS ASSETS FOLDER*

In each layout file, paste the following two lines below `xmlns:android="http://schemas.android.com/apk/res/android"`

```xml
xmlns:androidbootstrap="http://schemas.android.com/apk/res-auto"
xmlns:fontawesometext="http://schemas.android.com/apk/res-auto"
```

#How to use


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

`androidbootstrap:type="default"` The type of button as per the [Bootstrap CSS Buttons](http://getbootstrap.com/css/#buttons)

`androidbootstrap:icon_left="fa-heart"` the icon to the left of the text, as per the [Font Awesome Cheat Sheet](http://fortawesome.github.io/Font-Awesome/cheatsheet/) 

`androidbootstrap:icon_right="fa-trophy"` the icon to the right of the text, as per the [Font Awesome Cheat Sheet](http://fortawesome.github.io/Font-Awesome/cheatsheet/)

`androidbootstrap:roundedCorners="true"` whether the button should have rounded corners, the defaults is false

`android:enabled="false"` disabled buttons appear more opaque, the default is true (buttons are enabled)

`androidbootstrap:size="large"` Size of the button as per [Bootstrap CSS Button sizes](http://getbootstrap.com/css/#buttons-sizes)

`android:textSize="12sp"` Text size must always be in sp!

#Font Awesome Text
```xml
<!-- basic text-->
<com.beardedhen.androidbootstrap.FontAwesomeText
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    fontawesometext:icon="fa-github"
    android:layout_margin="10dp" 
    android:textSize="32sp"
/>
```

`fontawesometext:icon="fa-github"` the icon to place, as per the [Font Awesome Cheat Sheet](http://fortawesome.github.io/Font-Awesome/cheatsheet/) 

`android:textSize="12sp"` Text size must always be in sp!

`android:textColor="@color/bbutton_primary"` you can change the textColor or background to any color, including the Bootstrap colours by typing bbutton_ and the type of colour e.g. bbutton_danger for the red danger colour.

#Examples

Please find included an AndroidBootstrapTest project. Inside the activity_main.xml layout file is examples of how to achieve each of the following buttons:

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
