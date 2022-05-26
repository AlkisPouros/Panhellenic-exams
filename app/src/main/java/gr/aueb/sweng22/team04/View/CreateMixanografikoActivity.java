package gr.aueb.sweng22.team04.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.sweng22.team04.R;

public class CreateMixanografikoActivity extends AppCompatActivity implements CreateMixanografikoView{


    private CreateMixanografikoView view;
    private Button btnRegisterDepartments;
    //private TextView txtRegisterDepartments; we will see

    CreateMixanografikoPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        btnRegisterDepartments = findViewById(R.id.RegisterDepartments);
        btnRegisterDepartments.setOnClickListener(v-> presenter.onRegisterDepartments());


    }


}
