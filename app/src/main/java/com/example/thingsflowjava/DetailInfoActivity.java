package com.example.thingsflowjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.thingsflowjava.data.DummyData;
import com.example.thingsflowjava.main.MainActivity;

public class DetailInfoActivity extends AppCompatActivity {

    private TextView body;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        int id = getIntent().getIntExtra("id", -1);
        int position = getIntent().getIntExtra("position", -1);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setTitle("#" + id);
        }

        body = findViewById(R.id.detail_tv_body);

        body.setText(DummyData.dummyList.get(position).body);
    }
}
