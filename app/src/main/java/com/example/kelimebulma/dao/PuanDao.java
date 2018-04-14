package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Puan;

@Dao
public interface PuanDao {
    @Query("SELECT kullanici_id FROM PuanTablosu WHERE id = :id")
    int getKullaniciId(int id);

    @Query("UPDATE PuanTablosu SET kullanici_id = :kullaniciId WHERE id = :id")
    void setKullaniciId(int id, int kullaniciId);

    @Query("SELECT * FROM PuanTablosu WHERE id = :id")
    Puan getPuan(int id);

    @Insert
    void ekle(Puan... puanlar);

    @Delete
    void sil(Puan puan);
}
