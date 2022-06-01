package gr.aueb.sweng22.team04.View.FindAvailableDepartments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.sweng22.team04.View.Candidate.CandidateViewStub;
import gr.aueb.sweng22.team04.View.FindDepartments.FindDepartmentViewStub;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.view.FindAvailableDepartment.FindAvailableDepartmentPresenter;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;

public class FindAvailableDepartmentsPresenterTest {

    FindAvailableDepartmentPresenter presenter;
    FindAvailableDepartmentsViewStub viewStub;
    CandidatePresenter candidatePresenter;
    CandidateViewStub ViewStub;


    @Before
    public void setUp()
    {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new FindAvailableDepartmentsViewStub();
        presenter = new FindAvailableDepartmentPresenter();
        presenter.setView(viewStub);

        ViewStub = new CandidateViewStub();
        candidatePresenter = new CandidatePresenter();
        candidatePresenter.setView(ViewStub);

        presenter.setDepartmentDAO(new DepartmentDAOMemory());
        presenter.setCandidateDAO(new CandidateDAOMemory());

        candidatePresenter.setCandidateDAO(new CandidateDAOMemory());
        candidatePresenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());



    }
    @Test
    public void onFindAvailableDepartments()
    {
        presenter.setEmail("hello@gmail.com");
        presenter.setPassword("12345678");
        candidatePresenter.setEmail("hello@gmail.com");
        candidatePresenter.setPassword("12345678");
        candidatePresenter.onCalculateMarks();
        presenter.onFindAvailableDepartments();
        assertNotEquals(0,candidatePresenter.getCandidateDAO().findCandidate("hello@gmail.com","12345678").getAvailableDepartmentperUser().size());
        assertEquals(3,candidatePresenter.getCandidateDAO().findCandidate("hello@gmail.com","12345678").getAvailableDepartmentperUser().size());
    }
}
