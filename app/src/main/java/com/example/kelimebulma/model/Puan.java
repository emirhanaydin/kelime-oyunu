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
                childColumns = "kullanici"),
        indices = @Index(value = {"kullanici"}, unique = true))
public class Puan {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "kullanici")
    public int kullanici;
    @ColumnInfo(name = "puan")
    public int puan;
    @ColumnInfo(name = "tip")
    public String tip;
}
