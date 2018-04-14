package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Kelime;

@Dao
public interface KelimeDao {
    @Query("SELECT kelime_metni FROM KelimeTablosu WHERE id = :id")
    String getKelimeMetni(int id);

    @Query("UPDATE KelimeTablosu SET kelime_metni = :kelimeMetni WHERE id = :id")
    void setKelimeMetni(int id, String kelimeMetni);

    @Query("SELECT soru FROM KelimeTablosu WHERE id = :id")
    String getSoru(int id);

    @Query("UPDATE KelimeTablosu SET soru = :soru WHERE id = :id")
    void setSoru(int id, String soru);

    @Query("SELECT soru FROM KelimeTablosu WHERE id = :id")
    int getUzunluk(int id);

    @Query("UPDATE KelimeTablosu SET uzunluk = :uzunluk WHERE id = :id")
    void setUzunluk(int id, String uzunluk);

    @Query("SELECT * FROM KelimeTablosu WHERE id = :id")
    Kelime getKelime(int id);

    @Insert
    void ekle(Kelime... kelimeler);

    @Delete
    void sil(Kelime kelime);
}
