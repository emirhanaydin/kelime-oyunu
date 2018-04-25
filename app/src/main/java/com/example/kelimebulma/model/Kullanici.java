package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "kullanici",
        indices = {
                @Index(value = {"kullanici_adi"}, unique = true),
                @Index(value = {"eposta"}, unique = true)})
public class Kullanici {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "ad")
    public String ad;
    @ColumnInfo(name = "soyad")
    public String soyad;
    @ColumnInfo(name = "kullanici_adi")
    public String kullaniciAdi;
    @ColumnInfo(name = "eposta")
    public String eposta;
    @ColumnInfo(name = "sifre")
    public String sifre;

    public Kullanici(String ad, String soyad, String kullaniciAdi, String eposta, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.eposta = eposta;
        this.sifre = sifre;
    }
}
