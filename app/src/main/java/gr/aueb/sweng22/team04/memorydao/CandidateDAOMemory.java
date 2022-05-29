package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Department;

public class CandidateDAOMemory implements CandidateDAO {
    protected static ArrayList<Candidate> candidateEntities = new ArrayList<Candidate>();

    @Override
    public void addCandidate(Candidate entity) {
        candidateEntities.add(entity);
    }

    @Override
    public Candidate findCandidate(String email, String password) {
        for (Candidate candidate : candidateEntities){
            if (candidate.getEmail().equals(email) && candidate.getPassword().equals(password)) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public List<Candidate> findAll() {
        ArrayList<Candidate> result = new ArrayList<Candidate>();
        result.addAll(candidateEntities);
        return result;
    }

    @Override
    public void delete(Candidate candidate) {
        candidateEntities.remove(candidate);
    }
}
