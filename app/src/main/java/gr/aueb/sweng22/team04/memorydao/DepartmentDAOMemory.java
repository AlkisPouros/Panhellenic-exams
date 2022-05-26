package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.model.Department;

public class DepartmentDAOMemory implements DepartmentDAO {

    protected static ArrayList<Department> departmentEntities = new ArrayList<Department>();

    @Override
    public void addDepartment(Department entity) {
        departmentEntities.add(entity);
    }

    @Override
    public Department findDepartment(int ID) {
        for (Department department : departmentEntities) {
            if (department.getDepartmentID() == ID) {
                return department;
            }
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        ArrayList<Department> result = new ArrayList<Department>();
        result.addAll(departmentEntities);
        return result;
    }

    @Override
    public void delete(Department department) {
        departmentEntities.remove(department);
    }
}
