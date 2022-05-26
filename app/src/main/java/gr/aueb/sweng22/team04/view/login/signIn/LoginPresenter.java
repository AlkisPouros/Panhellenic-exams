package gr.aueb.sweng22.team04.view.login.signIn;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.model.Candidate;

public class LoginPresenter {

    private LoginView view;
    private CandidateDAO candidateDAO;

    public LoginView getView(){
        return this.view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public Boolean onLogin(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            view.EmptyField();
            return false;
        }

        if(!email.contains("@")){
            view.showInvalidEmail();
            return false;
        }

        if(password.length() < 7){
            view.showInvalidPassword();
            return false;
        }

        Candidate candidate = candidateDAO.findCandidate(email, password);

        if(candidate == null){
            view.showFailedLogin();
            return false;
        }else{
            return true;
        }
    }
}
