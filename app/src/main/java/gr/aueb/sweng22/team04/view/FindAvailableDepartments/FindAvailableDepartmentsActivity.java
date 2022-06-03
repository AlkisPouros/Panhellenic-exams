package gr.aueb.sweng22.team04.view.FindAvailableDepartments;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;


public class FindAvailableDepartmentsActivity extends AppCompatActivity implements FindAvailableDepartmentsView {

    FindAvailableDepartmentsPresenter presenter;
    FindAvailableDepartmentsViewModel viewmodel;
    private Button btnFindAvailDepartments;
    private TextView txtFindDeps;
    private ListView ListAvailableDepartments;



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_available_departments);
        viewmodel = new ViewModelProvider(this).get(FindAvailableDepartmentsViewModel.class);
        presenter = viewmodel.getPresenter();
        presenter.setView(this);

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        txtFindDeps = findViewById(R.id.ShowAvailableDepartments);
        btnFindAvailDepartments = findViewById(R.id.FindAvailableDepartments);





    }
    @Override
    public void showAvailableDepartments()
    {

    }
}
