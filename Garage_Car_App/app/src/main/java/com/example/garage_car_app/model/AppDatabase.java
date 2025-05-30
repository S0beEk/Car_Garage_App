package com.example.garage_car_app.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Car.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CarDao carDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "car_database")
                    .allowMainThreadQueries() // Tylko do testów, potem zamień na AsyncTask
                    .build();
        }
        return INSTANCE;
    }
}
