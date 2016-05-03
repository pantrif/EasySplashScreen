[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EasySplashScreen-green.svg?style=true)](https://android-arsenal.com/details/1/3514)
# Easy Splash Screen Android
Easily create your company splash screen

<img src="/resources/intro.png" width="80%" alt="Android Easy Splash Screen"/>

Easy splash screen library allows you to generate beautiful and customizable Splash screens with less effort



## Usage
### Setup
This library is available on Jcenter.

```groovy
compile 'gr.pantrif:easy-android-splash-screen:0.0.1'
```


### Available options
```java
View easySplashScreenView = new EasySplashScreen(MainActivity.this)
                .withFullScreen()
                .withTargetActivity(TargetActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.holo_red_light)
                .withHeaderText("Header")
                .withFooterText("Copyright 2016")
                .withBeforeLogoText("My cool company")
                .withLogo(R.drawable.logo)
                .withAfterLogoText("Some more details")
                .create();

setContentView(easySplashScreenView);
```

### Customize views
```java
 EasySplashScreen config = new EasySplashScreen(MainActivity.this)
                .withFullScreen()
                .withTargetActivity(TargetActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.holo_red_light)
                .withHeaderText("Header")
                .withFooterText("Copyright 2016")
                .withBeforeLogoText("My cool company")
                .withLogo(R.drawable.logo)
                .withAfterLogoText("Some more details with custom font");
    //add custom font
    Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
    config.getAfterLogoTextView().setTypeface(pacificoFont);
    
    //change text color
    config.getHeaderTextView().setTextColor(Color.WHITE);
    
    //finally create the view
    View easySplashScreenView = config.create();
    setContentView(easySplashScreenView);
```
## License

~~~
The MIT License (MIT)
Copyright (c) 2016 Leonidas Maroulis

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
~~~
