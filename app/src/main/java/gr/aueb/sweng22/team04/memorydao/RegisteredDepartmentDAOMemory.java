package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface registered department DAO
 */

public class RegisteredDepartmentDAOMemory implements RegisteredDepartmentDAO {
    protected static ArrayList<RegisteredDepartment> registeredDepartmentEntities = new ArrayList<RegisteredDepartment>();

    /**
     * adds a registered department to list
     * @param entity registered department
     */
    @Override
    public void addRegisteredDepartment(RegisteredDepartment entity) {
        registeredDepartmentEntities.add(entity);
    }

    /**
     * returns all registered departments
     * @return registered departments
     */
    @Override
    public List<RegisteredDepartment> findAll() {
        ArrayList<RegisteredDepartment> result = new ArrayList<RegisteredDepartment>();
        result.addAll(registeredDepartmentEntities);
        return result;
    }

    /**
     * deletes one registered department
     * @param registeredDepartment
     */
    @Override
    public void delete(RegisteredDepartment registeredDepartment) {
        registeredDepartmentEntities.remove(registeredDepartment);
    }
}
