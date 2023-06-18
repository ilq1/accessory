package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccessoryDao {
    @Insert
    void insertAll (Accessory...accessories);
    @Query("SELECT * FROM Accessory")
    List<Accessory>getAllAccessory();
    @Query("SELECT * FROM Accessory WHERE type=:type AND price=:price")
    List<Accessory> getAccessoryByTypeAndPrice(String type, String price);


}
