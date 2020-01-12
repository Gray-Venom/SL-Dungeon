package ru.itc60.samsung.sldungeon.game.encounter.impl;

import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.item.Item;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.EncounterCallback;

public class ChestEncounter extends Encounter {

    private Item item;

    public ChestEncounter(EncounterCallback callback, Hero hero, Item item) {
        super(callback, hero);
        this.item = item;
    }

    public void takeLoot() {
        hero.addItem(item);
        callback.onComplete();
    }

}
