package gr.aueb.sweng22.team04.view.examiner;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.ExaminerDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;
import gr.aueb.sweng22.team04.memorydao.ScientificFieldDAOMemory;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * viewmodel for examiner
 */

public class ExaminerViewModel extends ViewModel {

    private ExaminerPresenter presenter;

    public ExaminerViewModel(){
        presenter = new ExaminerPresenter();
        presenter.setExaminerDAO(new ExaminerDAOMemory());
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());
        presenter.setScientificFieldDAO(new ScientificFieldDAOMemory());
    }

    public ExaminerPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.d("ExaminerVM", "On cleared");
    }
}
