package ru.itc60.samsung.sldungeon.game.character;

import androidx.lifecycle.MediatorLiveData;

public class GameCharacter {

    private MediatorLiveData<Integer> hpLiveData = new MediatorLiveData<>();

    public GameCharacter() {
        hpLiveData.postValue(100);
    }

    public MediatorLiveData<Integer> getHp() {
        return hpLiveData;
    }

    public int takeDamage(int damage) {
        Integer hp = hpLiveData.getValue();

        hp = hp - damage;
        if (hp > 100) {
            hp = 100;
        }

        hpLiveData.postValue(hp);

        return hp;
    }

}
