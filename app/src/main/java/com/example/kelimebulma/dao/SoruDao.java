package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Soru;

@Dao
public interface SoruDao {
    @Query("SELECT * FROM soru ORDER BY RANDOM() LIMIT 1;")
    Soru getRandom();

    @Insert
    void ekle(Soru... sorular);
}
