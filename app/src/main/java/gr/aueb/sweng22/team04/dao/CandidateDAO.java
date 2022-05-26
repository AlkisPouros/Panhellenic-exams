package gr.aueb.sweng22.team04.dao;


import java.util.ArrayList;

import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Department;

public interface CandidateDAO {


    void addCandidate(Candidate entity);

    Candidate findCandidate(String email, String password);

    ArrayList<Department> getAvailableDeparmtentsperUser();

}
