package ru.itc60.samsung.sldungeon.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.itc60.samsung.sldungeon.database.ApplicationDb;
import ru.itc60.samsung.sldungeon.database.dao.ItemDao;
import ru.itc60.samsung.sldungeon.database.dao.MonsterDao;
import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.item.ItemFactory;
import ru.itc60.samsung.sldungeon.game.character.Monster;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.EncounterCallback;
import ru.itc60.samsung.sldungeon.game.encounter.impl.ChestEncounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.EmptyEncounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.MonsterEncounter;

public class GameActivityVM extends AndroidViewModel {

    private MonsterDao monsterDao;
    private ItemDao itemDao;

    private MediatorLiveData<Encounter> encounterLiveData = new MediatorLiveData<>();
    private MediatorLiveData<Hero> heroLiveData = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> gameOverLiveData = new MediatorLiveData<>();

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public GameActivityVM(@NonNull Application application) {
        super(application);

        monsterDao = ApplicationDb.getDatabase(application.getApplicationContext()).getMonsterDao();
        itemDao = ApplicationDb.getDatabase(application.getApplicationContext()).getItemDao();

        reset();
    }

    private void generateEncounter() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Hero hero = heroLiveData.getValue();

                    EncounterCallback encounterCallback = new EncounterCallback() {
                        @Override
                        public void onComplete() {
                            generateEncounter();
                        }

                        @Override
                        public void onFailure() {
                            gameOverLiveData.postValue(true);
                        }
                    };

                    Encounter encounter;

                    int randomValue = new Random().nextInt(10);
                    if (randomValue == 0) {
                        encounter = new EmptyEncounter(encounterCallback, hero);
                    } else if (randomValue < 3) {
                        encounter = new ChestEncounter(encounterCallback, hero, ItemFactory.create(itemDao.findRandomSync()));
                    } else {
                        encounter = new MonsterEncounter(encounterCallback, hero, new Monster(monsterDao.findRandomSync()));
                    }

                    encounterLiveData.postValue(encounter);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void reset() {
        heroLiveData.setValue(new Hero());
        gameOverLiveData.setValue(false);
        generateEncounter();
    }

    public LiveData<Hero> getHero() {
        return heroLiveData;
    }

    public LiveData<Encounter> getEncounter() {
        return encounterLiveData;
    }

    public LiveData<Boolean> getGameOver() {
        return gameOverLiveData;
    }

}
