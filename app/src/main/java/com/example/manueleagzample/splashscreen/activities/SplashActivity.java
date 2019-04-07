package com.example.manueleagzample.splashscreen.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.utils.PrefsManager;

/**
 * Created by TillyAndroid
 */

public class SplashActivity extends Activity {

    private PrefsManager prefsManager;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prefsManager = new PrefsManager(this);
        handler = new Handler();

        if(prefsManager.getIsLoggedIn()){
            goToMain();
        }else {
            goToLogin();
        }
    }

    private void goToLogin() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    private void goToMain() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
