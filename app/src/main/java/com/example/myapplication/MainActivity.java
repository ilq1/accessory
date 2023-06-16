package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    private android.widget.Spinner Spinner;
    private List<Accessory> accessoryList;
    private String accessory;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();
        Accessory Null = new Accessory("q" , "null" , "Процессор");
        Accessory ryzen_3_1200 = new Accessory("low", "processor","Ryzen 3 1200");
        Accessory ryzen_5_5600 = new Accessory("medium" , "processor", "Ryzen 5 5600");
        Accessory ryzen_9_5900X = new Accessory("high" , "processor", "Ryzen 9 5900X");

        db.accessoryDao().insertAll(Null,ryzen_3_1200,ryzen_5_5600,ryzen_9_5900X);
        accessoryList = db.accessoryDao().getAllAccessory();
        ArrayList<String> displayAccessories = new ArrayList<>();
        for (Accessory item : accessoryList) {
            displayAccessories.add(item.title);
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
        spinner.setOnItemSelectedListener(onItemSelectedListener());

    }
    AdapterView.OnItemSelectedListener onItemSelectedListener(){
        return new AdapterView.OnItemSelectedListener() {
            public void onClick(View v) {


            }
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (accessoryList.get(position).price.equals("low")) {
                    Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent2);
                }
                if (accessoryList.get(position).price.equals("medium")) {
                    Intent intent1 = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent1);
                }

                if (accessoryList.get(position).price.equals("high")){
                    Intent intent3 = new Intent(MainActivity.this, MainActivity4.class);
                    startActivity(intent3);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };}}

