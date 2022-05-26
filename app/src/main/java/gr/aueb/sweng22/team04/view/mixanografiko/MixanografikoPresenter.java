package gr.aueb.sweng22.team04.view.mixanografiko;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.Mixanografiko;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;


public class MixanografikoPresenter {

    private MixanografikoView view;
    private MixanografikoDAO mixanografikoDAO;
    private DepartmentDAO departmentDAO;
    private CandidateDAO candidateDAO;
    private RegisteredDepartmentDAO registeredDepartmentDAO;
    public MixanografikoPresenter(MixanografikoView view, CandidateDAO candidateDAO, MixanografikoDAO mixanografikoDAO, DepartmentDAO departmentDAO, RegisteredDepartmentDAO registeredDepartmentDAO)
    {
        this.view = view;
        this.candidateDAO = candidateDAO;
        this.mixanografikoDAO = mixanografikoDAO;
        this.departmentDAO = departmentDAO;
        this.registeredDepartmentDAO = registeredDepartmentDAO;
    }
    void onRegisterDepartments()
    {
        Mixanografiko mixanografiko = new Mixanografiko();
        this.mixanografikoDAO.addMixanografiko(mixanografiko);
        int counter = 0;

        /*
        for(Department department : this.candidateDAO.getAvailableDeparmtentsperUser())
        {
            counter++;  // the new department's position
            RegisteredDepartment registeredDepartment = new RegisteredDepartment(counter, department);
            this.mixanografikoDAO.findMixanografiko(mixanografiko.getMixanografikoID()).getRegisteredDepartments().add(registeredDepartment);
            this.registeredDepartmentDAO.addRegisteredDepartment(registeredDepartment); // Adding these new submitted departments to the memory
            this.mixanografikoDAO.addMixanografiko(mixanografiko);
        }
         */
    }

}
