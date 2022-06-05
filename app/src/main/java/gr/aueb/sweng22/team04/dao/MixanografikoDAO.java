package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Mixanografiko;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for lesson DAO Memory and methods to access it
 */

public interface MixanografikoDAO {

    /**
     * adds a mixanografiko to list
     * @param entity mixanografiko
     */
    void addMixanografiko(Mixanografiko entity);

    /**
     * finds mixanografiko based on the given id number
     * @param IDNumber
     * @return mixanografiko based on the given id number
     */
    Mixanografiko findMixanografiko(String IDNumber);

    /**
     * returns all mixanografika
     * @return  mixanografika
     */
    List<Mixanografiko> findAll();

    /**
     * deletes one mixanografiko
     * @param mixanografiko
     */
    void delete(Mixanografiko mixanografiko);
}
