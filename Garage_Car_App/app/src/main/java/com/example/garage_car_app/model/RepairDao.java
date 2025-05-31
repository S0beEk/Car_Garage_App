// RepairDao.java
package com.example.garage_car_app.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RepairDao {
    @Query("SELECT * FROM Repair WHERE carId = :carId")
    List<Repair> getRepairsForCar(int carId);

    @Insert
    void insert(Repair repair);
}
