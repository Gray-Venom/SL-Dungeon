package ru.itc60.samsung.sldungeon.game.encounter;

import ru.itc60.samsung.sldungeon.game.character.Hero;

public abstract class Encounter {

    protected EncounterCallback callback;
    protected Hero hero;

    public Encounter(EncounterCallback callback, Hero hero) {
        this.callback = callback;
        this.hero = hero;
    }

}
