package gr.aueb.sweng22.team04.View.Mixanografiko;


import gr.aueb.sweng22.team04.View.Candidate.CandidateViewStub;
import gr.aueb.sweng22.team04.View.FindAvailableDepartments.FindAvailableDepartmentsViewStub;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.memorydao.MixanografikoDAOMemory;
import gr.aueb.sweng22.team04.memorydao.RegisteredDepartmentDAOMemory;
import gr.aueb.sweng22.team04.view.FindAvailableDepartments.FindAvailableDepartmentsPresenter;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;
import gr.aueb.sweng22.team04.view.mixanografiko.MixanografikoPresenter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MixanografikoPresenterTest {

    MixanografikoPresenter presenter;
    MixanografikoViewStub viewstub;
    CandidatePresenter candidatePresenter;
    CandidateViewStub viewstub1;
    FindAvailableDepartmentsPresenter departmentPresenter;
    FindAvailableDepartmentsViewStub ViewStub;

    @Before
    public void setUp()
    {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        viewstub = new MixanografikoViewStub();
        viewstub1 = new CandidateViewStub();
        ViewStub = new FindAvailableDepartmentsViewStub();


        presenter = new MixanografikoPresenter();
        candidatePresenter = new CandidatePresenter();
        departmentPresenter = new FindAvailableDepartmentsPresenter();
        presenter.setView(viewstub);
        candidatePresenter.setView(viewstub1);
        departmentPresenter.setView(ViewStub);

        presenter.setRegisteredDepartmentDAO(new RegisteredDepartmentDAOMemory());
        presenter.setDepartmentDAO(new DepartmentDAOMemory());
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setMixanografikoDAO(new MixanografikoDAOMemory());
        candidatePresenter.setCandidateDAO(new CandidateDAOMemory());
        candidatePresenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());
        candidatePresenter.setDepartmentDAO(new DepartmentDAOMemory());
        candidatePresenter.setMixanografikoDAO(new MixanografikoDAOMemory());
        departmentPresenter.setCandidateDAO(new CandidateDAOMemory());
        departmentPresenter.setDepartmentDAO(new DepartmentDAOMemory());
    }

    @Test
    public void onRegisterDepartments()
    {

        presenter.setEmail("hello@gmail.com");
        presenter.setPassword("12345678");
        candidatePresenter.setEmail("hello@gmail.com");
        candidatePresenter.setPassword("12345678");
        departmentPresenter.setEmail("hello@gmail.com");
        departmentPresenter.setPassword("12345678");


        candidatePresenter.onCalculateMarks();
        departmentPresenter.onFindAvailableDepartments();
        presenter.onRegisterDepartments();
        assertEquals(3,presenter.getMixanografikoDAO().findMixanografiko("AK457841").getRegisteredDepartments().size());

    }


}
