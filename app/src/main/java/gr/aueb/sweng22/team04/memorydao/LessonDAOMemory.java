package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.model.Lesson;

public class LessonDAOMemory implements LessonDAO {

    protected static ArrayList<Lesson> lessonEntities = new ArrayList<Lesson>();

    @Override
    public void addLesson(Lesson entity) {
        lessonEntities.add(entity);
    }

    public Lesson findLessonByName(String name) {
        for (Lesson now : lessonEntities) {
            if (now.getLessonName() == name) {
                return now;
            }
        }
        return null;
    }
}
