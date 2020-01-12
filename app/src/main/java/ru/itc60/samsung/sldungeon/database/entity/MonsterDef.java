package ru.itc60.samsung.sldungeon.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "MONSTERS")
public class MonsterDef {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int id;
    @NonNull
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "DAMAGE", defaultValue = "1")
    private int damage;
    @ColumnInfo(name = "RESISTANCE_WATER", defaultValue = "0")
    private int waterResistance;
    @ColumnInfo(name = "RESISTANCE_EARTH", defaultValue = "0")
    private int earthResistance;
    @ColumnInfo(name = "RESISTANCE_FIRE", defaultValue = "0")
    private int fireResistance;
    @NonNull
    @ColumnInfo(name = "IMAGE")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(int waterResistance) {
        this.waterResistance = waterResistance;
    }

    public int getEarthResistance() {
        return earthResistance;
    }

    public void setEarthResistance(int earthResistance) {
        this.earthResistance = earthResistance;
    }

    public int getFireResistance() {
        return fireResistance;
    }

    public void setFireResistance(int fireResistance) {
        this.fireResistance = fireResistance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
