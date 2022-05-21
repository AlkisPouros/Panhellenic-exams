package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.ExaminerDAO;
import gr.aueb.sweng22.team04.model.Examiner;
import gr.aueb.sweng22.team04.model.Examiner;

public class ExaminerDAOMemory implements ExaminerDAO {
    protected static ArrayList<Examiner> entities = new ArrayList<Examiner>();

    @Override
    public void add(Examiner entity) {
        entities.add(entity);
    }

    @Override
    public Examiner find(int ID) {
        for (Examiner now : entities)
            if (now.getId() == ID)
                return now;

        return null;
    }
}
