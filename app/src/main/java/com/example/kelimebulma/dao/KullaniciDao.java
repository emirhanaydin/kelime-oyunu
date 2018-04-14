package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Kullanici;

@Dao
public interface KullaniciDao {
    @Query("SELECT ad FROM KullaniciTablosu WHERE id = :id")
    String getAd(int id);

    @Query("UPDATE KullaniciTablosu SET ad = :ad WHERE id = :id")
    void setAd(int id, String ad);

    @Query("SELECT soyad FROM KullaniciTablosu WHERE id = :id")
    String getSoyad(int id);

    @Query("UPDATE KullaniciTablosu SET soyad = :soyad WHERE id = :id")
    void setSoyad(int id, String soyad);

    @Query("SELECT kullanici_adi FROM kullanicitablosu WHERE id = :id")
    String getKullaniciAdi(int id);

    @Query("UPDATE KullaniciTablosu SET kullanici_adi = :kullaniciAdi WHERE id = :id")
    void setKullaniciAdi(int id, String kullaniciAdi);

    @Query("SELECT eposta FROM KullaniciTablosu WHERE id = :id")
    String getEposta(int id);

    @Query("UPDATE KullaniciTablosu SET eposta = :eposta WHERE id = :id")
    void setEposta(int id, String eposta);

    @Query("SELECT sifre FROM KullaniciTablosu WHERE id = :id")
    String getSifre(int id);

    @Query("UPDATE KullaniciTablosu SET sifre = :sifre WHERE id = :id")
    void setSifre(int id, String sifre);

    @Query("SELECT * FROM KullaniciTablosu WHERE id = :id")
    Kullanici getKullanici(int id);

    @Insert
    void ekle(Kullanici... kisiler);

    @Delete
    void sil(Kullanici kullanici);
}
