package com.example.garage_car_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Repair {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int carId;
    public String description;
    public String date; // możesz dać Date i konwerter, albo String dla uproszczenia
}
