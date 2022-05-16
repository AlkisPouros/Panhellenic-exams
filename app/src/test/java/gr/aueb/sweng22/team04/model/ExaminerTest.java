package gr.aueb.sweng22.team04.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import gr.aueb.sweng22.team04.Helper;

public class ExaminerTest {

    Examiner examiner;
    Examiner examiner2;
    Candidate candidate;
    @Before
    public void setUp() throws Exception {
        examiner = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner2 = new Examiner("examiner2", "examiner2", "12345", "examiner@gmail.com");
        ScientificField field = new ScientificField("4o pedio", 4);
        candidate = new Candidate("1234", "hello@gmail.com", "tester", "tester", new Date(), "AK789658", field);

        Helper helper = new Helper();
        helper.initialiseScientificFields();
        helper.initialiseLessons();
        helper.initialiseExaminers();
        helper.initialiseDepartments();
        helper.initialiseCandidates();
    }

    @Test
    public void loginExaminer() {
        assertTrue(examiner.loginExaminer("exam@gmail.com", "1234"));
        assertFalse(examiner.loginExaminer("e@gmail.com", "1234"));
        assertFalse(examiner.loginExaminer("exam@gmail.com", "123456"));
    }

    @Test
    public void findCandidate() {
        ScientificField field = new ScientificField("4o pedio", 4);
        Candidate candidate2 = new Candidate("1234736", "hello543@gmail.com", "tester35", "tester543", new Date(), "AK785858", field);

        Helper.allCandidates.add(candidate);
        Helper.allCandidates.add(candidate2);
        assertSame(candidate, examiner.findCandidate(candidate.getId()));
        assertNotSame(candidate, examiner.findCandidate(candidate2.getId()));
    }

    @Test
    public void saveMarks() {
        candidate.addMark(examiner.saveMarksTemp(candidate.getId(), 14.2));
        //candidate.addMark(examiner.saveMarksTemp(candidate.getId(), 15));

        candidate.addMark(examiner2.saveMarksTemp(candidate.getId(), 18));
        //candidate.addMark(examiner2.saveMarksTemp(candidate.getId(), 19));

        assertEquals(2, candidate.getAllMarks().size());
        assertEquals(14.2, candidate.getAllMarks().get(0).getMark(), 0.00001);

        assertSame(examiner, candidate.getAllMarks().get(0).getExaminer());
        assertSame(examiner2, candidate.getAllMarks().get(1).getExaminer());
    }
}