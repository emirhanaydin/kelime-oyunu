package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Puan;

@Dao
public interface PuanDao {
    @Query("SELECT kullanici FROM puan WHERE id = :id")
    int getKullanici(int id);

    @Query("UPDATE puan SET kullanici = :kullanici WHERE id = :id")
    void setKullanici(int id, int kullanici);

    @Query("SELECT * FROM puan WHERE id = :id")
    Puan getPuan(int id);

    @Insert
    void ekle(Puan... puanlar);

    @Delete
    void sil(Puan puan);
}
