package com.example.myapplication;


import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    private android.widget.Spinner Spinner;
    public ArrayList<String> displayAccessories;
    public List<Accessory> accessoryList;
    private String accessory;
    Spinner spinner;



    private void updateSpinnerData() {
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();
        accessoryList = db.accessoryDao().getAccessoryByType("processor");
        ArrayList<String> displayAccessories = new ArrayList<>();
        displayAccessories.add("Процессор");

        for (Accessory item : accessoryList) {
            displayAccessories.add(item.title);
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.clear();
        spinnerAdapter.addAll(displayAccessories);
        spinnerAdapter.notifyDataSetChanged();
    }
    private void initializationDb(){
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();
        Accessory ryzen_3_1200 = new Accessory("low", "processor","Ryzen 3 1200");
        Accessory ryzen_5_5600 = new Accessory("medium" , "processor", "Ryzen 5 5600");
        Accessory ryzen_9_5900X = new Accessory("high" , "processor", "Ryzen 9 5900X");
        Accessory RTX_2060 = new Accessory("medium", "video_card", "palit RTX 3060 Dual");
        Accessory gtx_1050ti = new Accessory("low", "video_card", "gtx 1050ti");
        Accessory RTX_4070ti = new Accessory("high", "video_card", "msi RTX 4070ti");
        Accessory b450m_h = new Accessory("low", "motherboard","gigabyte b450m h" );
        Accessory b550_aorus_v2 = new Accessory("medium", "motherboard","gigabyte b550 aorus v2");
        Accessory b650_aorus_elite= new Accessory("high", "motherboard", "gigabyte b650 aorus elite ax" );
        Accessory cougar_vte_600 = new Accessory("medium", "power_unit", "cougar vte 600");
        Accessory aerocool_eco = new Accessory("low", "power_unit", "aerocool eco 450W");
        Accessory deepcool_dq450 =new Accessory("high", "power_unit", "deepcool dq450");
        Accessory basetech_m3303 = new Accessory("low", "frame","basetech m3303");
        Accessory powerman_ps_201 = new Accessory("medium", "frame", "powerman ps 201");
        Accessory cougar_mx330_f = new Accessory("high","frame", "cougar mx330-f" );
        Accessory toshiba_dt_01 = new Accessory("low", "disk", "toshiba dt01 1tb");
        Accessory wd_blue = new Accessory("medium", "disk", "wd blue 1 tb");
        Accessory wd_purple_surveillance = new Accessory("high","disk", "wd purple surveillance");
        Accessory kingston_fury_beast_black_8gbx2= new Accessory("medium", "ram", "kingston fury beast black 8gbx2");
        Accessory kingston_fury_beast_black_4gbx2 = new Accessory("low", "ram", "kingston fury beast black 4gbx2");
        Accessory kingston_fury_beast_black_16gbx2 = new Accessory("high","ram","kingston fury beast black 16gbx2");
        Accessory be_quiet = new Accessory("high", "cooler", "be_quiet dark rock pro 4");
        Accessory deepcool_gammax_300 = new Accessory("low","cooler", "deepcool gammax 300");
        Accessory deepcool_gammax_400ex = new Accessory("medium", "cooler","deepcool gammax 400ex");
        if (db.accessoryDao().getAccessoryCount() == 0) {
            db.accessoryDao().insertAll (ryzen_3_1200,ryzen_5_5600 ,ryzen_9_5900X ,RTX_2060 ,gtx_1050ti ,RTX_4070ti , b450m_h,b550_aorus_v2
                    ,b650_aorus_elite,cougar_vte_600 ,aerocool_eco ,deepcool_dq450 ,basetech_m3303, powerman_ps_201,cougar_mx330_f ,toshiba_dt_01 ,
                    wd_blue,wd_purple_surveillance ,kingston_fury_beast_black_8gbx2 ,kingston_fury_beast_black_4gbx2, kingston_fury_beast_black_16gbx2,
                    be_quiet,deepcool_gammax_300,deepcool_gammax_400ex);
        }

    }



    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        
        accessoryDatabase db = Room.databaseBuilder(getApplicationContext(), accessoryDatabase.class, "Accessory-db").allowMainThreadQueries().build();

        initializationDb();

        accessoryList = db.accessoryDao().getAccessoryByType("processor");
        ArrayList<String> displayAccessories = new ArrayList<>();
        displayAccessories.add("Процессор");
        for (Accessory item : accessoryList) {
            displayAccessories.add(item.title);
        }
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.addAll(displayAccessories);
        spinnerAdapter.notifyDataSetChanged();
        spinner.setOnItemSelectedListener(onItemSelectedListener());


    }

    AdapterView.OnItemSelectedListener onItemSelectedListener(){
        return new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) return;
                
                if (accessoryList.get(position - 1).price.equals("low")) {
                    Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle a = new Bundle();
                    a.putString("price", "low");
                    intent1.putExtras(a);
                    startActivity(intent1);


                }
                if (accessoryList.get(position-1).price.equals("medium")) {
                    Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle b = new Bundle();
                    b.putString("price", "medium");
                    intent2.putExtras(b);
                    startActivity(intent2);



                }

                if (accessoryList.get(position-1 ).price.equals("high")){
                    Intent intent3 = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle c = new Bundle();
                    c.putString("price", "high");
                    intent3.putExtras(c);
                    startActivity(intent3);
                    
                }
                Spinner.setSelection(0);




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };}












}


