package ru.itc60.samsung.sldungeon.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.itc60.samsung.sldungeon.database.dao.ItemDao;
import ru.itc60.samsung.sldungeon.database.dao.MonsterDao;
import ru.itc60.samsung.sldungeon.database.entity.ItemDef;
import ru.itc60.samsung.sldungeon.database.entity.MonsterDef;


@Database(version = 1, entities = {
    MonsterDef.class, ItemDef.class
})
public abstract class ApplicationDb extends RoomDatabase {

    private static ApplicationDb instance;

    public synchronized static ApplicationDb getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ApplicationDb.class, "sldungeon-db")
                    .createFromAsset("databases/rpg.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract MonsterDao getMonsterDao();

    public abstract ItemDao getItemDao();

}
