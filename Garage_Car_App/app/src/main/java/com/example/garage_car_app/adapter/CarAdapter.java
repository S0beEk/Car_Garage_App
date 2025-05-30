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

    private List<Car> cars;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    public CarAdapter(List<Car> cars, OnItemClickListener listener) {
        this.cars = cars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.textViewCarName.setText(car.getFullName());
        holder.textViewCarYear.setText(String.valueOf(car.getYear()));

        holder.itemView.setOnClickListener(v -> {
            if(listener != null) {
                listener.onItemClick(car);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCarName, textViewCarYear;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCarName = itemView.findViewById(R.id.textViewCarName);
            textViewCarYear = itemView.findViewById(R.id.textViewCarYear);
        }
    }
}
