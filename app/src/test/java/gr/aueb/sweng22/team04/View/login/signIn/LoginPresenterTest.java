package gr.aueb.sweng22.team04.View.login.signIn;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.memorydao.UserDAOMemory;
import gr.aueb.sweng22.team04.view.login.signIn.LoginPresenter;


public class LoginPresenterTest {

    LoginViewStub viewStub;
    LoginPresenter presenter;

    @Before
    public void setup(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new LoginViewStub();
        presenter = new LoginPresenter();
        presenter.setView(viewStub);
        presenter.setUserDAO(new UserDAOMemory());
    }

    /**
     * checks for errors if the user lefts any field empty
     */
    @Test
    public void showErrorForEmptyField(){
        presenter.onLogin("", "");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that we get an error when a user mistakes their login credentials
     */
    @Test
    public void showErrorForInvalidLogin(){
        presenter.onLogin("hello@gmail.com", "1234567891");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that an error is returned if user enters email in a wrong format
     */
    @Test
    public void showErrorForInvalidEmail(){
        presenter.onLogin("hellogmail.com", "12345678");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that an error is returned if user enters password in a wrong format
     */
    @Test
    public void showErrorForInvalidPassword(){
        presenter.onLogin("hello@gmail.com", "123456");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that we get zero errors when a user enters the correct credentials
     */
    @Test
    public void successLogin(){
        presenter.onLogin("hello@gmail.com", "12345678");
        assertEquals(0, viewStub.getErrorCount());
        assertEquals(true, viewStub.getStatus());
    }
}
