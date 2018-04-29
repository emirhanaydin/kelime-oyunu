package com.example.kelimebulma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    public static final int AGAINST_TIME_REQUEST_CODE = 1;
    private TextView mScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mScoreText = findViewById(R.id.bestScoreText);

        TextView usernameLabel = findViewById(R.id.usernameLabel);
        usernameLabel.setText(getIntent().getStringExtra(getString(R.string.extra_username)));

        Button playButton = findViewById(R.id.againstTimeButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), GameActivity.class),
                        AGAINST_TIME_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case AGAINST_TIME_REQUEST_CODE:
                if (resultCode == RESULT_OK)
                    mScoreText.setText(
                            String.valueOf(
                                    data.getIntExtra(getString(R.string.extra_score), 0)));
                break;
        }
    }
}
