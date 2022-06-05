package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Lesson;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for lesson DAO Memory and methods to access it
 */

public interface LessonDAO {

    /**
     * adds a lesson to list
     * @param entity lesson
     */
    void addLesson(Lesson entity);

    /**
     * finds a lesson bases on the given lesson's name
     * @param name
     * @return a lesson bases on the given lesson
     */
    Lesson findLessonByName(String name);

    /**
     * returns all the lessons
     * @return  lessons
     */
    List<Lesson> findAll();

    /**
     * deletes one lesson
     * @param lesson
     */
    void delete(Lesson lesson);
}
