package ru.itc60.samsung.sldungeon.game.encounter.impl;

import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.EncounterCallback;

public class EmptyEncounter extends Encounter {

    public EmptyEncounter(EncounterCallback callback, Hero hero) {
        super(callback, hero);
    }

    public void continueAdventure() {
        hero.takeDamage(-100);
        callback.onComplete();
    }

}
