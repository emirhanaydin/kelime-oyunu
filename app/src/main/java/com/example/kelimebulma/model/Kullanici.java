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
    public final int id;

    @ColumnInfo(name = "ad")
    private String ad;
    @ColumnInfo(name = "soyad")
    private String soyad;
    @ColumnInfo(name = "kullanici_adi")
    private String kullaniciAdi;
    @ColumnInfo(name = "eposta")
    private String eposta;
    @ColumnInfo(name = "sifre")
    private String sifre;

    public Kullanici(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
