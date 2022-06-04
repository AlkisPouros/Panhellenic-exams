package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.model.Mixanografiko;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface mixanografiko DAO
 */

public class MixanografikoDAOMemory implements MixanografikoDAO {
    protected static ArrayList<Mixanografiko> mixanografikoEntities = new ArrayList<Mixanografiko>();

    /**
     * adds a mixanografiko to list
     * @param entity mixanografiko
     */
    @Override
    public void addMixanografiko(Mixanografiko entity) {
        mixanografikoEntities.add(entity);
    }

    /**
     * finds mixanografiko based on the given id number
     * @param IDNumber
     * @return mixanografiko based on the given id number or null
     */
    @Override
    public Mixanografiko findMixanografiko(String IDNumber) {
        for (Mixanografiko mixanografiko : mixanografikoEntities) {
            if (mixanografiko.getCandidateIDNumber().equals(IDNumber)) {
                return mixanografiko;
            }
        }
        return null;
    }

    /**
     * returns all mixanografika
     * @return  mixanografika
     */
    @Override
    public List<Mixanografiko> findAll() {
        ArrayList<Mixanografiko> result = new ArrayList<Mixanografiko>();
        result.addAll(mixanografikoEntities);
        return result;
    }

    /**
     * deletes one mixanografiko
     * @param mixanografiko
     */
    @Override
    public void delete(Mixanografiko mixanografiko) {
        mixanografikoEntities.remove(mixanografiko);
    }
}
