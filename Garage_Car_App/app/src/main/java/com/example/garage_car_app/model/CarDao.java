package com.example.garage_car_app.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarDao {

    @Insert
    void insert(Car car);  // ← poprawna wersja

    @Query("SELECT * FROM Car")
    List<Car> getAllCars();

    @Delete
    void deleteCar(Car car); // <- DODAJ TO
}
