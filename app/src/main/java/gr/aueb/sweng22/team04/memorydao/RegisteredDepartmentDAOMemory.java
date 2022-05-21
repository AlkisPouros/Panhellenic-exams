package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public class RegisteredDepartmentDAOMemory implements RegisteredDepartmentDAO {
    protected static ArrayList<RegisteredDepartment> entities = new ArrayList<RegisteredDepartment>();

    @Override
    public void add(RegisteredDepartment entity) {
        entities.add(entity);
    }

}
