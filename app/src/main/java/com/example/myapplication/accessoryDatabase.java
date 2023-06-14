package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Accessory.class},version = 1)
   public abstract class accessoryDatabase extends RoomDatabase {
    public abstract AccessoryDao accessoryDao();


}
