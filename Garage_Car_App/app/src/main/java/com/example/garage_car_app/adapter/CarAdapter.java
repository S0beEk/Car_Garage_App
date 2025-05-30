package com.example.garage_car_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_car_app.R;
import com.example.garage_car_app.model.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;

    public CarAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.textViewBrand.setText(car.getBrand());
        holder.textViewModel.setText(car.getModel());
        holder.textViewYear.setText(String.valueOf(car.getYear()));
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBrand, textViewModel, textViewYear;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            textViewYear = itemView.findViewById(R.id.textViewYear);
        }
    }
}
