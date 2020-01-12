package ru.itc60.samsung.sldungeon.view.recycler;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    public SimpleRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void bind(T obj);

}
