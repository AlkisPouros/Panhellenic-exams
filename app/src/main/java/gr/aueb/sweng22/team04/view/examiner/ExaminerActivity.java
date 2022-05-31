package gr.aueb.sweng22.team04.view.examiner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Examiner;

public class ExaminerActivity extends AppCompatActivity implements ExaminerView {

    private ExaminerViewModel viewModel;
    private ExaminerPresenter presenter;
    private EditText edtCandidateFirstName;
    private EditText edtCandidateLastName;
    private TextView showCandidateFirstName;
    private TextView showCandidateLastName;
    private TextView showExaminerLesson;
    private EditText edtLessonMark;
    private TextView showMarkStatus;
    private Button btnSearchCandidateButton;
    private Button btnSaveMarkButton;
    private Candidate candidateResult;
    private Examiner examiner;
    private int ExaminerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examiner);

        viewModel = new ViewModelProvider(this).get(ExaminerViewModel.class);
        presenter = viewModel.getPresenter();
        presenter.setView(this);

        Bundle extras = getIntent().getExtras();
        ExaminerID = extras.getInt("examiner_id");

        edtCandidateFirstName = (EditText) findViewById(R.id.ExaminerEnterFirstName);
        edtCandidateLastName = (EditText) findViewById(R.id.ExaminerEnterLastName);
        showCandidateFirstName = (TextView) findViewById(R.id.showFirstNameCandidate);
        showCandidateLastName = (TextView) findViewById(R.id.showLastNameCandidate);
        showExaminerLesson = (TextView) findViewById(R.id.showExaminerLesson);
        edtLessonMark = (EditText) findViewById(R.id.enterMarkForCandidate);
        showMarkStatus = (TextView) findViewById(R.id.saveMarkStatus);
        btnSearchCandidateButton = (Button) findViewById(R.id.examinerSearchButton);
        btnSaveMarkButton = (Button) findViewById(R.id.saveMarkButton);

        btnSearchCandidateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findCandidate();
            }
        });

        btnSaveMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markCandidate();
            }
        });
    }

    private void findCandidate(){
        String firstName = edtCandidateFirstName.getText().toString();
        String lastName = edtCandidateLastName.getText().toString();

        candidateResult = viewModel.getPresenter().onFindCandidate(firstName, lastName);

        if(candidateResult != null){
            showCandidateFirstName.setText(candidateResult.getName());
            showCandidateLastName.setText(candidateResult.getLastName());
            examiner = viewModel.getPresenter().onFindExaminer(ExaminerID);
            if(examiner != null){
                showExaminerLesson.setText(examiner.getAcademicRole().getLessonName());
            }
        }
    }

    private void markCandidate(){
        String tempMark = edtLessonMark.getText().toString();

        if(tempMark != null){
            double mark = Double.parseDouble(tempMark);
            viewModel.getPresenter().onSaveMark(examiner, candidateResult, mark);
            edtLessonMark.getText().clear();
        }else{
            emptyMark();
        }
    }

    @Override
    public void showCandidateNotFound() {
        showCandidateFirstName.setText("Candidate not found");
    }

    @Override
    public void emptyField() {
        showCandidateFirstName.setText("Please fill all the fields");
    }

    @Override
    public void saveMarkStatus() {
        showMarkStatus.setText("Mark saved");
    }

    @Override
    public void emptyMark() {
        showMarkStatus.setText("Please fill the mark field");
    }

    @Override
    public void invalidMark() {
        showMarkStatus.setText("Invalid mark");
    }
}