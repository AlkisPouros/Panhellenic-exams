package gr.aueb.sweng22.team04.view.admin;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;

public class AdminPresenter {
    private AdminView view;
    private CandidateDAO candidateDAO;
    private MixanografikoDAO mixanografikoDAO;
    private RegisteredDepartmentDAO registeredDepartmentDAO;

    public void setView(AdminView view) {
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO) { this.candidateDAO = candidateDAO; }

    public void setMixanografikoDAO(MixanografikoDAO mixanografikoDAO) { this.mixanografikoDAO = mixanografikoDAO; }

    public void setRegisteredDepartmentDAO(RegisteredDepartmentDAO registeredDepartmentDAO) { this.registeredDepartmentDAO = registeredDepartmentDAO; }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onCalculateResults() {
        List<Candidate> allCandidates = candidateDAO.findAll();
        allCandidates.sort(Comparator.comparing(Candidate::getMoria).reversed());

        for (Candidate candidate : allCandidates) {
            for (RegisteredDepartment rd : mixanografikoDAO.findMixanografiko(candidate.getIdNumber()).getRegisteredDepartments()) {
                if(rd.getDepartment().getRemainingPositions() > 0) {
                    rd.getDepartment().setEnterBase(candidate.getMoria());
                    candidate.setFinalDepartment(rd.getDepartment());
                    rd.getDepartment().setRemainingPositions(rd.getDepartment().getRemainingPositions() - 1);
                    break;
                }
            }
        }
    }
}
