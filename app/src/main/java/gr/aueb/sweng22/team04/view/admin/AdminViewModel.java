package gr.aueb.sweng22.team04.view.admin;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MixanografikoDAOMemory;
import gr.aueb.sweng22.team04.memorydao.RegisteredDepartmentDAOMemory;
import gr.aueb.sweng22.team04.view.admin.AdminPresenter;

public class AdminViewModel extends ViewModel {
    private AdminPresenter presenter;

    public AdminViewModel() {
        presenter = new AdminPresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setMixanografikoDAO(new MixanografikoDAOMemory());
        presenter.setRegisteredDepartmentDAO(new RegisteredDepartmentDAOMemory());
    }

    public AdminPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("AdminVM","On cleared");
    }
}
