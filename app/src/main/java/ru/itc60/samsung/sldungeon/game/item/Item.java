package ru.itc60.samsung.sldungeon.game.item;

import ru.itc60.samsung.sldungeon.database.entity.ItemDef;
import ru.itc60.samsung.sldungeon.game.character.Hero;

public abstract class Item {

    protected ItemDef itemDef;

    public Item(ItemDef itemDef) {
        this.itemDef = itemDef;
    }

    public String getName() {
        return itemDef.getName();
    }

    public String getDescription() {
        return itemDef.getDescription();
    }

    public String getImagePath() {
        return itemDef.getImage();
    }

    public abstract void consume(Hero hero);

}
