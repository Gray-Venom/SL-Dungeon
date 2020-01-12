package ru.itc60.samsung.sldungeon.game.character;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;
import java.util.List;

import ru.itc60.samsung.sldungeon.game.character.GameCharacter;
import ru.itc60.samsung.sldungeon.game.item.Item;

public class Hero extends GameCharacter {

    private MediatorLiveData<List<Item>> itemsLiveData = new MediatorLiveData<>();

    public Hero() {
        itemsLiveData.postValue(new ArrayList<Item>());
    }

    public void addItem(Item item) {
        itemsLiveData.getValue().add(item);
        itemsLiveData.postValue(itemsLiveData.getValue());
    }

    public void removeItem(Item item) {
        itemsLiveData.getValue().remove(item);
        itemsLiveData.postValue(itemsLiveData.getValue());
    }

    public int getDamage() {
        return 20;
    }

    public LiveData<List<Item>> getInventory() {
        return itemsLiveData;
    }

}
