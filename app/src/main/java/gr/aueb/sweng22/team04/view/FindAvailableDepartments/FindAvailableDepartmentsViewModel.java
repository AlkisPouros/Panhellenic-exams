package gr.aueb.sweng22.team04.view.FindAvailableDepartments;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;

public class FindAvailableDepartmentsViewModel extends ViewModel {

    FindAvailableDepartmentsPresenter presenter;

    public FindAvailableDepartmentsViewModel()
    {
        presenter = new FindAvailableDepartmentsPresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setDepartmentDAO(new DepartmentDAOMemory());

    }
    public FindAvailableDepartmentsPresenter getPresenter()
    {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("FindAvailableDepsVM","On cleared");
    }
}
