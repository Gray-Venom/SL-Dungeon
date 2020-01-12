package ru.itc60.samsung.sldungeon.database.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import ru.itc60.samsung.sldungeon.database.entity.MonsterDef;

@Dao
public interface MonsterDao {

    @Query("SELECT * FROM MONSTERS ORDER BY random() LIMIT 1")
    MonsterDef findRandomSync();

}
