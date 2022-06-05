package gr.aueb.sweng22.team04.view.login.signUp;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * view interface for sign up
 */

public interface SignUpView {

    /**
     * shows message in ui for empty field
     */
    void emptyField();

    /**
     * shows message in ui if the user entered an email that does not have the mail format
     */
    void showInvalidEmail();

    /**
     * shows message in ui if the password does not follows specific rules
     */
    void showInvalidPassword();

    /**
     * show message in ui if the police id number does not have two letters before numbers
     */
    void showInvalidPoliceID();
}
