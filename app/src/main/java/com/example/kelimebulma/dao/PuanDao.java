package com.example.kelimebulma.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.kelimebulma.model.Puan;

@Dao
public interface PuanDao {
    @Query("UPDATE puan SET skor = :skor WHERE id = :id")
    void setSkor(long id, int skor);

    @Query("UPDATE puan SET sure_ms = :sureMs WHERE id = :id")
    void setSureMs(long id, long sureMs);

    @Query("SELECT * FROM puan INNER JOIN kullanici ON puan.kullanici_id = kullanici.id WHERE puan.kullanici_id = :kullaniciId")
    Puan getPuanFromKullaniciId(long kullaniciId);

    @Insert
    void ekle(Puan... puanlar);
}
