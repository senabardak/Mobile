package com.example.askin.merdivan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by KAAN BURAK SENER on 21.05.2015.
 */
public class Splash extends Activity {
    ImageView splashIcon;
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        splashIcon = (ImageView) findViewById(R.id.splashIcon);
        splashIcon.setImageResource(R.drawable.observer);

        Thread mSplashThread;
        mSplashThread = new Thread(){
            @Override public void run(){
                try {

                    synchronized(this){
                        wait(SPLASH_DISPLAY_LENGTH);
                    }
                }catch(InterruptedException ex){

                }
                finally{

                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };
        mSplashThread.start();
    }
}
