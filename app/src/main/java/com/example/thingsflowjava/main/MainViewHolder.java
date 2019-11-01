package com.example.thingsflowjava.main;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.thingsflowjava.R;
import com.example.thingsflowjava.api.Item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.item_tv_title);
    }

    public void onBind(Item item) {
        tvTitle.setText("#" + item.id + ": " + item.title);
    }
}
