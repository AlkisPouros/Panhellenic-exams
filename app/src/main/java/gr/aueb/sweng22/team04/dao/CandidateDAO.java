package gr.aueb.sweng22.team04.dao;


import java.util.List;

import gr.aueb.sweng22.team04.model.Candidate;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for candidate DAO Memory and methods to access it
 */

public interface CandidateDAO {

    /**
     * Adds a candidate to list
     * @param entity the candidate
     */
    void addCandidate(Candidate entity);

    /**
     * finds candidate based on the given email and password
     * @param email
     * @param password
     * @return  Candidate with this email and password
     */
    Candidate findCandidate(String email, String password);

    /**
     * finds candidate based on the given firstname and lastname in order to mark one marked lesson
     * @param firstName
     * @param lastName
     * @return  Candidate with this firstname and password
     */
    Candidate findCandidateToMark(String firstName, String lastName);

    /**
     * returns all the candidates
     * @return  Candidates
     */
    List<Candidate> findAll();

    /**
     * deletes one candidate
     * @param candidate
     */
    void delete(Candidate candidate);
}
