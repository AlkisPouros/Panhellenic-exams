package gr.aueb.sweng22.team04.view.login.signIn;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * interface for login view
 */

public interface LoginView {

    /**
     * shows message in ui for empty field
     */
    void EmptyField();

    /**
     * show message in ui if the user entered data that do not exist in memory
     */
    void showFailedLogin();

    /**
     * shows message in ui if the user entered an email that does not have the mail format
     */
    void showInvalidEmail();

    /**
     * shows message in ui if the password does not follows specific rules
     */
    void showInvalidPassword();
}
