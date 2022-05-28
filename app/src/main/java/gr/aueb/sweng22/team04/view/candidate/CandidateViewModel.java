package gr.aueb.sweng22.team04.view.candidate;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;

public class CandidateViewModel extends ViewModel {


    private CandidatePresenter presenter;

    public CandidateViewModel() {
        presenter = new CandidatePresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());

    }

    public CandidatePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("CandidateVM","On cleared");
    }

}
