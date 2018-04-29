package com.example.kelimebulma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kelimebulma.dao.PuanDao;
import com.example.kelimebulma.model.Kullanici;
import com.example.kelimebulma.model.Puan;

public class HomeActivity extends AppCompatActivity {
    public static final int SCORE_REQUEST_CODE = 1;
    private TextView mUsernameText;
    private TextView mTimeText;
    private TextView mScoreText;

    private Puan mPuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUsernameText = findViewById(R.id.usernameLabel);
        mTimeText = findViewById(R.id.bestTimeText);
        mScoreText = findViewById(R.id.bestScoreText);

        initializeUser(getIntent().getStringExtra(getString(R.string.extra_username)));

        Button playButton = findViewById(R.id.againstTimeButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), GameActivity.class),
                        SCORE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        boolean processing = false;
        switch (requestCode) {
            case SCORE_REQUEST_CODE:
                processing = resultCode == RESULT_OK;
        }
        if (!processing) return;

        int score = data.getIntExtra(getString(R.string.extra_score), 0);

        if (score <= mPuan.skor)
            return;

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());

        PuanDao puanDao = appDatabase.puanDao();

        puanDao.setSkor(mPuan.id, score);

        mScoreText.setText(String.valueOf(score));
    }

    private void initializeUser(String username) {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());

        Kullanici kullanici = appDatabase.kullaniciDao().getKullanici(username);

        mPuan = appDatabase.puanDao().getPuanFromKullaniciId(kullanici.id);
        if (mPuan == null) {
            appDatabase.puanDao().ekle(
//            Bu referans tutulursa ID değeri bilinemez çünkü eklenme sırasında otomatik verilir.
                    new Puan(kullanici.id, 0, 0));

//            Veri tabanına eklendikten sonra yeni varlık sorgu ile alınır, böylece ID'si bilinir.
            mPuan = appDatabase.puanDao().getPuanFromKullaniciId(kullanici.id);
        }

        mUsernameText.setText(username);
        mTimeText.setText(GameHelper.getTimeString(mPuan.sureMs));
        mScoreText.setText(String.valueOf(mPuan.skor));
    }
}
