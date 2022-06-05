package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.ExaminerDAO;
import gr.aueb.sweng22.team04.model.Examiner;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface examiner DAO
 */
public class ExaminerDAOMemory implements ExaminerDAO {
    protected static ArrayList<Examiner> examinerEntities = new ArrayList<Examiner>();

    /**
     * adds a examiner to list
     * @param entity examiner
     */
    @Override
    public void addExaminer(Examiner entity) {
        examinerEntities.add(entity);
    }

    /**
     * finds examiner based on the given examiner's id
     * @param ID
     * @return a examiner with the given id or null
     */
    @Override
    public Examiner findExaminer(int ID) {
        for (Examiner examiner : examinerEntities) {
            if (examiner.getId() == ID) {
                return examiner;
            }
        }
        return null;
    }

    /**
     * returns all the examiners
     * @return  examiners
     */
    @Override
    public List<Examiner> findAll() {
        ArrayList<Examiner> result = new ArrayList<Examiner>();
        result.addAll(examinerEntities);
        return result;
    }

    /**
     * deletes one examiner
     * @param examiner
     */
    @Override
    public void delete(Examiner examiner) {
        examinerEntities.remove(examiner);
    }
}
