package gr.aueb.sweng22.team04.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Mixanografiko;

public class CandidateActivity extends AppCompatActivity implements CandidateView{

    CandidatePresenter candidatePresenter;
    private Button btnCalculateMarks;
    private Button btnFindAvailableDepartments;
    private Button btnCreateMixanografiko;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);


        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        candidatePresenter = new CandidatePresenter(this, initializer.getCandidateDAO(), initializer.getMarkedLessonDAO(), initializer.getLessonDAO(),initializer.getDepartmentDAO(),initializer.getMixanografikoDAO());



        btnCalculateMarks = findViewById(R.id.CalculateMarks);
        btnFindAvailableDepartments = findViewById(R.id.FindAvailableDepartments);
        btnCreateMixanografiko = findViewById(R.id.CreateMixanografiko);

        btnCalculateMarks.setOnClickListener(v->candidatePresenter.onCalculateMarks());
        btnFindAvailableDepartments.setOnClickListener(v->candidatePresenter.onFindAvailableDepartments());
        btnCreateMixanografiko.setOnClickListener(v->CreateMixanografiko());

    }
    private void CreateMixanografiko()
    {
        startActivity(new Intent(CandidateActivity.this,CreateMixanografikoActivity.class));
    }



}
