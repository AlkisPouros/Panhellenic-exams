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

    @Test
    public void showErrorForEmptyField(){
        presenter.onSignUp("", "test", "AK35663", "10/12/2005", "hello@gmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }


    @Test
    public void showErrorForInvalidEmail(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hellogmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    @Test
    public void showErrorForInvalidPassword(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hello@gmail.com", "123456", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    @Test
    public void showErrorForInvalidNumberID(){
        presenter.onSignUp("test", "test", "A35663", "10/12/2005", "hello@gmail.com", "123456789", "4o pedio");
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    @Test
    public void successRegistration(){
        presenter.onSignUp("test", "test", "AK35663", "10/12/2005", "hello@gmail.com", "123456789", "4o pedio");
        assertEquals(0, viewStub.getErrorCount());
        assertEquals(true, viewStub.getStatus());
        assertEquals(4, presenter.getCandidateDAO().findAll().size());
        assertNotEquals(3, presenter.getCandidateDAO().findAll().size());
        assertNotEquals(5, presenter.getCandidateDAO().findAll().size());
        assertEquals(8, presenter.getUserDAO().findAll().size());
    }
}
