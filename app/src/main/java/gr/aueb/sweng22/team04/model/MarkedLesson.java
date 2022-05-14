package gr.aueb.sweng22.team04.model;

public class MarkedLesson {

    private Lesson lesson;
    private double mark;
    private Examiner examiner;

    public MarkedLesson(Lesson lesson, double mark, Examiner examiner) {
        this.lesson = lesson;
        this.mark = mark;
        this.examiner = examiner;
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
