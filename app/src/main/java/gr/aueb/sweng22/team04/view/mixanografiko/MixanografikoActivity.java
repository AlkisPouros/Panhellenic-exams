package gr.aueb.sweng22.team04.view.mixanografiko;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;
import gr.aueb.sweng22.team04.view.Adapter.DepartmentAdapter;
import gr.aueb.sweng22.team04.view.Adapter.RegisteredDepartmentAdapter;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;
import gr.aueb.sweng22.team04.view.candidate.CandidateViewModel;

public class MixanografikoActivity extends AppCompatActivity implements MixanografikoView {

    MixanografikoPresenter presenter;
    CandidatePresenter candidatePresenter;

    private MixanografikoViewModel viewModel;

    private Button btnRegisterDepartments;
    private TextView txtRegisterDepartments;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mixanografiko);
        viewModel = new ViewModelProvider(this).get(MixanografikoViewModel.class);

        presenter = viewModel.getMixanografikoPresenter();
        presenter.setView(this);
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        Bundle extras = getIntent().getExtras();
        String Candidate_email = extras.getString("email");
        String Candidate_password = extras.getString("password");

        candidatePresenter.setEmail(Candidate_email);
        candidatePresenter.setPassword(Candidate_password);




        btnRegisterDepartments = findViewById(R.id.RegisterDepartments);
        txtRegisterDepartments = findViewById(R.id.txtRegisterDepartments);
        recyclerView = findViewById(R.id.recyclerView);
        //RegisterDepartments button on click

        List<RegisteredDepartment> departmentList = new ArrayList<>(viewModel.getMixanografikoPresenter().onRegisterDepartments());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new RegisteredDepartmentAdapter(departmentList));

    }



}





