package gr.aueb.sweng22.team04.dao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.model.Lesson;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public interface MarkedLessonDAO {
    void addMarkedLesson(MarkedLesson entity);

    ArrayList<MarkedLesson> getMarkedLessons();
}
