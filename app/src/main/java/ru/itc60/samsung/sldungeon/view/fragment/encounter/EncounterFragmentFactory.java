package ru.itc60.samsung.sldungeon.view.fragment.encounter;

import androidx.fragment.app.Fragment;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.ChestEncounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.EmptyEncounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.MonsterEncounter;
import ru.itc60.samsung.sldungeon.view.fragment.encounter.impl.ChestEncounterFragment;
import ru.itc60.samsung.sldungeon.view.fragment.encounter.impl.EmptyEncounterFragment;
import ru.itc60.samsung.sldungeon.view.fragment.encounter.impl.MonsterEncounterFragment;

public class EncounterFragmentFactory {

    public static Fragment get(Encounter encounter) {
        if (encounter instanceof MonsterEncounter) {
            return new MonsterEncounterFragment();
        }
        if (encounter instanceof ChestEncounter) {
            return new ChestEncounterFragment();
        }
        if (encounter instanceof EmptyEncounter) {
            return new EmptyEncounterFragment();
        }
        throw new RuntimeException("Неизвестный тип игрового события: " + encounter);
    }

}
