package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.model.Department;

public class DepartmentDAOMemory implements DepartmentDAO {

    protected static ArrayList<Department> entities = new ArrayList<Department>();

    @Override
    public void add(Department entity) {
        entities.add(entity);
    }

    @Override
    public Department find(int ID) {
        for (Department now : entities)
            if (now.getDepartmentID() == ID)
                return now;

        return null;
    }

}
