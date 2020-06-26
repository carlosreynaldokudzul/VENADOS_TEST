package com.venadostest.module.splash.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.venadostest.R;
import com.venadostest.module.menu.view.activities.MenuActivity;

public class SplashActivity extends AppCompatActivity {
    private final long TIME_TO_SHOW_SPLASHSCREEN = 300;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialize();
    }

    private void initialize() {
        mProgress = findViewById(R.id.splash_screen_progress_bar);
        startOperation();
    }

    private void startOperation() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.doWork();
                SplashActivity.this.startApp();
                SplashActivity.this.finish();
            }
        }).start();
    }
    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(TIME_TO_SHOW_SPLASHSCREEN);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}