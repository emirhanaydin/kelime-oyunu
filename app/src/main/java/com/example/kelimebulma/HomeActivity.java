package com.example.kelimebulma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.textViewKullaniciAdi);
        String kullaniciAdi = getIntent().getStringExtra(getString(R.string.exta_kullanici_adi));
        textView.setText(kullaniciAdi);
    }
}
