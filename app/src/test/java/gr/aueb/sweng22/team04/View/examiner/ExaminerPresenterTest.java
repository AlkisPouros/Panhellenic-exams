package gr.aueb.sweng22.team04.View.examiner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.CandidateDAOMemory;
import gr.aueb.sweng22.team04.memorydao.ExaminerDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MarkedLessonDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.memorydao.ScientificFieldDAOMemory;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Examiner;
import gr.aueb.sweng22.team04.model.Lesson;
import gr.aueb.sweng22.team04.view.examiner.ExaminerPresenter;

public class ExaminerPresenterTest {

    ExaminerPresenter presenter;
    ExaminerViewStub viewStub;
    private Initializer initializer;

    @Before
    public void setUp(){
        initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new ExaminerViewStub();
        presenter = new ExaminerPresenter();
        presenter.setView(viewStub);
        presenter.setCandidateDAO(new CandidateDAOMemory());
        presenter.setMarkedLessonDAO(new MarkedLessonDAOMemory());
        presenter.setExaminerDAO(new ExaminerDAOMemory());
        presenter.setScientificFieldDAO(new ScientificFieldDAOMemory());
    }

    /**
     * checks if the user lefts any fields empty. If yes we want to check if that produces an error.
     */
    @Test
    public void showEmptySearchCriteria(){
        //invalid search criteria
        Candidate candidate = presenter.onFindCandidate("", "");
        assertEquals(null, candidate);
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());

        //invalid search criteria
        candidate = presenter.onFindCandidate("", "12345678");
        assertEquals(null, candidate);
        assertEquals(2, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * this test checks if we get an error if the result (candidate) does not exit in memory
     */
    @Test
    public void showCandidateNotFound(){
        //this user does not exit in initializer
        Candidate candidate = presenter.onFindCandidate("tester2", "tester2");
        assertEquals(null, candidate);
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(false, viewStub.getStatus());
    }

    /**
     * checks that we get no errors when the candidate does exits
     */
    @Test
    public void findSuccessCandidateForExaminer(){
        Candidate candidate = presenter.onFindCandidate("tester22", "tester22");
        assertNotEquals(null, candidate);
        assertEquals(0, viewStub.getErrorCount());
        assertEquals(true, viewStub.getStatus());
    }

    /**
     * this test checks if we get an error when an examiner inserts an invalid mark
     */
    @Test
    public void showInvalidMark(){
        Examiner examiner = new Examiner("examinerTest", "examinerTest", "1234567890", "tester123@gmail.com");
        examiner.assignAcademicRole(new Lesson("Math", 1.3, presenter.getScientificFieldDAO().findScientificField("4o pedio")));
        Candidate candidate = presenter.onFindCandidate("tester22", "tester22");

        presenter.onSaveMark(examiner, candidate, -1);
        assertEquals(1, viewStub.getErrorCount());
        assertEquals(4, presenter.getMarkedLessonDAO().findAll().size());

        presenter.onSaveMark(examiner, candidate, 21);
        assertEquals(2, viewStub.getErrorCount());
        assertEquals(4, presenter.getMarkedLessonDAO().findAll().size());
    }

    /**
     *this test method checks if the mark for a specific lesson has been saved in memory correctly
     */
    @Test
    public void showSuccessSaveMark(){
        Examiner examiner = new Examiner("examinerTest", "examinerTest", "1234567890", "tester123@gmail.com");
        examiner.assignAcademicRole(new Lesson("Math", 1.3, presenter.getScientificFieldDAO().findScientificField("4o pedio")));
        presenter.getExaminerDAO().addExaminer(examiner);
        Candidate candidate = presenter.onFindCandidate("tester22", "tester22");

        presenter.onSaveMark(examiner, candidate, 0);
        assertEquals(0, viewStub.getErrorCount());
        assertEquals(1, viewStub.getGoodCount());
        assertEquals(true, viewStub.getStatus());
        assertEquals(5, presenter.getMarkedLessonDAO().findAll().size());

        presenter.onSaveMark(examiner, candidate, 15);
        assertEquals(6, presenter.getMarkedLessonDAO().findAll().size());
        assertEquals(2, viewStub.getGoodCount());
        assertEquals(true, viewStub.getStatus());

    }

    /**
     * this method test checks if the correct examiner is found based on the information given
     */
    @Test
    public void findExaminer(){
        Examiner examiner = new Examiner("examinerTest", "examinerTest", "1234567890", "tester123@gmail.com");
        examiner.assignAcademicRole(new Lesson("Math", 1.3, presenter.getScientificFieldDAO().findScientificField("4o pedio")));
        presenter.getExaminerDAO().addExaminer(examiner);

        assertNotEquals(null, presenter.onFindExaminer(examiner.getId()));
    }
}
