package com.example.kelimebulma;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {
    static final int TOTAL_TIME_IN_SECS = 3;
    CountDownTimer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final TextView timeLeftText = findViewById(R.id.timeLeft);

        final DecimalFormat df = new DecimalFormat("0.00##");
        timeLeftText.setText(df.format(TOTAL_TIME_IN_SECS));

        mTimer = new CountDownTimer(TOTAL_TIME_IN_SECS * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                float secondsLeft = (float) millisUntilFinished / 1000;
                timeLeftText.setText(df.format(secondsLeft));
            }

            @Override
            public void onFinish() {
                timeLeftText.setText(df.format(0));

                startActivity(
                        new Intent(getApplicationContext(), HomeActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        };

//        Geri sayımın başlamasından önce kısa bir süre beklenir.
        final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                mTimer.start();
            }
        }, 1, TimeUnit.SECONDS);
    }
}
