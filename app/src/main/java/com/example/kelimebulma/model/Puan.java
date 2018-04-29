package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "puan",
        foreignKeys = @ForeignKey(
                entity = Kullanici.class,
                parentColumns = "id",
                childColumns = "kullanici_id"),
        indices = @Index(value = {"kullanici_id"}, unique = true))
public class Puan {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "kullanici_id")
    public int kullaniciId;
    @ColumnInfo(name = "skor")
    public int skor;
    @ColumnInfo(name = "sure_ms")
    public int sureMs;
}
