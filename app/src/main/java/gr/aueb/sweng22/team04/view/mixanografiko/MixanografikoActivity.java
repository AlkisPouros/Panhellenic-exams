package gr.aueb.sweng22.team04.view.mixanografiko;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.sweng22.team04.R;

public class MixanografikoActivity extends AppCompatActivity implements MixanografikoView {


    private MixanografikoView view;
    private Button btnRegisterDepartments;
    //private TextView txtRegisterDepartments; we will see

    MixanografikoPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        btnRegisterDepartments = findViewById(R.id.RegisterDepartments);
        btnRegisterDepartments.setOnClickListener(v-> presenter.onRegisterDepartments());


    }


}
