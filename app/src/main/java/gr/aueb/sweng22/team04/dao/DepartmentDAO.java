package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Department;

public interface DepartmentDAO {
    void add(Department entity);

    Department find(int ID);
}
