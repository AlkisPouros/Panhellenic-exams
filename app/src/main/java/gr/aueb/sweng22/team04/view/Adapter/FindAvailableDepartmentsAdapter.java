package gr.aueb.sweng22.team04.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.model.Department;

public class FindAvailableDepartmentsAdapter extends RecyclerView.Adapter<FindAvailableDepartmentsAdapter.DepartmentViewHolder>{


    private List<Department> dataSourceList;


    public FindAvailableDepartmentsAdapter(List<Department> dataSourceList) {

        this.dataSourceList = dataSourceList;
    }

    @NonNull
    @Override
    public FindAvailableDepartmentsAdapter.DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DepartmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false));


    }




    @Override
    public void onBindViewHolder(@NonNull FindAvailableDepartmentsAdapter.DepartmentViewHolder holder, int position) {
        final Department currentItem = dataSourceList.get(position);
        holder.txtItemId.setText(String.valueOf(currentItem.getDepartmentID()));
        holder.txtItemName.setText(String.valueOf(currentItem.getDepartmentName()));

    }

    @Override
    public int getItemCount() {
        return this.dataSourceList.size();
    }

    public static class DepartmentViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtItemId; //final
        public TextView txtItemName; // final

        public DepartmentViewHolder(View view)
        {
            super(view);
            txtItemId = view.findViewById(R.id.DepartmentName);
            txtItemName = view.findViewById(R.id.DepartmentID);

        }



    }



}
