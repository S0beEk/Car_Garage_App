// InspectionDao.java
package com.example.garage_car_app.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InspectionDao {
    @Query("SELECT * FROM Inspection WHERE carId = :carId")
    List<Inspection> getInspectionsForCar(int carId);

    @Insert
    void insert(Inspection inspection);
}
