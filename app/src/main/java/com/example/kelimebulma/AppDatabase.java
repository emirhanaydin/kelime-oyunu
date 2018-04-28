package com.example.kelimebulma;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.kelimebulma.dao.KullaniciDao;
import com.example.kelimebulma.dao.PuanDao;
import com.example.kelimebulma.dao.SoruDao;
import com.example.kelimebulma.model.Kullanici;
import com.example.kelimebulma.model.Puan;
import com.example.kelimebulma.model.Soru;

@Database(entities = {Soru.class, Kullanici.class, Puan.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "kelimeoyunu.db";
    private static AppDatabase mInstance;

    public synchronized static AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            boolean createDatabase = !doesDatabaseExist(context);

            mInstance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();

            if (createDatabase)
                SoruYoneticisi.sorulariEkle(context);
        }

        return mInstance;
    }

    private static boolean doesDatabaseExist(Context context) {
        return context.getDatabasePath(DATABASE_NAME).exists();
    }

    private synchronized static void destroyInstance() {
        mInstance = null;
    }

    public synchronized static void deleteDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
        destroyInstance();
    }

    public abstract SoruDao soruDao();

    public abstract KullaniciDao kullaniciDao();

    public abstract PuanDao puanDao();
}
