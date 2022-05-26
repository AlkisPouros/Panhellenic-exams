package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public interface RegisteredDepartmentDAO {
    void addRegisteredDepartment(RegisteredDepartment entity);

    List<RegisteredDepartment> findAll();

    void delete(RegisteredDepartment registeredDepartment);

}
