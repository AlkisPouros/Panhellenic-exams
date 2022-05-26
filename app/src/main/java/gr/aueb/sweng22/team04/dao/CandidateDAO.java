package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Candidate;

public interface CandidateDAO {
    
    void addCandidate(Candidate entity);

    Candidate findCandidate(String email, String password);

    List<Candidate> findAll();

    void delete(Candidate candidate);
}
