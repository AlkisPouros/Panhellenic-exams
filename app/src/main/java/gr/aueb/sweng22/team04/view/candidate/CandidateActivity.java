package gr.aueb.sweng22.team04.view.candidate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.view.FindAvailableDepartment.FindAvailableDepartmentsActivity;
import gr.aueb.sweng22.team04.view.FindDepartment.FindDepartmentActivity;
import gr.aueb.sweng22.team04.view.mixanografiko.MixanografikoActivity;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;

public class CandidateActivity extends AppCompatActivity implements CandidateView {

    CandidatePresenter candidatePresenter;
    private Button btnCalculateMarks;
    private Button btnCreateMixanografiko;
    private Button btnFindDepartment;
    private Button btnFindAvailableDepartments;
    private TextView txtCandidateMark;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        CandidateViewModel viewModel = new ViewModelProvider(this).get(CandidateViewModel.class);
        candidatePresenter = viewModel.getPresenter();
        candidatePresenter.setView(this);

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        Bundle extras = getIntent().getExtras();
        String Candidate_email = extras.getString("email");
        String Candidate_password = extras.getString("password");

        candidatePresenter.setEmail(Candidate_email);
        candidatePresenter.setPassword(Candidate_password);



        btnCalculateMarks = findViewById(R.id.CalculateMarks);
        txtCandidateMark = findViewById(R.id.CandidateMark);
        btnCreateMixanografiko = findViewById(R.id.CreateMixanografiko);
        btnFindDepartment = findViewById(R.id.FindDepartment);
        btnFindAvailableDepartments = findViewById(R.id.FindAvailableDepartments);



        btnCalculateMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCandidateMark();
            }
        });
        btnCreateMixanografiko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMixanografiko();
            }
        });

        btnFindDepartment.setOnClickListener(v->FindDepartment());
        btnFindAvailableDepartments.setOnClickListener(v->FindAvailableDepartments());
    }

    @Override
    public void showCandidateMark()
    {

        txtCandidateMark.setText("Τα συνολικά μόρια είναι: " + String.valueOf(candidatePresenter.onCalculateMarks()));

    }

    private void createMixanografiko()
    {
        startActivity(new Intent(CandidateActivity.this, MixanografikoActivity.class));
    }
    private void FindDepartment()
    {
        startActivity(new Intent(CandidateActivity.this, FindDepartmentActivity.class));
    }
    private void FindAvailableDepartments()
    {
        startActivity(new Intent(CandidateActivity.this, FindAvailableDepartmentsActivity.class));
    }




}
