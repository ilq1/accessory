package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Accessory {
  @PrimaryKey(autoGenerate = true)
    public int uid;

  @ColumnInfo(name = "price")
    public String price;
  @ColumnInfo(name = "type")
    public String type;
  @ColumnInfo(name = "title")
    public String title;

  public Accessory(String price, String type, String title){
      this.price = price;
      this.type = type;
      this.title = title;
  }


}
