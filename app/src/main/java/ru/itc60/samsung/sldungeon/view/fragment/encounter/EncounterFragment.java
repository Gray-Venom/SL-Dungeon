package ru.itc60.samsung.sldungeon.view.fragment.encounter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.view.GameActivityVM;
import ru.itc60.samsung.sldungeon.R;

public class EncounterFragment extends Fragment {

    private ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_encounter, container, false);

        progressBar = view.findViewById(R.id.hero_hp);

        GameActivityVM vm = ViewModelProviders.of(getActivity()).get(GameActivityVM.class);
        vm.getEncounter().observe(this, new Observer<Encounter>() {
            @Override
            public void onChanged(Encounter encounter) {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.container, EncounterFragmentFactory.get(encounter))
                        .commit();
            }
        });
        vm.getHero().observe(this, new Observer<Hero>() {
            @Override
            public void onChanged(Hero hero) {
                onHeroChange(hero);
            }
        });

        return view;
    }

    private void onHeroChange(Hero hero) {
        hero.getHp().removeObservers(this);
        hero.getHp().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer hp) {
                progressBar.setProgress(hp);
            }
        });
    }

}
