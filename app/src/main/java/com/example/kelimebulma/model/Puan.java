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
    public final int id;

    @ColumnInfo(name = "kullanici")
    private int kullanici;
    @ColumnInfo(name = "puan")
    private int puan;
    @ColumnInfo(name = "tip")
    private String tip;

    public Puan(int id) {
        this.id = id;
    }

    public int getKullanici() {
        return kullanici;
    }

    public void setKullanici(int kullanici) {
        this.kullanici = kullanici;
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
