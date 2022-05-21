package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Lesson;
import gr.aueb.sweng22.team04.model.ScientificField;

public interface LessonDAO {
    void add(Lesson entity);
    Lesson findByName(String name);
}
