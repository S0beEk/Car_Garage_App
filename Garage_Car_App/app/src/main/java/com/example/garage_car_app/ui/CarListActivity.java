package com.example.garage_car_app.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_car_app.R;
import com.example.garage_car_app.adapter.CarAdapter;
import com.example.garage_car_app.model.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCars;
    private CarAdapter carAdapter;
    private List<Car> carList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        recyclerViewCars = findViewById(R.id.recyclerViewCars);
        FloatingActionButton fabAddCar = findViewById(R.id.fabAddCar);

        // Przykładowe dane
        carList = new ArrayList<>();
        carList.add(new Car(1, "Toyota", "Corolla", 2018));
        carList.add(new Car(2, "Ford", "Focus", 2016));
        carList.add(new Car(3, "BMW", "320i", 2020));

        carAdapter = new CarAdapter(carList, car -> {
            // Tu kliknięcie na samochód
        });

        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setAdapter(carAdapter);

        fabAddCar.setOnClickListener(v -> {
            // Tu dodamy akcję dodawania auta
        });
    }
}
