package gr.aueb.sweng22.team04.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.model.Department;

public class FindAvailableDepartmentsAdapter extends RecyclerView.Adapter{

    private List<Department> dataSourceList;
    private Context context;

    public FindAvailableDepartmentsAdapter(List<Department> dataSourceList, Context context) {
        this.dataSourceList = dataSourceList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false);
        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Department currentItem = dataSourceList.get(position);
        ((DepartmentViewHolder) holder).bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return this.dataSourceList.size();
    }

    public class DepartmentViewHolder extends RecyclerView.ViewHolder {
        public TextView txtItemId; //final
        public TextView txtItemName; // final

        public DepartmentViewHolder(View view) {
            super(view);
            txtItemId = view.findViewById(R.id.txt_item_id);
            txtItemName = view.findViewById(R.id.txt_item_title);
        }

        void bind(Department department){
            txtItemId.setText(String.valueOf(department.getDepartmentID()));
            txtItemName.setText(String.valueOf(department.getDepartmentName()));
        }
    }
}
