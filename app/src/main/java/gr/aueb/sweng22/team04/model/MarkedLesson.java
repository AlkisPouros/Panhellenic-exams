package gr.aueb.sweng22.team04.model;

public class MarkedLesson {

    private Lesson lesson;
    private double mark;
    private Examiner examiner;
    private int CandidateID;

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
