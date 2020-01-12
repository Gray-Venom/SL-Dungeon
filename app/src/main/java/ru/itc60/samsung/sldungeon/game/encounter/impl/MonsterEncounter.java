package ru.itc60.samsung.sldungeon.game.encounter.impl;

import androidx.lifecycle.LiveData;
import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.character.Monster;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.EncounterCallback;

public class MonsterEncounter extends Encounter {

    private Monster monster;

    public MonsterEncounter(EncounterCallback callback, Hero hero, Monster monster) {
        super(callback, hero);
        this.monster = monster;
    }

    public String getName() {
        return monster.getName();
    }

    public String getImagePath() {
        return monster.getImagePath();
    }

    public LiveData<Integer> getHp() {
        return monster.getHp();
    }

    public void attack() {
        if (monster.takeDamage(hero.getDamage()) <= 0) {
            callback.onComplete();
            return;
        }

        if (hero.takeDamage(monster.getDamage()) <= 0) {
            callback.onFailure();
            return;
        }
    }

}
