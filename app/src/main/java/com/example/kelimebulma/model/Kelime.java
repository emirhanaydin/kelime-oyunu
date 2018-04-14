package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "KelimeTablosu")
public class Kelime {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kelime_metni")
    private String kelimeMetni;
    @ColumnInfo(name = "soru")
    private String soru;
    @ColumnInfo(name = "uzunluk")
    private int uzunluk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKelimeMetni() {
        return kelimeMetni;
    }

    public void setKelimeMetni(String kelimeMetni) {
        this.kelimeMetni = kelimeMetni;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public int getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(int uzunluk) {
        this.uzunluk = uzunluk;
    }
}
