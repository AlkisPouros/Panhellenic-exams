package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public class RegisteredDepartmentDAOMemory implements RegisteredDepartmentDAO {
    protected static ArrayList<RegisteredDepartment> registeredDepartmentEntities = new ArrayList<RegisteredDepartment>();

    @Override
    public void addRegisteredDepartment(RegisteredDepartment entity) {
        registeredDepartmentEntities.add(entity);
    }

    @Override
    public List<RegisteredDepartment> findAll() {
        ArrayList<RegisteredDepartment> result = new ArrayList<RegisteredDepartment>();
        result.addAll(registeredDepartmentEntities);
        return result;
    }

    @Override
    public void delete(RegisteredDepartment registeredDepartment) {
        registeredDepartmentEntities.remove(registeredDepartment);
    }
}
