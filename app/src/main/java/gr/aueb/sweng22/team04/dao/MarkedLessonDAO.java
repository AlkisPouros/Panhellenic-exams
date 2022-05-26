package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.MarkedLesson;

public interface MarkedLessonDAO {
    void addMarkedLesson(MarkedLesson entity);

    List<MarkedLesson> findAll();

    void delete(MarkedLesson markedLesson);
}
