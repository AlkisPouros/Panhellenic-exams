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

    /**
     * This test checks if the correct amount of moria is calculated based on the candidate's marked lessons.
     * First we find the candidate and then we calculate the total score based on marked lesson.
     * At last we check if the method produced the correct number.
     */
    @Test
    public void onCalculateMarks()
    {
        int moria;
        presenter.setEmail("hello@gmail.com");
        presenter.setPassword("12345678");
        Candidate candidate = presenter.getCandidateDAO().findCandidate("hello@gmail.com","12345678");
        moria = presenter.onCalculateMarks();
        assertNotEquals(-1,candidate.getMoria());
        assertEquals(18535,candidate.getMoria());
        assertEquals(moria,candidate.getMoria());
    }


}
