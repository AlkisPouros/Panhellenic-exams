package gr.aueb.sweng22.team04.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for scientific field
 */

public class ScientificField {

    private String name;
    private int noLesson;
    private Set<Lesson> lessonPerField = new HashSet<Lesson>();

    /**
     * constructor for scientific field
     * @param name
     * @param noLesson
     */
    public ScientificField( String name, int noLesson) {
        this.name = name;
        this.noLesson = noLesson;
    }

    public void addLesson(Lesson lesson){
        this.lessonPerField.add(lesson);
    }

    public String getName() {
        return this.name;
    }
}
