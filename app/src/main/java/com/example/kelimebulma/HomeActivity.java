package com.example.kelimebulma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private static String mKullaniciAdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.textViewKullaniciAdi);
        if (mKullaniciAdi == null)
            mKullaniciAdi = getIntent().getStringExtra(getString(R.string.exta_username));
        textView.setText(mKullaniciAdi);

        Button playButton = findViewById(R.id.buttonOyna);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });
    }
}
