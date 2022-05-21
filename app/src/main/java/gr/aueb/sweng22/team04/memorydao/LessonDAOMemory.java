package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.model.Lesson;

public class LessonDAOMemory implements LessonDAO {

    protected static ArrayList<Lesson> entities = new ArrayList<Lesson>();

    @Override
    public void add(Lesson entity) {
        entities.add(entity);
    }

    public Lesson findByName(String name) {
        for (Lesson now : entities)
            if (now.getLessonName() == name)
                return now;

        return null;
    }


}
