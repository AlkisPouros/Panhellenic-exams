package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Examiner;

public interface ExaminerDAO {
    void addExaminer(Examiner entity);

    Examiner findExaminer(int ID);
}
