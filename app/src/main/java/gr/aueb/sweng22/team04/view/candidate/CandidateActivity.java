package gr.aueb.sweng22.team04.view.candidate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.view.mixanografiko.MixanografikoActivity;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;

public class CandidateActivity extends AppCompatActivity implements CandidateView {

    CandidatePresenter candidatePresenter;
    private Button btnCalculateMarks;
    private Button btnCreateMixanografiko;
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

        btnCalculateMarks.setOnClickListener(v->showCandidateMark());
        btnCreateMixanografiko.setOnClickListener(v->CreateMixanografiko());

    }

    @Override
    public void showCandidateMark()
    {

        txtCandidateMark.setText(String.valueOf(candidatePresenter.onCalculateMarks()));
    }

    private void CreateMixanografiko()
    {
        startActivity(new Intent(CandidateActivity.this, MixanografikoActivity.class));
    }




}
