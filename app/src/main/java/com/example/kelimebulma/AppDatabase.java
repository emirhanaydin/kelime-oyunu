package com.example.kelimebulma;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.kelimebulma.dao.KelimeDao;
import com.example.kelimebulma.dao.KullaniciDao;
import com.example.kelimebulma.dao.PuanDao;
import com.example.kelimebulma.model.Kelime;
import com.example.kelimebulma.model.Kullanici;
import com.example.kelimebulma.model.Puan;

@Database(entities = {Kelime.class, Kullanici.class, Puan.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "kelimeoyunu.db";
    private static AppDatabase instance;

    public synchronized static AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();

        return instance;
    }

    public synchronized static void destroyInstance() {
        instance = null;
    }

    public synchronized static void deleteDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }

    public abstract KelimeDao kelimeDao();

    public abstract KullaniciDao kullaniciDao();

    public abstract PuanDao puanDao();
}
