package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Kullanici;

@Dao
public interface KullaniciDao {
    @Query("SELECT * FROM kullanici WHERE kullanici_adi = :kullaniciAdi")
    Kullanici getKullanici(String kullaniciAdi);

    @Insert
    void ekle(Kullanici... kisiler);
}
