package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public class MarkedLessonDAOMemory implements MarkedLessonDAO {

    protected static ArrayList<MarkedLesson> markedLessonEntities = new ArrayList<MarkedLesson>();

    @Override
    public void addMarkedLesson(MarkedLesson entity) {
        markedLessonEntities.add(entity);
    }

    @Override
    public List<MarkedLesson> findAll() {
        ArrayList<MarkedLesson> result = new ArrayList<MarkedLesson>();
        result.addAll(markedLessonEntities);
        return result;
    }

    @Override
    public void delete(MarkedLesson markedLesson) {
        markedLessonEntities.remove(markedLesson);
    }
}
