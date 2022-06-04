package gr.aueb.sweng22.team04.view.admin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;

public class AdminActivity extends AppCompatActivity implements AdminView {

    AdminPresenter presenter;
    AdminViewModel viewModel;
    private Button btnCalcRes;
    private TextView txtRes;



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        viewModel = new ViewModelProvider(this).get(AdminViewModel.class);
        presenter = viewModel.getPresenter();
        presenter.setView(this);

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        txtRes = findViewById(R.id.Results);
        btnCalcRes = findViewById(R.id.CalculateResults);

        btnCalcRes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showResults();
            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showResults() {
            viewModel.getPresenter().onCalculateResults();
        }
}

