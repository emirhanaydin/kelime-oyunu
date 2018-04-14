package com.example.kelimebulma.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PuanTablosu",
        foreignKeys = @ForeignKey(entity = Kullanici.class,
                parentColumns = "id",
                childColumns = "kullanici_id"))
public class Puan {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kullanici_id")
    private int kullaniciId;
    @ColumnInfo(name = "puan")
    private int puan;
    @ColumnInfo(name = "tip")
    private String tip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
