package com.example.thingsflowjava.main;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thingsflowjava.detail.DetailInfoActivity;
import com.example.thingsflowjava.R;
import com.example.thingsflowjava.api.Item;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainListAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final MainViewHolder viewHolder = new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv, parent, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if(viewHolder.getAdapterPosition() == 4) {
                    String url =  "https://thingsflow.com/ko/home";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                } else {
                    intent = new Intent(v.getContext(), DetailInfoActivity.class);

                    int position = viewHolder.getAdapterPosition();
                    intent.putExtra("position", position);
                }

                v.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(itemList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
