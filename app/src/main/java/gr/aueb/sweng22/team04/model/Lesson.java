package gr.aueb.sweng22.team04.model;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for lesson
 */

public class Lesson {

    private String lessonName;
    private double coefficient;
    private ScientificField field;

    /**
     * constructor for lesson
     * @param lessonName
     * @param coefficient
     * @param field
     */
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
