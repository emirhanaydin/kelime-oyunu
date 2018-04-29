package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Puan;

@Dao
public interface PuanDao {
    @Query("SELECT kullanici_id FROM puan WHERE id = :id")
    int getKullanici(int id);

    @Query("UPDATE puan SET kullanici_id = :kullanici WHERE id = :id")
    void setKullanici(int id, int kullanici);

    @Query("SELECT skor FROM puan WHERE id = :id")
    int getSkor(int id);

    @Query("UPDATE puan SET skor = :skor WHERE id = :id")
    void setSkor(int id, int skor);

    @Query("SELECT sure_ms FROM puan WHERE id = :id")
    int getSureMs(int id);

    @Query("UPDATE puan SET sure_ms = :sureMs WHERE id = :id")
    void setSureMs(int id, int sureMs);

    @Query("SELECT * FROM puan WHERE id = :id")
    Puan getPuan(int id);

    @Query("SELECT * FROM puan INNER JOIN kullanici ON puan.kullanici_id = :kullaniciId")
    Puan getPuanFromKullaniciId(int kullaniciId);

    @Insert
    void ekle(Puan... puanlar);

    @Delete
    void sil(Puan puan);
}
