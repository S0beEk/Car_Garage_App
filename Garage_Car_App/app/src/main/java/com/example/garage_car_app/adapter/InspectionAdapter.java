package com.example.garage_car_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_car_app.R;
import com.example.garage_car_app.model.Inspection;

import java.util.List;

public class InspectionAdapter extends RecyclerView.Adapter<InspectionAdapter.InspectionViewHolder> {

    private List<Inspection> inspections;

    public InspectionAdapter(List<Inspection> inspections) {
        this.inspections = inspections;
    }

    @NonNull
    @Override
    public InspectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inspection, parent, false);
        return new InspectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InspectionViewHolder holder, int position) {
        Inspection inspection = inspections.get(position);
        holder.textInspectionType.setText(inspection.getType());
        holder.textInspectionDate.setText(inspection.getDate());
    }

    @Override
    public int getItemCount() {
        return inspections.size();
    }

    static class InspectionViewHolder extends RecyclerView.ViewHolder {
        TextView textInspectionType, textInspectionDate;

        public InspectionViewHolder(@NonNull View itemView) {
            super(itemView);
            textInspectionType = itemView.findViewById(R.id.textInspectionType);
            textInspectionDate = itemView.findViewById(R.id.textInspectionDate);
        }
    }
}
