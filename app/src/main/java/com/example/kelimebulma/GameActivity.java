package com.example.kelimebulma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kelimebulma.model.Soru;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {
    private CountDownTimer mCountdownTimer;
    private Timer mTimer;
    private int mScore;
    private TextView mScoreText;
    private TextView mTimeText;
    private TextView mQuestionText;
    private EditText mInputText;
    private Soru mSoru;

    private long mElapsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mScore = 0;
        mScoreText = findViewById(R.id.scoreText);
        mTimeText = findViewById(R.id.timeText);
        mQuestionText = findViewById(R.id.questionText);
        mInputText = findViewById(R.id.inputText);

        mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
        mQuestionText.setText(mSoru.soruMetni);

        String mGameMode = getIntent().getStringExtra(HomeActivity.EXTRA_MODE);

        switch (mGameMode) {
            case HomeActivity.AGAINST_TIME_MODE:
                final long TOTAL_TIME_MILLIS = 30000;

                mTimeText.setText(GameHelper.getTimeString(TOTAL_TIME_MILLIS));

                mCountdownTimer = new CountDownTimer(TOTAL_TIME_MILLIS, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mTimeText.setText(GameHelper.getTimeString(millisUntilFinished));
                    }

                    @Override
                    public void onFinish() {
                        mTimeText.setText(GameHelper.getTimeString(0));

                        setResult(Activity.RESULT_OK, new Intent().putExtra(getString(R.string.extra_score), mScore));

                        finish();
                    }
                };

                //        Geri sayımın başlamasından önce kısa bir süre beklenir.
                final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
                executorService.schedule(new Runnable() {
                    @Override
                    public void run() {
                        mCountdownTimer.start();
                    }
                }, 1, TimeUnit.SECONDS);

                mInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                        if (isEditorActionValid(id)) {
                            checkInputText();
                        }

                        return true;
                    }
                });
                break;
            case HomeActivity.NORMAL_MODE:
                final int TARGET_SCORE = 10;

                mTimeText.setText(GameHelper.getTimeString(0));
                ((TextView) findViewById(R.id.timeLabel)).setText(getString(R.string.elapsed_time));

                mTimer = new Timer();
                mElapsed = 0;

                mTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mElapsed += 100;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTimeText.setText(GameHelper.getTimeString(mElapsed));
                            }
                        });
                    }
                }, 1000, 100);

                mInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                        if (isEditorActionValid(id)) {
                            checkInputText();

                            if (mScore >= TARGET_SCORE) {
                                mTimer.cancel();
                                mTimer.purge();

                                setResult(Activity.RESULT_OK, new Intent().putExtra(getString(R.string.extra_time), mElapsed));

                                finish();
                            }
                        }

                        return true;
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Game mode value is wrong.");
        }

    }

    private boolean isEditorActionValid(int id) {
        return id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL;
    }

    private void checkInputText() {
        if (mInputText.getText().toString().equalsIgnoreCase(mSoru.cevap)) {
            mScore++;
            mScoreText.setText(String.valueOf(mScore));
            mSoru = SoruYoneticisi.rastgeleSoruAl(getApplicationContext());
            mQuestionText.setText(mSoru.soruMetni);
            mInputText.setText("");
        } else {
            mInputText.setError(getString(R.string.error_wrong_answer));
        }
    }
}
