package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImage = findViewById(R.id.splashImage);
        TextView splashText = findViewById(R.id.splashText);

        splashImage.animate()
                .alpha(1f)
                .scaleX(1.2f)
                .scaleY(1.2f)
                .rotation(360f)
                .setDuration(2000)
                .setInterpolator(new AccelerateDecelerateInterpolator());

        new Handler().postDelayed(() -> {
            splashText.animate()
                    .alpha(1f)
                    .translationY(-30f)
                    .setDuration(1000)
                    .withEndAction(() -> {
                        splashText.animate()
                                .translationY(0f)
                                .setDuration(500)
                                .start();
                    })
                    .start();
        }, 1000);

        new Handler().postDelayed(() -> {
            splashImage.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(1000)
                    .withEndAction(() -> {
                        splashImage.animate()
                                .scaleX(1.2f)
                                .scaleY(1.2f)
                                .setDuration(1000)
                                .start();
                    })
                    .start();
        }, 2000);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, 5000);
    }
}
