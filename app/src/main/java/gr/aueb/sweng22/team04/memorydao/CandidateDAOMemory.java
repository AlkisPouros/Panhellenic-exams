package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.model.Candidate;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface candidate DAO
 */

public class CandidateDAOMemory implements CandidateDAO {
    protected static ArrayList<Candidate> candidateEntities = new ArrayList<Candidate>();

    /**
     * adds a candidate to list
     * @param entity the candidate
     */
    @Override
    public void addCandidate(Candidate entity) {
        candidateEntities.add(entity);
    }

    /**
     * finds candidate bases on the given email and password
     * @param email
     * @param password
     * @return candidate with this email and password or null
     */
    @Override
    public Candidate findCandidate(String email, String password) {
        for (Candidate candidate : candidateEntities){
            if (candidate.getEmail().equals(email) && candidate.getPassword().equals(password)) {
                return candidate;
            }
        }
        return null;
    }

    /**
     * finds candidate based on the given firstname and lastname in order to mark one marked lesson
     * @param firstName
     * @param lastName
     * @return  Candidate with this firstname and password or null
     */
    @Override
    public Candidate findCandidateToMark(String firstName, String lastName) {
        for(Candidate candidate : candidateEntities){
            if(candidate.getName().equals(firstName) && candidate.getLastName().equals(lastName)){
                return candidate;
            }
        }
        return null;
    }

    /**
     * returns all the candidates
     * @return  Candidates
     */
    @Override
    public List<Candidate> findAll() {
        ArrayList<Candidate> result = new ArrayList<Candidate>();
        result.addAll(candidateEntities);
        return result;
    }

    /**
     * deletes one candidate
     * @param candidate
     */
    @Override
    public void delete(Candidate candidate) {
        candidateEntities.remove(candidate);
    }
}
