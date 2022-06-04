package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.MarkedLesson;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for marked lesson DAO Memory and methods to access it
 */

public interface MarkedLessonDAO {

    /**
     * adds a marked lesson to list
     * @param entity marked lesson
     */
    void addMarkedLesson(MarkedLesson entity);

    /**
     * returns all marked lessons
     * @return  marked lessons
     */
    List<MarkedLesson> findAll();

    /**
     * deletes one marked lesson
     * @param markedLesson
     */
    void delete(MarkedLesson markedLesson);
}
