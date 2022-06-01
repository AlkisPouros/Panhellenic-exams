package gr.aueb.sweng22.team04.view.login.signUp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.ScientificFieldDAOMemory;
import gr.aueb.sweng22.team04.memorydao.UserDAOMemory;

public class SignUpViewModel extends ViewModel {

    private SignUpPresenter presenter;

    public SignUpViewModel(){
        presenter = new SignUpPresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setScientificFieldDAO(new ScientificFieldDAOMemory());
        presenter.setUserDAO(new UserDAOMemory());
    }

    public SignUpPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.d("SignUpVM", "On cleared");
    }
}
