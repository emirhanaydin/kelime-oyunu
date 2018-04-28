package com.example.kelimebulma;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kelimebulma.model.Soru;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {
    static final int TOTAL_TIME_IN_SECS = 30;
    CountDownTimer mTimer;
    int mScore;
    TextView mScoreText;
    TextView mQuestionText;
    EditText mInputText;
    Soru mSoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mScore = 0;
        mScoreText = findViewById(R.id.scoreText);
        mQuestionText = findViewById(R.id.questionText);
        mInputText = findViewById(R.id.inputText);

        mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
        mQuestionText.setText(mSoru.soruMetni);

        final TextView timeLeftText = findViewById(R.id.timeLeft);

        final DecimalFormat df = new DecimalFormat("0.0");
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

        final EditText inputText = mInputText;
        inputText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN) return false;

                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_ENTER:
                        girdiKontrolu(inputText.getText().toString());
                        return true;
                }

                return false;
            }
        });
    }

    private void girdiKontrolu(String girdi) {
        if (girdi.equals(mSoru.cevap)) {
            mScore++;
            mScoreText.setText(String.valueOf(mScore));
            mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
            mQuestionText.setText(mSoru.soruMetni);
            mInputText.setText("");
        } else {
            //TODO: Yanlış durumu için bir eylem oluştur
            Toast.makeText(this, "YANLIŞ!", Toast.LENGTH_LONG).show();
        }
    }
}
