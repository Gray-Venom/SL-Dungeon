package ru.itc60.samsung.sldungeon.view.recycler;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleRecyclerAdapter<T, VH extends SimpleRecyclerViewHolder<T>> extends RecyclerView.Adapter<VH> {

    private List<T> objects = new ArrayList<>();
    private OnClickListener listener;

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final T obj = objects.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(obj);
                }
            }
        });
        holder.bind(obj);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public void setOnClickListener(OnClickListener<T> listener) {
        this.listener = listener;
    }

    public void add(T obj) {
        objects.add(obj);
        notifyDataSetChanged();
    }

    public void remove(T obj) {
        objects.remove(obj);
        notifyDataSetChanged();
    }

    public void load(List<T> objects) {
        this.objects.clear();
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }

    public interface OnClickListener<T> {

        void onClick(T item);

    }

}
