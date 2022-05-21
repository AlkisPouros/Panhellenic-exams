package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.model.MarkedLesson;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public class MarkedLessonDAOMemory implements MarkedLessonDAO {

    protected static ArrayList<MarkedLesson> entities = new ArrayList<MarkedLesson>();

    @Override
    public void add(MarkedLesson entity) {
        entities.add(entity);
    }

}
