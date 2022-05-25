package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.ExaminerDAO;
import gr.aueb.sweng22.team04.model.Examiner;

public class ExaminerDAOMemory implements ExaminerDAO {
    protected static ArrayList<Examiner> examinerEntities = new ArrayList<Examiner>();

    @Override
    public void addExaminer(Examiner entity) {
        examinerEntities.add(entity);
    }

    @Override
    public Examiner findExaminer(int ID) {
        for (Examiner examiner : examinerEntities) {
            if (examiner.getId() == ID) {
                return examiner;
            }
        }
        return null;
    }
}
