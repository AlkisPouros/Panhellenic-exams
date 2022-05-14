package gr.aueb.sweng22.team04.model;

public class Lesson {

    private String lessonName;
    private double coefficient;
    private ScientificField field;

    public Lesson(String lessonName, double coefficient, ScientificField field) {
        this.lessonName = lessonName;
        this.coefficient = coefficient;
        this.field = field;
    }

    public String getLessonName() {
        return lessonName;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public ScientificField getField() {
        return field;
    }
}
