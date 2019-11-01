package com.example.thingsflowjava.main.image;

import android.view.View;
import android.widget.ImageView;

import com.example.thingsflowjava.R;
import com.example.thingsflowjava.api.Item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public MainImageViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.item_iv_image);
    }

//    public void onBind(String url) {
//        imageView
//    }
}
