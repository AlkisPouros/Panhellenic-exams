package gr.aueb.sweng22.team04.view.login.signIn;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.model.Candidate;

public class LoginPresenter {

    private LoginView view;
    private CandidateDAO candidateDAO;

    public LoginPresenter(LoginView view, CandidateDAO candidateDAO){
        this.view = view;
        this.candidateDAO = candidateDAO;
    }

    void onLogin(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            view.EmptyField();
            return;
        }

        if(!email.contains("@")){
            view.showInvalidEmail();
        }

        Candidate candidate = candidateDAO.findCandidate(email, password);

        if(candidate == null){
            System.out.println("Here");
            view.showFailedLogin();
        }
    }
}
