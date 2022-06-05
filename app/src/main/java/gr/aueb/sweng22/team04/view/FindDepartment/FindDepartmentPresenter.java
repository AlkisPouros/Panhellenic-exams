package gr.aueb.sweng22.team04.view.FindDepartment;

import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.view.mixanografiko.MixanografikoView;

public class FindDepartmentPresenter {

    private FindDepartmentView view;
    private DepartmentDAO departmentDAO;

    public void setView(FindDepartmentView view) {
        this.view = view;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }

    public String onFindDepartment(int id)
    {
        Department department = this.departmentDAO.findDepartment(id);
        return department.getDepartmentName()+" with id "+department.getDepartmentID();
    }
}
