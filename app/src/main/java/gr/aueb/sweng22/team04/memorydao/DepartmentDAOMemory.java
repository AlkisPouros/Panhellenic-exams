package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.model.Department;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface department DAO
 */

public class DepartmentDAOMemory implements DepartmentDAO {

    protected static ArrayList<Department> departmentEntities = new ArrayList<Department>();

    /**
     * adds a department in the list
     * @param entity
     */
    @Override
    public void addDepartment(Department entity) {
        departmentEntities.add(entity);
    }

    /**
     * finds a department based one the given department's id
     * @param ID of a department
     * @return  a department with the given id or null
     */
    @Override
    public Department findDepartment(int ID) {
        for (Department department : departmentEntities) {
            if (department.getDepartmentID() == ID) {
                return department;
            }
        }
        return null;
    }

    /**
     * returns all the departments
     * @return departments
     */
    @Override
    public List<Department> findAll() {
        ArrayList<Department> result = new ArrayList<Department>();
        result.addAll(departmentEntities);
        return result;
    }

    /**
     * deletes one department
     * @param department
     */
    @Override
    public void delete(Department department) {
        departmentEntities.remove(department);
    }
}
