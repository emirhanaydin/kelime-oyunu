package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Kullanici;

@Dao
public interface KullaniciDao {
    @Query("SELECT kullanici_adi FROM kullanici WHERE id = :id")
    String getKullaniciAdi(long id);

    @Query("UPDATE kullanici SET kullanici_adi = :kullaniciAdi WHERE id = :id")
    void setKullaniciAdi(long id, String kullaniciAdi);

    @Query("SELECT sifre FROM kullanici WHERE id = :id")
    String getSifre(long id);

    @Query("UPDATE kullanici SET sifre = :sifre WHERE id = :id")
    void setSifre(long id, String sifre);

    @Query("SELECT * FROM kullanici WHERE id = :id")
    Kullanici getKullanici(long id);

    @Query("SELECT * FROM kullanici WHERE kullanici_adi = :kullaniciAdi")
    Kullanici getKullanici(String kullaniciAdi);

    @Insert
    void ekle(Kullanici... kisiler);

    @Delete
    void sil(Kullanici kullanici);
}
