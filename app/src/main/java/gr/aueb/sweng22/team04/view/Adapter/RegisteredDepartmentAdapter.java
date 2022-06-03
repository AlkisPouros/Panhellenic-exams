package gr.aueb.sweng22.team04.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public class RegisteredDepartmentAdapter extends RecyclerView.Adapter<RegisteredDepartmentAdapter.RegisteredDepartmentViewHolder>{

    private List<RegisteredDepartment> dataSourceList;


    public RegisteredDepartmentAdapter(List<RegisteredDepartment> dataSourceList) {

        this.dataSourceList = dataSourceList;
    }

    @NotNull
    @Override
    public RegisteredDepartmentAdapter.RegisteredDepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DepartmentAdapter.DepartmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.RegisteredDepartmentsRecyclerView, parent, false));


    }
    @Override
    public void onBindViewHolder(@NonNull RegisteredDepartmentAdapter.RegisteredDepartmentViewHolder holder, int position) {
        final RegisteredDepartment currentItem = dataSourceList.get(position);
        holder.txtItemId.setText(String.valueOf(currentItem.getDepartment().getDepartmentID()));
        holder.txtItemName.setText(String.valueOf(currentItem.getDepartment().getDepartmentName()));

    }
    @Override
    public int getItemCount() {
        return this.dataSourceList.size();
    }

    public class RegisteredDepartmentViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtItemId; //final
        public TextView txtItemName; // final

        public RegisteredDepartmentViewHolder(View itemView)
        {
            super(itemView);
            txtItemId = itemView.findViewById(R.id.RegisteredDepartmentID);
            txtItemName = itemView.findViewById(R.id.RegisteredDepartmentName);

        }



    }

}
