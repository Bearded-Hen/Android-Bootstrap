Adding a Custom Font
=================

Android Bootstrap uses Typeface Icon Sets, which provide scalable graphics without the hassle of
adding different drawable sizes for various screen densities. It should be possible to define your
own icon sets by following the instructions below. Please send pull requests if you want an icon set
added to the library by default.

1.
Find the [reference sheet](https://fortawesome.github.io/Font-Awesome/cheatsheet/)
 for the typeface, and use a script to parse it. 
An example [parsing script](https://github.com/Bearded-Hen/AndroidBootstrapSample) is currently available
for the FontAwesome and Typicon typefaces. If possible, please also send a pull request for the script itself!

2.
Create a class which implements the IconSet interface. This describes the location of the typeface
in the assets directory, and the icon codes which map to unicode characters. See the default icon sets
for examples.

3.
Copy the typeface TTF file to the assets directory.

4.
Initialise the custom typeface by calling TypefaceProvider.registerCustomIconSet().

5.
Add icons to text using the BootstrapTextBuilder.

6.
Test out the new icon set, send a pull request, or raise an issue if something isn't working.