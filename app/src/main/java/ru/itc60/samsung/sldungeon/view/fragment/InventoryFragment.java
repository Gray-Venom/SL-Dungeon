package ru.itc60.samsung.sldungeon.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.game.character.Hero;
import ru.itc60.samsung.sldungeon.game.item.Item;
import ru.itc60.samsung.sldungeon.view.GameActivityVM;
import ru.itc60.samsung.sldungeon.view.recycler.InventoryRecyclerAdapter;
import ru.itc60.samsung.sldungeon.view.recycler.SimpleRecyclerAdapter;

public class InventoryFragment extends Fragment {

    private RecyclerView inventoryRecycler;
    private InventoryRecyclerAdapter inventoryRecyclerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        inventoryRecycler = view.findViewById(R.id.recycler);

        inventoryRecyclerAdapter = new InventoryRecyclerAdapter();
        inventoryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        inventoryRecycler.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        inventoryRecycler.setAdapter(inventoryRecyclerAdapter);

        GameActivityVM vm = ViewModelProviders.of(getActivity()).get(GameActivityVM.class);
        vm.getHero().observe(this, new Observer<Hero>() {
            @Override
            public void onChanged(Hero hero) {
                onHeroChange(hero);
            }
        });

        return view;
    }

    private void onHeroChange(final Hero hero) {
        hero.getInventory().removeObservers(this);
        hero.getInventory().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                inventoryRecyclerAdapter.load(items);
                inventoryRecyclerAdapter.setOnClickListener(new SimpleRecyclerAdapter.OnClickListener<Item>() {
                    @Override
                    public void onClick(final Item item) {
                        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_consume, null);
                        Button acceptButton = view.findViewById(R.id.accept_button);
                        Button cancelButton = view.findViewById(R.id.cancel_button);

                        final Dialog dialog = new AlertDialog.Builder(getContext())
                                .setView(view)
                                .create();

                        acceptButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                item.consume(hero);
                                dialog.dismiss();
                            }
                        });
                        cancelButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                    }
                });
            }
        });
    }

}
