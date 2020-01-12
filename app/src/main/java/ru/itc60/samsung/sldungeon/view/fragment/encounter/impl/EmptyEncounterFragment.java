package ru.itc60.samsung.sldungeon.view.fragment.encounter.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.ChestEncounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.EmptyEncounter;
import ru.itc60.samsung.sldungeon.view.GameActivityVM;

public class EmptyEncounterFragment extends Fragment {

    private Button actionButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_empty_encounter, container, false);

        actionButton = view.findViewById(R.id.action_button);

        GameActivityVM vm = ViewModelProviders.of(getActivity()).get(GameActivityVM.class);
        vm.getEncounter().observe(this, new Observer<Encounter>() {
            @Override
            public void onChanged(Encounter encounter) {
                onEncounterChanged(encounter);
            }
        });

        return view;
    }

    private void onEncounterChanged(Encounter encounter) {
        if (!(encounter instanceof EmptyEncounter)) {
            return;
        }

        final EmptyEncounter emptyEncounter = (EmptyEncounter) encounter;

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyEncounter.continueAdventure();
            }
        });
    }

}
