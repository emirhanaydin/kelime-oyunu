package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Soru;

@Dao
public interface SoruDao {
    @Query("SELECT soru_metni FROM Soru WHERE id = :id")
    String getSoruMetni(int id);

    @Query("UPDATE Soru SET soru_metni = :soruMetni WHERE id = :id")
    void setSoruMetni(int id, String soruMetni);

    @Query("SELECT cevap FROM Soru WHERE id = :id")
    String getCevap(int id);

    @Query("UPDATE Soru SET cevap = :cevap WHERE id = :id")
    void setCevap(int id, String cevap);

    @Query("SELECT * FROM Soru WHERE id = :id")
    Soru getSoru(int id);

    @Insert
    void ekle(Soru... sorular);

    @Delete
    void sil(Soru soru);
}
