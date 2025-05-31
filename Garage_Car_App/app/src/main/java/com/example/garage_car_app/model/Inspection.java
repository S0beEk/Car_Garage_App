package com.example.garage_car_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity
public class Inspection {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int carId; // pole musi mieć getter i setter z taką nazwą

    private String type;

    private String date;

    // publiczny konstruktor bez argumentów
    public Inspection() {}

    // opcjonalnie: konstruktor z parametrami (upewnij się, że nazwy argumentów pasują do nazw pól)
    public Inspection(int carId, String type, String date) {
        this.carId = carId;
        this.type = type;
        this.date = date;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
