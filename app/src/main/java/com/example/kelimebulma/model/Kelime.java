package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "kelime")
public class Kelime {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "kelime_metni")
    public String kelimeMetni;
    @ColumnInfo(name = "soru")
    public String soru;

    public Kelime(String kelimeMetni, String soru) {
        this.kelimeMetni = kelimeMetni;
        this.soru = soru;
    }
}
