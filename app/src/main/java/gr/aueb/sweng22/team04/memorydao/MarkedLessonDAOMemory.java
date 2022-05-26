package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public class MarkedLessonDAOMemory implements MarkedLessonDAO {

    protected static ArrayList<MarkedLesson> markedLessonEntities = new ArrayList<MarkedLesson>();

    @Override
    public void addMarkedLesson(MarkedLesson entity) {
        markedLessonEntities.add(entity);
    }

    @Override
    public ArrayList<MarkedLesson> getMarkedLessons() {
        return markedLessonEntities;
    }
}
