package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Soru;

@Dao
public interface SoruDao {
    @Query("SELECT soru_metni FROM soru WHERE id = :id")
    String getSoruMetni(long id);

    @Query("UPDATE soru SET soru_metni = :soruMetni WHERE id = :id")
    void setSoruMetni(long id, String soruMetni);

    @Query("SELECT cevap FROM soru WHERE id = :id")
    String getCevap(long id);

    @Query("UPDATE soru SET cevap = :cevap WHERE id = :id")
    void setCevap(long id, String cevap);

    @Query("SELECT * FROM soru WHERE id = :id")
    Soru getSoru(long id);

    @Query("SELECT * FROM soru ORDER BY RANDOM() LIMIT 1;")
    Soru getRandom();

    @Insert
    void ekle(Soru... sorular);

    @Delete
    void sil(Soru soru);
}
