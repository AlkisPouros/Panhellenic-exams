package gr.aueb.sweng22.team04.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.model.Department;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>{


    private List<Department> dataSourceList;


    public DepartmentAdapter(List<Department> dataSourceList) {

        this.dataSourceList = dataSourceList;
    }

    @NonNull
    @Override
    public DepartmentAdapter.DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DepartmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.AvailableDepartmentsRecyclerView, parent, false));


    }




    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.DepartmentViewHolder holder, int position) {
        final Department currentItem = dataSourceList.get(position);
        holder.txtItemId.setText(String.valueOf(currentItem.getDepartmentID()));
        holder.txtItemName.setText(String.valueOf(currentItem.getDepartmentName()));

    }

    @Override
    public int getItemCount() {
        return this.dataSourceList.size();
    }

    public class DepartmentViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtItemId; //final
        public TextView txtItemName; // final

        public DepartmentViewHolder(View itemView)
        {
            super(itemView);
            txtItemId = itemView.findViewById(R.id.DepartmentName);
            txtItemName = itemView.findViewById(R.id.DepartmentID);

        }



    }



}
