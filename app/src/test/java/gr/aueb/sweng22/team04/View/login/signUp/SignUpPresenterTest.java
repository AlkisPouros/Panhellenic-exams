package gr.aueb.sweng22.team04.View.login.signUp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.memorydao.ScientificFieldDAOMemory;
import gr.aueb.sweng22.team04.memorydao.UserDAOMemory;
import gr.aueb.sweng22.team04.view.login.signUp.SignUpPresenter;

public class SignUpPresenterTest {

    SignUpViewStub viewStub;
    SignUpPresenter presenter;

    @Before
    public void setup(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new SignUpViewStub();
        presenter = new SignUpPresenter();
        presenter.setView(viewStub);
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setScientificFieldDAO(new ScientificFieldDAOMemory());
        presenter.setUserDAO(new UserDAOMemory());
    }

    /**
     * checks for errors if the user lefts any field empty
     */
    @Test
    public void showErrorForEmptyField(){
        presenter.onSignUp("", "test", "AK35663", "10/12/2005", "hello@gmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that an error is returned if user enters email in a wrong format
     */
    @Test
    public void showErrorForInvalidEmail(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hellogmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that an error is returned if user enters password in a wrong format
     */
    @Test
    public void showErrorForInvalidPassword(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hello@gmail.com", "123456", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that an error is returned if user enters ID number in a wrong format
     */
    @Test
    public void showErrorForInvalidNumberID(){
        presenter.onSignUp("test", "test", "A35663", "10/12/2005", "hello@gmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that we get zero errors and candidates account is saved correctly
     */
    @Test
    public void successRegistration(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hello56@gmail.com", "123456789", "4o pedio");
        assertEquals(0, viewStub.getErrorCount());
        assertEquals(true, viewStub.getStatus());
        assertEquals(4, presenter.getCandidateDAO().findAll().size());
        assertNotEquals(3, presenter.getCandidateDAO().findAll().size());
        assertNotEquals(5, presenter.getCandidateDAO().findAll().size());
        assertEquals(8, presenter.getUserDAO().findAll().size());
    }
}
