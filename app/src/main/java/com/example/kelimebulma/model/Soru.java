package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "soru")
public class Soru {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "soru_metni")
    public final String soruMetni;
    @ColumnInfo(name = "cevap")
    public final String cevap;

    public Soru(String soruMetni, String cevap) {
        this.soruMetni = soruMetni;
        this.cevap = cevap;
    }
}
