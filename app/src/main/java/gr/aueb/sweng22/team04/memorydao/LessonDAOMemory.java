package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.model.Lesson;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface lesson DAO
 */
public class LessonDAOMemory implements LessonDAO {

    protected static ArrayList<Lesson> lessonEntities = new ArrayList<Lesson>();

    /**
     * adds a lesson to list
     * @param entity lesson
     */
    @Override
    public void addLesson(Lesson entity) {
        lessonEntities.add(entity);
    }

    /**
     * finds a lesson bases on the given lesson's name
     * @param name
     * @return a lesson bases on the given lesson or null
     */
    @Override
    public Lesson findLessonByName(String name) {
        for (Lesson now : lessonEntities) {
            if (now.getLessonName().equals(name)) {
                return now;
            }
        }
        return null;
    }

    /**
     * returns all the lessons
     * @return  lessons
     */
    @Override
    public List<Lesson> findAll() {
        ArrayList<Lesson> result = new ArrayList<Lesson>();
        result.addAll(lessonEntities);
        return result;
    }

    /**
     * deletes one lesson
     * @param lesson
     */
    @Override
    public void delete(Lesson lesson) {
        lessonEntities.remove(lesson);
    }
}
