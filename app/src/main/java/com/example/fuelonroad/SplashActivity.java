package com.example.fuelonroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(0,32,67));

        setContentView(R.layout.activity_splash);
        ImageView splashImage = findViewById(R.id.splash);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        splashImage.startAnimation(rotateAnimation);
        // Wait for 3 seconds and start the main activity
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 3500);
    }
}