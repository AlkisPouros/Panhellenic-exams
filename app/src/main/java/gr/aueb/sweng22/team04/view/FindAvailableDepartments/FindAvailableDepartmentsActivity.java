package gr.aueb.sweng22.team04.view.FindAvailableDepartments;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.view.Adapter.FindAvailableDepartmentsAdapter;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;
import gr.aueb.sweng22.team04.view.candidate.CandidateViewModel;


import java.util.ArrayList;
import java.util.List;


public class FindAvailableDepartmentsActivity extends AppCompatActivity implements FindAvailableDepartmentsView {


    FindAvailableDepartmentsPresenter presenter;
    FindAvailableDepartmentsViewModel viewmodel;

    CandidatePresenter candidatePresenter;


    private Button btnFindAvailDepartments;
    private TextView txtFindDeps;
    private RecyclerView recyclerView;




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_available_departments);
        viewmodel = new ViewModelProvider(this).get(FindAvailableDepartmentsViewModel.class);
        CandidateViewModel candidateViewModel = new CandidateViewModel();
        presenter = viewmodel.getPresenter();
        presenter.setView(this);
        candidatePresenter = candidateViewModel.getPresenter();

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        Bundle extras = getIntent().getExtras();
        String candidateEmail = extras.getString("email");
        String candidatePassword = extras.getString("password");



        candidatePresenter.setEmail(candidateEmail);
        candidatePresenter.setPassword(candidatePassword);

        presenter.setEmail(candidateEmail);
        presenter.setPassword(candidatePassword);


        txtFindDeps = findViewById(R.id.ShowAvailableDepartments);
        btnFindAvailDepartments = findViewById(R.id.FindAvailableDepartments);

        recyclerView = findViewById(R.id.AvailableDepartmentsRecyclerView);
        //FindAvailableDepartments on click

        List<Department> departmentList = new ArrayList<>(viewmodel.getPresenter().onFindAvailableDepartments());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new FindAvailableDepartmentsAdapter(departmentList));




    }


}


