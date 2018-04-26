package com.example.kelimebulma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.textViewKullaniciAdi);
        String kullaniciAdi = getIntent().getStringExtra(getString(R.string.exta_kullanici_adi));
        textView.setText(kullaniciAdi);

        Button playButton = findViewById(R.id.buttonOyna);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
            }
        });
    }
}
