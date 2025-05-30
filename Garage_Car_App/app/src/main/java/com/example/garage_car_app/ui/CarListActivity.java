package com.example.garage_car_app.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.garage_car_app.R;
import com.example.garage_car_app.adapter.CarAdapter;
import com.example.garage_car_app.model.AppDatabase;
import com.example.garage_car_app.model.Car;
import com.example.garage_car_app.model.CarDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.room.Room;

import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);


        recyclerView = findViewById(R.id.recyclerViewCars);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicjalizacja bazy danych i DAO
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "car_database").allowMainThreadQueries().build();
        CarDao carDao = db.carDao();

        // Pobranie listy aut z bazy danych
        carList = carDao.getAllCars();

        // Ustawienie adaptera
        carAdapter = new CarAdapter(carList);
        recyclerView.setAdapter(carAdapter);

        // Obsługa przycisku "+"
        FloatingActionButton fab = findViewById(R.id.fabAddCar);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(CarListActivity.this, AddCarActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Odświeżenie listy po powrocie z AddCarActivity
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "car_database").allowMainThreadQueries().build();
        CarDao carDao = db.carDao();

        carList.clear();
        carList.addAll(carDao.getAllCars());
        carAdapter.notifyDataSetChanged();
    }
}
