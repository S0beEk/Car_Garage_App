package com.example.garage_car_app.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.garage_car_app.R;

public class CarDetailsActivity extends AppCompatActivity {

    TextView textBrand, textModel, textYear, textPlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        textBrand = findViewById(R.id.textBrand);
        textModel = findViewById(R.id.textModel);
        textYear = findViewById(R.id.textYear);
        textPlate = findViewById(R.id.textPlate);

        // Pobierz dane przekazane z listy
        String brand = getIntent().getStringExtra("brand");
        String model = getIntent().getStringExtra("model");
        int year = getIntent().getIntExtra("year", 0);
        String plate = getIntent().getStringExtra("plate");

        // Wyświetl dane
        textBrand.setText("Marka: " + brand);
        textModel.setText("Model: " + model);
        textYear.setText("Rok: " + year);
        textPlate.setText("Rejestracja: " + plate);
    }
}
