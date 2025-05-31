package com.example.garage_car_app.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.garage_car_app.R;
import com.example.garage_car_app.adapter.InspectionAdapter;
import com.example.garage_car_app.adapter.RepairAdapter;
import com.example.garage_car_app.model.AppDatabase;
import com.example.garage_car_app.model.Inspection;
import com.example.garage_car_app.model.Repair;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {

    TextView textBrand, textModel, textYear, textRegistration;
    RecyclerView recyclerRepairs, recyclerInspections;

    AppDatabase db;
    int carId;

    private RepairAdapter repairAdapter;
    private RecyclerView recyclerViewRepairs;
    private InspectionAdapter inspectionAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        textBrand = findViewById(R.id.textBrand);
        textModel = findViewById(R.id.textModel);
        textYear = findViewById(R.id.textYear);
        textRegistration = findViewById(R.id.textRegistration);

        recyclerRepairs = findViewById(R.id.recyclerRepairs);
        recyclerInspections = findViewById(R.id.recyclerInspections);



        recyclerRepairs.setLayoutManager(new LinearLayoutManager(this));
        recyclerInspections.setLayoutManager(new LinearLayoutManager(this));

        // Pobierz dane auta z Intentu
        carId = getIntent().getIntExtra("carId", -1);
        String brand = getIntent().getStringExtra("brand");
        String model = getIntent().getStringExtra("model");
        int year = getIntent().getIntExtra("year", 0);
        String registration = getIntent().getStringExtra("registration");

        textBrand.setText("Marka: " + brand);
        textModel.setText("Model: " + model);
        textYear.setText("Rok: " + year);
        textRegistration.setText("Rejestracja: " + registration);

        db = AppDatabase.getInstance(this);

        // Pobierz listę napraw i przeglądów z bazy wg carId
        List<Repair> repairs = db.repairDao().getRepairsForCar(carId);
        List<Inspection> inspections = db.inspectionDao().getInspectionsForCar(carId);

        repairAdapter = new RepairAdapter(repairs);
        recyclerRepairs.setAdapter(repairAdapter);

        inspectionAdapter = new InspectionAdapter(inspections);
        recyclerInspections.setAdapter(inspectionAdapter);
    }
}
