package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Candidate;

public interface CandidateDAO {
    
    void add(Candidate entity);

    Candidate find(int ID);
    
}
