package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.model.Lesson;

public class LessonDAOMemory implements LessonDAO {

    protected static ArrayList<Lesson> lessonEntities = new ArrayList<Lesson>();

    @Override
    public void addLesson(Lesson entity) {
        lessonEntities.add(entity);
    }

    @Override
    public Lesson findLessonByName(String name) {
        for (Lesson now : lessonEntities) {
            if (now.getLessonName() == name) {
                return now;
            }
        }
        return null;
    }

    @Override
    public List<Lesson> findAll() {
        ArrayList<Lesson> result = new ArrayList<Lesson>();
        result.addAll(lessonEntities);
        return result;
    }

    @Override
    public void delete(Lesson lesson) {
        lessonEntities.remove(lesson);
    }
}
