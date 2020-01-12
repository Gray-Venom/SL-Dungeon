package ru.itc60.samsung.sldungeon.view.fragment.encounter.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.game.encounter.impl.ChestEncounter;
import ru.itc60.samsung.sldungeon.view.GameActivityVM;

public class ChestEncounterFragment extends Fragment {

    private ImageView imageView;
    private Button actionButton;

    private Animation openAnimation;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_chest_encounter, container, false);

        imageView = view.findViewById(R.id.image);
        actionButton = view.findViewById(R.id.action_button);

        openAnimation = new AlphaAnimation(0, 1);
        openAnimation.setDuration(1000);

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
        if (!(encounter instanceof ChestEncounter)) {
            return;
        }

        final ChestEncounter chestEncounter = (ChestEncounter) encounter;

        actionButton.setText("Открыть");
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.chest_opened);
                imageView.startAnimation(openAnimation);

                actionButton.setText("Продолжить");
                actionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chestEncounter.takeLoot();
                    }
                });
            }
        });

        imageView.setImageResource(R.drawable.chest_closed);
        imageView.startAnimation(openAnimation);
    }

}
