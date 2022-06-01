package gr.aueb.sweng22.team04.view.FindAvailableDepartment;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Department;

public class FindAvailableDepartmentPresenter {

    private FindAvailableDepartmentsView view;
    private CandidateDAO candidateDAO;
    private DepartmentDAO departmentDAO;

    private String email;
    private String password;

    public void setView(FindAvailableDepartmentsView view) {
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void onFindAvailableDepartments()
    {

        Candidate candidate = this.candidateDAO.findCandidate(email,password);

        for(Department department : this.departmentDAO.findAll())
        {
            if(candidate.getMoria()>= department.getEBE() && candidate.getField().getName().equals(department.getField().getName()))
            {
                candidate.getAvailableDepartmentperUser().add(department);
            }
        }


    }

}
