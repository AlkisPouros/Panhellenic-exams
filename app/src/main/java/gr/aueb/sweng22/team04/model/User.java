package gr.aueb.sweng22.team04.model;

import java.util.Random;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for user
 */
public class User {

    private String password;
    private int id;
    private String email;
    private String UserMode;

    /**
     * constructor for user
     * @param password
     * @param email
     * @param userMode
     */
    public User(String password, String email, String userMode) {
        Random rand = new Random();
        this.id = rand.nextInt();
        this.password = password;
        this.email = email;
        UserMode = userMode;
    }

    public Boolean loginUser(String email, String password){
        if(this.getEmail().equals(email) && this.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public void signUp(String email, String password, String userMode){
       new User(password, email, userMode);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserMode() {
        return UserMode;
    }

    public void setUserMode(String userMode) {
        this.UserMode = userMode;
    }
}
