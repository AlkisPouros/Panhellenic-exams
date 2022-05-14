package gr.aueb.sweng22.team04.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class CandidateTest {

    Candidate candidate;
    ScientificField field;
    Examiner examiner;
    Examiner examiner2;
    Examiner examiner3;
    Examiner examiner4;
    @Before
    public void setUp() throws Exception {
        field = new ScientificField("4o pedio", 4);
        candidate = new Candidate("1234", "hello@gmail.com", "tester", "tester", new Date(), "AK457841", field);
        examiner = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner.assignAcademicRole(new Lesson("math", 1.3, field));
        examiner2 = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner2.assignAcademicRole(new Lesson("AOTH", 0.7, field));
        examiner3 = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner3.assignAcademicRole(new Lesson("ekthesi", 0, field));
        examiner4 = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner4.assignAcademicRole(new Lesson("AEPP", 0, field));
    }

    @Test
    public void calculateMarks() {
        MarkedLesson markedLesson = new MarkedLesson(examiner.getAcademicRole(), 19, examiner);
        candidate.addMark(markedLesson);
        markedLesson = new MarkedLesson(examiner2.getAcademicRole(), 19.5, examiner2);
        candidate.addMark(markedLesson);
        markedLesson = new MarkedLesson(examiner3.getAcademicRole(), 16, examiner3);
        candidate.addMark(markedLesson);
        markedLesson = new MarkedLesson(examiner4.getAcademicRole(), 19, examiner4);
        candidate.addMark(markedLesson);
        candidate.calculateMarks();
        assertEquals(18535, candidate.getMoria());
        assertNotEquals(10000, candidate.getMoria());
    }

    @Test
    public void loginCandidate(){
        assertTrue(candidate.loginCandidate("hello@gmail.com", "1234"));
        assertFalse(candidate.loginCandidate("hi@gmail.com", "1234"));
        assertFalse(candidate.loginCandidate("hello@gmail.com", "123456"));
    }

    @Test
    public void createMixanografiko(){
        candidate.createMixanografiko();
        assertNotNull(candidate.getMixanografiko());
    }

    @Test
    public void findAvailableDepartments(){
        candidate.findAvailableDepartments();
        candidate.calculateMarks();
        assertEquals(2, candidate.getAvailableDepartmentperUser().size());

    }
}