package gr.aueb.sweng22.team04.view.FindAvailableDepartments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.view.Adapter.DepartmentAdapter;


import java.util.ArrayList;
import java.util.List;


public class FindAvailableDepartmentsActivity extends AppCompatActivity implements FindAvailableDepartmentsView {


    FindAvailableDepartmentsPresenter presenter;
    FindAvailableDepartmentsViewModel viewmodel;



    private Button btnFindAvailDepartments;
    private TextView txtFindDeps;
    private RecyclerView recyclerView;




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_available_departments);
        viewmodel = new ViewModelProvider(this).get(FindAvailableDepartmentsViewModel.class);
        presenter = viewmodel.getPresenter();
        presenter.setView(this);

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();




        txtFindDeps = findViewById(R.id.ShowAvailableDepartments);
        btnFindAvailDepartments = findViewById(R.id.FindAvailableDepartments);

        recyclerView = findViewById(R.id.AvailableDepartmentsRecyclerView);
        //FindAvailableDepartments on click

        List<Department> departmentList = new ArrayList<>(viewmodel.getPresenter().onFindAvailableDepartments());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new DepartmentAdapter(departmentList));




    }


}


