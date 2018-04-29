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
    public long id;

    @ColumnInfo(name = "kullanici_id")
    public final long kullaniciId;
    @ColumnInfo(name = "skor")
    public final int skor;
    @ColumnInfo(name = "sure_ms")
    public final long sureMs;

    public Puan(long kullaniciId, int skor, long sureMs) {
        this.kullaniciId = kullaniciId;
        this.skor = skor;
        this.sureMs = sureMs;
    }
}
