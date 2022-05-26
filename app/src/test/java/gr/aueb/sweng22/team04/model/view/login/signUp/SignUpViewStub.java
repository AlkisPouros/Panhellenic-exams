package gr.aueb.sweng22.team04.model.view.login.signUp;

import gr.aueb.sweng22.team04.view.login.signUp.SignUpView;

public class SignUpViewStub implements SignUpView {

    private int errorCount;
    private Boolean status = true;
    @Override
    public void emptyField() {
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

    @Override
    public void showInvalidPoliceID() {
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
