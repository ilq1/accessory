package com.example.myapplication;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    private android.widget.Spinner Spinner;
    private List<Accessory> accessoryList;
    private String accessory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();
        Accessory ryzen_5_5600g = new Accessory("medium", "processor");
        Accessory geforce_RTX_3060 = new Accessory("medium", "video_card");

        db.accessoryDao().insertAll(ryzen_5_5600g, geforce_RTX_3060);
        accessoryList = db.accessoryDao().getAllAccessory();
        ArrayList<String> displayAccessories = new ArrayList<>();
        for (Accessory item : accessoryList) {
            displayAccessories.add(item.type + " " + item.price);
        }
        for (Accessory list : accessoryList) {
            Log.d("Accessory", String.valueOf(accessoryList));
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.addAll(displayAccessories);

        spinnerAdapter.notifyDataSetChanged();


    }
}