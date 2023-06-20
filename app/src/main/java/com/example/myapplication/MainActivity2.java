package com.example.myapplication;

import static com.example.myapplication.R.id.listView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;



public class MainActivity2 extends AppCompatActivity {
    private android.widget.ListView listView;
    private String price;

    private List<Accessory> accessoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        price = getIntent().getStringExtra("price");

        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();

        accessoryList = new ArrayList<>();
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("processor", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("video_card", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("ram", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("motherboard", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("frame", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("disk", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("cooler", price));
        accessoryList.addAll(db.accessoryDao().getAccessoryByTypeAndPrice("power_unit", price));



        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        ArrayList<String> displayAccessories = new ArrayList<>();
        for (Accessory item : accessoryList) {
            displayAccessories.add(item.title);
        }
        ListView list = findViewById(R.id.listView);
        list.setAdapter(listAdapter);
        listAdapter.addAll(displayAccessories);
        listAdapter.notifyDataSetChanged();






    }


}