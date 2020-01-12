package ru.itc60.samsung.sldungeon.game.item.impl;

import ru.itc60.samsung.sldungeon.database.entity.ItemDef;
import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.item.Item;

public class Junk extends Item {

    public Junk(ItemDef itemDef) {
        super(itemDef);
    }

    @Override
    public void consume(Hero hero) {
        hero.removeItem(this);
    }

}
