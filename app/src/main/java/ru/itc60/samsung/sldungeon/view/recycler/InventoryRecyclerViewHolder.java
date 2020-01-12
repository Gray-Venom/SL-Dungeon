package ru.itc60.samsung.sldungeon.view.recycler;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import ru.itc60.samsung.sldungeon.R;
import ru.itc60.samsung.sldungeon.game.item.Item;

public class InventoryRecyclerViewHolder extends SimpleRecyclerViewHolder<Item> {

    private ImageView imageView;
    private TextView nameView;
    private TextView descriptionView;

    public InventoryRecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        nameView = itemView.findViewById(R.id.name);
        descriptionView = itemView.findViewById(R.id.description);
    }

    @Override
    protected void bind(Item obj) {
        nameView.setText(obj.getName());
        descriptionView.setText(obj.getDescription());

        AssetManager assetManager = itemView.getContext().getAssets();
        try (InputStream in = assetManager.open(obj.getImagePath())) {
            imageView.setImageBitmap(BitmapFactory.decodeStream(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
