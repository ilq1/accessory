package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class accessory {
  @PrimaryKey(autoGenerate = true)
    public int uid;

  @ColumnInfo(name = "price")
    public String price;
  @ColumnInfo(name = "type")
    public String type;

  public accessory(String price, String type){
      this.price = price;
      this.type = type;
  }


}
