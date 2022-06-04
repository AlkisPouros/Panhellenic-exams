package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Examiner;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for examiner DAO Memory and methods to access it
 */

public interface ExaminerDAO {

    /**
     * adds a examiner to list
     * @param entity examiner
     */
    void addExaminer(Examiner entity);

    /**
     * finds examiner based on the given examiner's id
     * @param ID
     * @return a examiner with the given id
     */
    Examiner findExaminer(int ID);

    /**
     * returns all the examiners
     * @return  examiners
     */
    List<Examiner> findAll();

    /**
     * deletes one examiner
     * @param examiner
     */
    void delete(Examiner examiner);
}
