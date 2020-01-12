package ru.itc60.samsung.sldungeon.view.fragment.encounter.impl;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import ru.itc60.samsung.sldungeon.game.encounter.Encounter;
import ru.itc60.samsung.sldungeon.view.GameActivityVM;
import ru.itc60.samsung.sldungeon.game.encounter.impl.MonsterEncounter;
import ru.itc60.samsung.sldungeon.R;

public class MonsterEncounterFragment extends Fragment {

    private ProgressBar monsterHpBar;
    private TextView nameView;
    private ImageView imageView;
    private ImageButton waterButton;
    private ImageButton earthButton;
    private ImageButton fireButton;

    private Animation newEncounterAnimation;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_monster_encounter, container, false);

        monsterHpBar = view.findViewById(R.id.monster_hp);
        nameView = view.findViewById(R.id.name);
        imageView = view.findViewById(R.id.image);
        waterButton = view.findViewById(R.id.water_button);
        earthButton = view.findViewById(R.id.earth_button);
        fireButton = view.findViewById(R.id.fire_button);

        newEncounterAnimation = new AlphaAnimation(0, 1);
        newEncounterAnimation.setDuration(1500);

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
        if (!(encounter instanceof MonsterEncounter)) {
            return;
        }

        final MonsterEncounter monsterEncounter = (MonsterEncounter) encounter;
        nameView.setText(monsterEncounter.getName());

        monsterEncounter.getHp().removeObservers(MonsterEncounterFragment.this);
        monsterEncounter.getHp().observe(MonsterEncounterFragment.this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer hp) {
                monsterHpBar.setProgress(hp);
            }
        });

        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monsterEncounter.attack();
            }
        });

        earthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monsterEncounter.attack();
            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monsterEncounter.attack();
            }
        });

        AssetManager assetManager = getContext().getAssets();
        try (InputStream in = assetManager.open(monsterEncounter.getImagePath())){
            imageView.setImageBitmap(BitmapFactory.decodeStream(in));
            imageView.startAnimation(newEncounterAnimation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
