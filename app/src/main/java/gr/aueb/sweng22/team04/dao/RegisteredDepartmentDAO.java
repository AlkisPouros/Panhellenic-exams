package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.RegisteredDepartment;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for registered department DAO Memory and methods to access it
 */

public interface RegisteredDepartmentDAO {

    /**
     * adds a registered department to list
     * @param entity registered department
     */
    void addRegisteredDepartment(RegisteredDepartment entity);

    /**
     * returns all registered departments
     * @return registered departments
     */
    List<RegisteredDepartment> findAll();

    /**
     * deletes one registered department
     * @param registeredDepartment
     */
    void delete(RegisteredDepartment registeredDepartment);

}
