package ru.itc60.samsung.sldungeon.game.character;

import ru.itc60.samsung.sldungeon.database.entity.MonsterDef;
import ru.itc60.samsung.sldungeon.game.character.GameCharacter;

public class Monster extends GameCharacter {

    private MonsterDef monsterDef;

    public Monster(MonsterDef monsterDef) {
        this.monsterDef = monsterDef;
    }

    public String getName() {
        return monsterDef.getName();
    }

    public String getImagePath() {
        return monsterDef.getImage();
    }

    public int getDamage() {
        return monsterDef.getDamage();
    }

}
