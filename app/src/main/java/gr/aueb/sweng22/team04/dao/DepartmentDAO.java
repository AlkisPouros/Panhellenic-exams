package gr.aueb.sweng22.team04.dao;

import java.util.List;
import java.util.ArrayList;

import gr.aueb.sweng22.team04.model.Department;

public interface DepartmentDAO {

    void addDepartment(Department entity);

    Department findDepartment(int ID);

    List<Department> findAll();

    void delete(Department department);
}
