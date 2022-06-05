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
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public class RegisteredDepartmentAdapter extends RecyclerView.Adapter{

    private List<RegisteredDepartment> dataSourceList;
    private Context context;

    public RegisteredDepartmentAdapter(List<RegisteredDepartment> dataSourceList, Context context) {
        this.dataSourceList = dataSourceList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false);
        return new RegisteredDepartmentViewHolder(view);
        //return new RegisteredDepartmentAdapter.RegisteredDepartmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_create_mixanografiko, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final RegisteredDepartment currentItem = dataSourceList.get(position);
        ((RegisteredDepartmentViewHolder) holder).bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return this.dataSourceList.size();
    }

    public class RegisteredDepartmentViewHolder extends RecyclerView.ViewHolder {
        public TextView txtItemId; //final
        public TextView txtItemName; // final

        public RegisteredDepartmentViewHolder(View itemView) {
            super(itemView);
            txtItemId = itemView.findViewById(R.id.txt_item_id);
            txtItemName = itemView.findViewById(R.id.txt_item_title);
        }

        void bind(RegisteredDepartment registeredDepartment){
            txtItemId.setText(String.valueOf(registeredDepartment.getDepartment().getDepartmentID()));
            txtItemName.setText(String.valueOf(registeredDepartment.getDepartment().getDepartmentName()));
        }
    }
}
