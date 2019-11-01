package com.example.thingsflowjava.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thingsflowjava.R;
import com.example.thingsflowjava.api.Item;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.http.Url;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private ImageView imageView;
    private URL url;
    private Bitmap bitmap;
    private Thread thread;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.item_tv_title);
        imageView = itemView.findViewById(R.id.item_iv_image);

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    url = new URL("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png ");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    // TODO: error handle
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void onBind(Item item, int position) {
        if(position == 4) {
            try {
                thread.join();
                imageView.setImageBitmap(bitmap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            tvTitle.setText("#" + item.id + ": " + item.title);
        }
    }
}
