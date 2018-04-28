package com.example.kelimebulma;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kelimebulma.model.Soru;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class GameActivity2 extends AppCompatActivity {
    int QUESTIONS_NUM = 10;
    int time=0;
    //CountDownTimer mTimer;
    ///int mScore;
    TextView mScoreText;
    TextView mQuestionText;
    EditText mInputText;
    Soru mSoru;
    Chronometer chron;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //mScore = 0;
        mScoreText = findViewById(R.id.scoreText);
        mQuestionText = findViewById(R.id.questionText);
        mInputText = findViewById(R.id.inputText);
        mScoreText.setText(String.valueOf(QUESTIONS_NUM));
        mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
        mQuestionText.setText(mSoru.soruMetni);

        final TextView timeLeftText = findViewById(R.id.timeLeft);

        final DecimalFormat df = new DecimalFormat("0.0");
        timeLeftText.setText(df.format(0.0));

        /*mTimer = new CountDownTimer(TOTAL_TIME_IN_SECS * 1000, 10) {
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
        };*/

        chron=new Chronometer(this);
        chron.start();
        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(QUESTIONS_NUM>0) {

                                    timeLeftText.setText(df.format((SystemClock.elapsedRealtime() - chron.getBase())/1000));
                                    //return false;
                                }

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();



//        Geri sayımın başlamasından önce kısa bir süre beklenir.
        /*final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                chron.start();
            }
        }, 1, TimeUnit.SECONDS);
        */
        final EditText inputText = mInputText;
        if(QUESTIONS_NUM==0) {

            chron.stop();
            t.stop();
            //return false;
        }
        inputText.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() != KeyEvent.ACTION_DOWN) return false;

                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_ENTER:
                        girdiKontrolu2(inputText.getText().toString());
                        return true;
                }

                return false;
            }
        });

    }

    private void girdiKontrolu2(String girdi) {
        if (girdi.equalsIgnoreCase(mSoru.cevap)&&QUESTIONS_NUM>0) {

            QUESTIONS_NUM--;

            mScoreText.setText(String.valueOf(QUESTIONS_NUM));
            mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
            mQuestionText.setText(mSoru.soruMetni);
            mInputText.setText("");
        } else {
            //TODO: Yanlış durumu için bir eylem oluştur
            Toast.makeText(this, "YANLIŞ!", Toast.LENGTH_LONG).show();
        }
    }
}

