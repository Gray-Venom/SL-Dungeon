package ru.itc60.samsung.sldungeon.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ITEMS")
public class ItemDef {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int id;
    @NonNull
    @ColumnInfo(name = "NAME")
    private String name;
    @NonNull
    @ColumnInfo(name = "DESCRIPTION")
    private String description;
    @NonNull
    @ColumnInfo(name = "TYPE")
    private String type;
    @NonNull
    @ColumnInfo(name = "IMAGE")
    private String image;
    @NonNull
    @ColumnInfo(name = "VALUE")
    private int value;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
