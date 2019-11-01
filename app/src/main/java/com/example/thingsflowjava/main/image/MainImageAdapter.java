package com.example.thingsflowjava.main.image;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thingsflowjava.R;
import com.example.thingsflowjava.main.MainViewHolder;
import com.example.thingsflowjava.api.*;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainImageAdapter extends RecyclerView.Adapter<MainImageViewHolder> {
    private ArrayList<Item> itemList;

    @NonNull
    @Override
    public MainImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final MainImageViewHolder viewHolder = new MainImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_rcv, parent, false));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
