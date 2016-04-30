# EasySplashScreen
Easily create your company splash screen

<img src="/resources/cover.png" width="80%" alt="Android About Page Cover"/>

Easy splash screen library allows to generate beautiful and customizable Splash screens with less effort

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
                .create;

```

