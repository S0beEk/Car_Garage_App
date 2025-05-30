package com.example.garage_car_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.garage_car_app.R;
import com.example.garage_car_app.model.AppDatabase;
import com.example.garage_car_app.model.Car;

public class AddCarActivity extends AppCompatActivity {

    private EditText editTextBrand, editTextModel, editTextYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        editTextBrand = findViewById(R.id.editTextBrand);
        editTextModel = findViewById(R.id.editTextModel);
        editTextYear = findViewById(R.id.editTextYear);
        Button buttonSaveCar = findViewById(R.id.buttonSaveCar);

        buttonSaveCar.setOnClickListener(v -> {
            String brand = editTextBrand.getText().toString();
            String model = editTextModel.getText().toString();
            String yearStr = editTextYear.getText().toString();

            if (brand.isEmpty() || model.isEmpty() || yearStr.isEmpty()) {
                Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                return;
            }

            int year = Integer.parseInt(yearStr);

            // Zapisz do bazy danych
            AppDatabase db = AppDatabase.getInstance(getApplicationContext());
            Car car = new Car(brand, model, year);
            db.carDao().insert(car);

            Toast.makeText(this, "Dodano auto!", Toast.LENGTH_SHORT).show();
            finish(); // wróć do listy
        });

    }
}
