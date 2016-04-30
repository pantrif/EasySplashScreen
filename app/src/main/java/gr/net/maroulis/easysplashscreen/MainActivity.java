package gr.net.maroulis.easysplashscreen;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import gr.net.maroulis.library.EasySplashScreen;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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


        //set your own animations
        myCustomTextViewAnimation(config.getFooterTextView());

        //customize all TextViews
        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        config.getAfterLogoTextView().setTypeface(pacificoFont);

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);

        //create the view
        View easySplashScreenView = config.create();

        setContentView(easySplashScreenView);
    }

    private void myCustomTextViewAnimation(TextView tv){
        Animation animation=new TranslateAnimation(0,0,480,0);
        animation.setDuration(1200);
        tv.startAnimation(animation);
    }
}
