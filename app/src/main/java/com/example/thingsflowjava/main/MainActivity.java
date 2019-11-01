package com.example.thingsflowjava.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thingsflowjava.R;
import com.example.thingsflowjava.api.ApiService;
import com.example.thingsflowjava.api.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView test;
    private RecyclerView rcv;
    private Retrofit retrofit;
    private MainListAdapter adapter;

    private String baseUrl = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.main_rcv_items);
        adapter = new MainListAdapter();

        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(adapter);

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService api = retrofit.create(ApiService.class);

        Call<List<Item>> call = api.itemLists();

        call.enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                        List<Item> items = response.body();

                        for(Item item:items) {
                            adapter.addItem(item);
                            Log.d("asd", "done");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });


        adapter.notifyDataSetChanged();
    }
}