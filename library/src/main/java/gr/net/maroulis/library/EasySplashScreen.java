package gr.net.maroulis.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by pantrif on 28/4/2016.
 */
public class EasySplashScreen {

    Activity mActivity;
    LayoutInflater mInflater;
    ImageView logo_iv;
    TextView header_tv;
    TextView footer_tv;
    TextView before_logo_tv;
    TextView after_logo_tv;
    String header_text=null;
    String footer_text=null;
    String before_logo_text=null;
    String after_logo_text = null;
    RelativeLayout splash_wrapper_rl;
    Bundle bundle = null;
    private View mView;
    private int splashBackgroundColor=0;
    private int splashBackgroundResource=0;
    private int mLogo = 0;
    private Class<?> TargetActivity = null;
    private int SPLASH_TIME_OUT = 2000; //The time before launch target Activity - by default 2 seconds

    public EasySplashScreen (Activity activity){
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.mView = mInflater.inflate(R.layout.splash, null);
        this.splash_wrapper_rl = (RelativeLayout) mView.findViewById(R.id.splash_wrapper_rl);

    }

    public EasySplashScreen withFullScreen(){
        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return this;
    }

    public EasySplashScreen withTargetActivity( Class<?> tAct){
        this.TargetActivity = tAct;
        return this;
    }

    public EasySplashScreen withSplashTimeOut( int timout){
        this.SPLASH_TIME_OUT = timout;
        return this;
    }
    public EasySplashScreen withBundleExtras( Bundle bundle){
        this.bundle = bundle;
        return this;
    }

    public EasySplashScreen withBackgroundColor( int color){
        this.splashBackgroundColor = color;
        splash_wrapper_rl.setBackgroundColor(splashBackgroundColor);
        return this;
    }

    public EasySplashScreen withBackgroundResource( int resource){
        this.splashBackgroundResource = resource;
        splash_wrapper_rl.setBackgroundResource(splashBackgroundResource);
        return this;
    }

    public EasySplashScreen withLogo( int logo){
        this.mLogo = logo;
        logo_iv = (ImageView) mView.findViewById(R.id.logo);
        logo_iv.setImageResource(mLogo);
        return this;
    }

    public EasySplashScreen withHeaderText( String text){
        this.header_text = text;
        header_tv = (TextView) mView.findViewById(R.id.header_tv);
        header_tv.setText(text);
        return this;
    }

    public EasySplashScreen withFooterText( String text){
        this.footer_text = text;
        footer_tv = (TextView) mView.findViewById(R.id.footer_tv);
        footer_tv.setText(text);
        return this;
    }

    public EasySplashScreen withBeforeLogoText( String text){
        this.before_logo_text = text;
        before_logo_tv = (TextView) mView.findViewById(R.id.before_logo_tv);
        before_logo_tv.setText(text);
        return this;
    }

    public EasySplashScreen withAfterLogoText( String text){
        this.after_logo_text = text;
        after_logo_tv = (TextView) mView.findViewById(R.id.after_logo_tv);
        after_logo_tv.setText(text);
        return this;
    }
    public ImageView getLogo(){
        return  logo_iv;
    }

    public TextView getBeforeLogoTextView(){
        return  before_logo_tv;
    }
    public TextView getAfterLogoTextView(){
        return  after_logo_tv;
    }
    public TextView getHeaderTextView(){
        return  header_tv;
    }
    public TextView getFooterTextView(){
        return  footer_tv;
    }

    public View create(){
        setUpHandler();

        return mView;
    }


    private void setUpHandler(){
        if (TargetActivity != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(mActivity, TargetActivity);
                    if (bundle != null) {
                        i.putExtras(bundle);
                    }
                    mActivity.startActivity(i);
                    // close splash
                    mActivity.finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

}
