package gr.aueb.sweng22.team04.view.FindDepartment;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;

public class FindDepartmentViewModel extends ViewModel {

    private FindDepartmentPresenter presenter;

    public FindDepartmentViewModel() {
        presenter = new FindDepartmentPresenter();
        presenter.setDepartmentDAO(new DepartmentDAOMemory());
    }

    public FindDepartmentPresenter getPresenter() {
        return presenter;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("FindDepartmentVM","On cleared");
    }
}
