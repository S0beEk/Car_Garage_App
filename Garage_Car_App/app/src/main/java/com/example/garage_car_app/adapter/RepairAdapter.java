// RepairAdapter.java
package com.example.garage_car_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.garage_car_app.R;
import com.example.garage_car_app.model.Repair;
import java.util.List;

public class RepairAdapter extends RecyclerView.Adapter<RepairAdapter.ViewHolder> {

    private List<Repair> repairs;

    public RepairAdapter(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @NonNull
    @Override
    public RepairAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repair, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepairAdapter.ViewHolder holder, int position) {
        Repair repair = repairs.get(position);
        holder.textDescription.setText(repair.description);
        holder.textDate.setText(repair.date);
    }

    @Override
    public int getItemCount() {
        return repairs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textDescription, textDate;

        ViewHolder(View itemView) {
            super(itemView);
            textDescription = itemView.findViewById(R.id.textRepairDescription);
            textDate = itemView.findViewById(R.id.textRepairDate);
        }
    }
}
