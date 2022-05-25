package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Lesson;
import gr.aueb.sweng22.team04.model.ScientificField;

public interface LessonDAO {
    void addLesson(Lesson entity);

    Lesson findLessonByName(String name);
}
