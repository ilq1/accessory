package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private android.widget.Spinner Spinner;
    private List<accessory> accessoryList;
    private String accessory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "accessory-db").allowMainThreadQueries().build();
        accessory ryzen_5_5600g = new accessory("medium", "processor");
        accessory geforce_RTX_3060 = new accessory("medium", "video_card");

        db.accessoryDao().insertAll(ryzen_5_5600g, geforce_RTX_3060);
        accessoryList = db.accessoryDao().getAllAccessory();
        for (accessory list: accessoryList){
            Log.d("accessory", String.valueOf(accessoryList));
        }

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.addAll();
        spinnerAdapter.notifyDataSetChanged();













    }
}