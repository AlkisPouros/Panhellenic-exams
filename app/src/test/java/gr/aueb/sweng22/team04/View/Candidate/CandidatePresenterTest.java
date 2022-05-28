package gr.aueb.sweng22.team04.View.Candidate;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;

public class CandidatePresenterTest {

    CandidatePresenter presenter;
    CandidateViewStub viewStub;

    @Before
    public void setUp()
    {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new CandidateViewStub();
        presenter = new CandidatePresenter();
        presenter.setView(viewStub);
        presenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());
        presenter.setDepartmentDAO(new DepartmentDAOMemory());
        presenter.setCandidateDAO(new CandidateDAOMemory());
    }

    @Test
    public void onCalculateMarks()
    {
        presenter.setEmail("hello@gmail.com");
        presenter.setPassword("12345678");
        Candidate candidate = presenter.getCandidateDAO().findCandidate("hello@gmail.com","12345678");
        presenter.onCalculateMarks();
        assertNotEquals(-1,candidate.getMoria());
        assertEquals(18535,candidate.getMoria());

    }
    @Test
    public void onFindAvailableDepartments()
    {
        presenter.setEmail("hello@gmail.com");
        presenter.setPassword("12345678");
        Candidate candidate = presenter.getCandidateDAO().findCandidate("hello@gmail.com","12345678");
        presenter.onCalculateMarks();
        presenter.onFindAvailableDepartments();
        assertNotEquals(0,candidate.getAvailableDepartmentperUser().size());
        assertEquals(3,candidate.getAvailableDepartmentperUser().size());

    }


}
