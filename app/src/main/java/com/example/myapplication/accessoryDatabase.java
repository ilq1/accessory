package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {accessory.class},version = 1)
   public abstract class accessoryDatabase extends RoomDatabase {
    public abstract accessoryDao accessoryDao();


}
