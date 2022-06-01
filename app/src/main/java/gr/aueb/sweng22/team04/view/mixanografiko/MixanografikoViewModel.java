package gr.aueb.sweng22.team04.view.mixanografiko;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MixanografikoDAOMemory;
import gr.aueb.sweng22.team04.memorydao.RegisteredDepartmentDAOMemory;

public class MixanografikoViewModel extends ViewModel {

    private MixanografikoPresenter mixanografikoPresenter;

    public MixanografikoViewModel()
    {
        mixanografikoPresenter = new MixanografikoPresenter();
        mixanografikoPresenter.setMixanografikoDAO(new MixanografikoDAOMemory());
        mixanografikoPresenter.setCandidateDAO(new CandidateDAOMemory());
        mixanografikoPresenter.setRegisteredDepartmentDAO(new RegisteredDepartmentDAOMemory());
        mixanografikoPresenter.setDepartmentDAO(new DepartmentDAOMemory());

    }

    public MixanografikoPresenter getMixanografikoPresenter(){return mixanografikoPresenter;}

    @Override
    public void onCleared()
    {
        super.onCleared();
        Log.d("MixanografikoVM","On cleared");
    }

}
