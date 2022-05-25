package gr.aueb.sweng22.team04.model;

import java.util.HashSet;
import java.util.Set;

public class ScientificField {

    private String name;
    private int noLesson;
    private Set<Lesson> lessonPerField = new HashSet<Lesson>();

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
