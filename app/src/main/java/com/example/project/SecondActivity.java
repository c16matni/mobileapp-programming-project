package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{
    Gson gson = new Gson();
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=c16matni";
    ArrayList<RecyclerViewItem> list;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("c16matni", json);

        Type type = new TypeToken<List<RecyclerViewItem>>() {}.getType();
        list = gson.fromJson(json, type);

        adapter = new RecyclerViewAdapter(this, list, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick( RecyclerViewItem item) {

            }
        });

        RecyclerView view = findViewById(R.id.recyclview_item);
        view.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
