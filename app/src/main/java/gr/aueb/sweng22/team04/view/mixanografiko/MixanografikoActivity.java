package gr.aueb.sweng22.team04.view.mixanografiko;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;
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
        CandidateViewModel candidateViewModel = new CandidateViewModel();
        presenter = viewModel.getMixanografikoPresenter();
        presenter.setView(this);
        candidatePresenter = candidateViewModel.getPresenter();

        //Initializer initializer = new MemoryInitializer();
        //initializer.prepareData();

        Bundle extras = getIntent().getExtras();
        String candidateEmail = extras.getString("email");
        String candidatePassword = extras.getString("password");


        candidatePresenter.setEmail(candidateEmail);
        candidatePresenter.setPassword(candidatePassword);

        presenter.setEmail(candidateEmail);
        presenter.setPassword(candidatePassword);

        btnRegisterDepartments = (Button) findViewById(R.id.RegisterDepartments);
        txtRegisterDepartments =  findViewById(R.id.txtRegisterDepartments);

        List<RegisteredDepartment> departmentList = new ArrayList<>();
        departmentList.addAll(presenter.onRegisterDepartments());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //RegisterDepartments button on click
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RegisteredDepartmentAdapter adapter = new RegisteredDepartmentAdapter(departmentList, this);
        recyclerView.setAdapter(adapter);
    }
}





