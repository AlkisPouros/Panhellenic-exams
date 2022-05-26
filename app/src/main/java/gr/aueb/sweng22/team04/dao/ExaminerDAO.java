package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Examiner;

public interface ExaminerDAO {
    void addExaminer(Examiner entity);

    Examiner findExaminer(int ID);

    List<Examiner> findAll();

    void delete(Examiner examiner);
}
