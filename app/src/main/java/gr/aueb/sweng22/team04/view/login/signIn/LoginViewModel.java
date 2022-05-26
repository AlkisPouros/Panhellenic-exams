package gr.aueb.sweng22.team04.view.login.signIn;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;

public class LoginViewModel extends ViewModel {

    private LoginPresenter presenter;

    public LoginViewModel(){
        presenter = new LoginPresenter();
        presenter.setCandidateDAO(new CandidateDAOMemory());
    }

    public LoginPresenter getPresenter(){
        return  this.presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.d("LoginVM", "On cleared");
    }
}
