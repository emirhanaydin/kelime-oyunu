package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "kullanici",
        indices = {@Index(value = {"kullanici_adi"}, unique = true)})
public class Kullanici {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "kullanici_adi")
    public String kullaniciAdi;
    @ColumnInfo(name = "sifre")
    public String sifre;

    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }
}
