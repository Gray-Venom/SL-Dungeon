package ru.itc60.samsung.sldungeon.view.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.game.item.Item;

public class InventoryRecyclerAdapter extends SimpleRecyclerAdapter<Item, InventoryRecyclerViewHolder> {

    @NonNull
    @Override
    public InventoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InventoryRecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false));
    }

}
