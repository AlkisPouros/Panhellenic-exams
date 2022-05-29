package gr.aueb.sweng22.team04.view.login.signIn;

import gr.aueb.sweng22.team04.dao.UserDAO;
import gr.aueb.sweng22.team04.model.User;

public class LoginPresenter {

    private LoginView view;
    private UserDAO userDAO;

    public LoginView getView(){
        return this.view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User onLogin(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            view.EmptyField();
            return null;
        }

        if(!email.contains("@")){
            view.showInvalidEmail();
            return null;
        }

        if(password.length() < 7){
            view.showInvalidPassword();
            return null;
        }

        User user = userDAO.findUser(email, password);

        if(user == null){
            view.showFailedLogin();
            return null;
        }else{
            return user;
        }
    }
}
