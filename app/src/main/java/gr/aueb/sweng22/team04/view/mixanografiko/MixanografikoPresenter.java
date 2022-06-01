package gr.aueb.sweng22.team04.view.mixanografiko;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.Mixanografiko;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;


public class MixanografikoPresenter {

    private MixanografikoView view;
    private MixanografikoDAO mixanografikoDAO;
    private DepartmentDAO departmentDAO;
    private CandidateDAO candidateDAO;
    private RegisteredDepartmentDAO registeredDepartmentDAO;

    private String email;
    private String password;

    public void setView(MixanografikoView view) {
        this.view = view;
    }

    public void setMixanografikoDAO(MixanografikoDAO mixanografikoDAO) {
        this.mixanografikoDAO = mixanografikoDAO;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
    public DepartmentDAO getDepartmentDAO()
    {
        return departmentDAO;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void setRegisteredDepartmentDAO(RegisteredDepartmentDAO registeredDepartmentDAO) {
        this.registeredDepartmentDAO = registeredDepartmentDAO;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public MixanografikoDAO getMixanografikoDAO()
    {
        return mixanografikoDAO;
    }


    public void onRegisterDepartments()
    {

        Candidate candidate = this.candidateDAO.findCandidate(email,password); //see CandidatePresenter to be checked again

        int counter = 0;


        for(Department department : candidate.getAvailableDepartmentperUser())
        {
            counter++;  // the new department's position in Mixanografiko
            RegisteredDepartment registeredDepartment = new RegisteredDepartment(counter,department);
            this.mixanografikoDAO.findMixanografiko(candidate.getIdNumber()).getRegisteredDepartments().add(registeredDepartment);
            this.registeredDepartmentDAO.addRegisteredDepartment(registeredDepartment); // Adding these new submitted departments to the memory

        }

    }



}
