package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.model.MarkedLesson;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implemantion of interface marked lesson DAO
 */

public class MarkedLessonDAOMemory implements MarkedLessonDAO {

    protected static ArrayList<MarkedLesson> markedLessonEntities = new ArrayList<MarkedLesson>();

    /**
     * adds a marked lesson to list
     * @param entity marked lesson
     */
    @Override
    public void addMarkedLesson(MarkedLesson entity) {
        markedLessonEntities.add(entity);
    }

    /**
     * returns all marked lessons
     * @return  marked lessons
     */
    @Override
    public List<MarkedLesson> findAll() {
        ArrayList<MarkedLesson> result = new ArrayList<MarkedLesson>();
        result.addAll(markedLessonEntities);
        return result;
    }

    /**
     * deletes one marked lesson
     * @param markedLesson
     */
    @Override
    public void delete(MarkedLesson markedLesson) {
        markedLessonEntities.remove(markedLesson);
    }
}
