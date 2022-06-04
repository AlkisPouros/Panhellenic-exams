package gr.aueb.sweng22.team04.dao;

import java.util.List;
import java.util.ArrayList;

import gr.aueb.sweng22.team04.model.Department;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for department DAO Memory and methods to access it
 */

public interface DepartmentDAO {

    /**
     * adds a department in the list
     * @param entity
     */
    void addDepartment(Department entity);

    /**
     * finds a department based one the given department's id
     * @param ID of a department
     * @return  a department with the given id
     */
    Department findDepartment(int ID);

    /**
     * returns all the departments
     * @return departments
     */
    List<Department> findAll();

    /**
     * deletes one department
     * @param department
     */
    void delete(Department department);
}
