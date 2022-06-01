package gr.aueb.sweng22.team04.view.FindAvailableDepartment;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;

public class FindAvailableDepartmentViewModel extends ViewModel {

    FindAvailableDepartmentPresenter presenter;

    public FindAvailableDepartmentViewModel()
    {
        presenter = new FindAvailableDepartmentPresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setDepartmentDAO(new DepartmentDAOMemory());

    }
    public FindAvailableDepartmentPresenter getPresenter()
    {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("FindAvailableDepsVM","On cleared");
    }
}
