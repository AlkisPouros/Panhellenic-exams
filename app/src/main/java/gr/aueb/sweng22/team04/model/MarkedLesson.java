package gr.aueb.sweng22.team04.model;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for marked lesson
 */

public class MarkedLesson {

    private Lesson lesson;
    private double mark;
    private Examiner examiner;
    private int CandidateID;

    /**
     * constructor for marked lesson
     * @param lesson
     * @param mark
     * @param examiner
     * @param CandidateID
     */
    public MarkedLesson(Lesson lesson, double mark, Examiner examiner,int CandidateID) {
        this.lesson = lesson;
        this.mark = mark;
        this.examiner = examiner;
        this.CandidateID = CandidateID;
    }

    public int getCandidateID() {
        return CandidateID;
    }


    public Lesson getLesson() {
        return lesson;
    }

    public double getMark() {
        return mark;
    }

    public Examiner getExaminer() {
        return examiner;
    }
}
