package gr.aueb.sweng22.team04.View.login.signIn;

import gr.aueb.sweng22.team04.view.login.signIn.LoginView;

public class LoginViewStub implements LoginView {

    private int errorCount;
    private Boolean status = true;

    @Override
    public void EmptyField() {
        errorCount++;
        status = false;
    }

    @Override
    public void showFailedLogin() {
        errorCount++;
        status = false;
    }

    @Override
    public void showInvalidEmail() {
        errorCount++;
        status = false;
    }

    @Override
    public void showInvalidPassword() {
        errorCount++;
        status = false;
    }

    public int getErrorCount(){
        return errorCount;
    }

    public boolean getStatus(){
        return status;
    }
}
