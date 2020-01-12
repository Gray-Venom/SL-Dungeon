package ru.itc60.samsung.sldungeon.game.item;

import ru.itc60.samsung.sldungeon.database.entity.ItemDef;
import ru.itc60.samsung.sldungeon.game.item.Item;
import ru.itc60.samsung.sldungeon.game.item.impl.HpPotion;
import ru.itc60.samsung.sldungeon.game.item.impl.Junk;

public class ItemFactory {

    public static Item create(ItemDef itemDef) {
        if (itemDef != null) {
            if ("hp_potion".equals(itemDef.getType())) {
                return new HpPotion(itemDef);
            } else if ("junk".equals(itemDef.getType())) {
                return new Junk(itemDef);
            }
        }

        ItemDef junkItemDef = new ItemDef();
        junkItemDef.setName("Хлам");
        junkItemDef.setDescription("Какой-то непонятный хлам. Возможно, кому-нибудь это может пригодиться, но не вам.");
        junkItemDef.setType("junk");
        junkItemDef.setValue(10);
        junkItemDef.setImage("images/items/junk.png");

        return new Junk(junkItemDef);
    }
}
