package com.example.kelimebulma;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.kelimebulma.dao.KelimeDao;
import com.example.kelimebulma.dao.KullaniciDao;
import com.example.kelimebulma.dao.PuanDao;
import com.example.kelimebulma.model.Kelime;
import com.example.kelimebulma.model.Kullanici;
import com.example.kelimebulma.model.Puan;

@Database(entities = {Kelime.class, Kullanici.class, Puan.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract KelimeDao kelimeDao();

    public abstract KullaniciDao kullaniciDao();

    public abstract PuanDao puanDao();
}
