package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Examiner;

public interface ExaminerDAO {
    void add(Examiner entity);

    Examiner find(int ID);
}
