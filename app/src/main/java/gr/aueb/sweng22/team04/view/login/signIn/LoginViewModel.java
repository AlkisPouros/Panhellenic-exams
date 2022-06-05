package gr.aueb.sweng22.team04.view.login.signIn;

import android.util.Log;

import androidx.lifecycle.ViewModel;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * view model for login
 */

import gr.aueb.sweng22.team04.memorydao.UserDAOMemory;

public class LoginViewModel extends ViewModel {

    private LoginPresenter presenter;

    public LoginViewModel(){
        presenter = new LoginPresenter();
        presenter.setUserDAO(new UserDAOMemory());
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
