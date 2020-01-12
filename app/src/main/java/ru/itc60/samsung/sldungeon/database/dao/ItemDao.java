package ru.itc60.samsung.sldungeon.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import ru.itc60.samsung.sldungeon.database.entity.ItemDef;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM ITEMS ORDER BY random() LIMIT 1")
    ItemDef findRandomSync();

}
