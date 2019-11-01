package com.example.thingsflowjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.example.thingsflowjava.main.MainActivity;

public class DetailInfoActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        int id = getIntent().getIntExtra("id", -1);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setTitle("#" + id);
        }
    }
}
