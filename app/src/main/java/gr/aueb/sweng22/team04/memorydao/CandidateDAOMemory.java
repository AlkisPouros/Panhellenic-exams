package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.model.Candidate;

public class CandidateDAOMemory implements CandidateDAO {
    protected static ArrayList<Candidate> entities = new ArrayList<Candidate>();

    @Override
    public void add(Candidate entity) {
        entities.add(entity);
    }

    @Override
    public Candidate find(int ID) {
        for (Candidate now : entities)
            if (now.getId() == ID)
                return now;

        return null;
    }

}
