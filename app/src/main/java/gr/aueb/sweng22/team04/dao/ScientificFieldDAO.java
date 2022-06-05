package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.ScientificField;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for scientific field DAO Memory and methods to access it
 */

public interface ScientificFieldDAO {

    /**
     * adds a scientific field to list
     * @param entity scientific field
     */
    void addScientificField(ScientificField entity);

    /**
     * finds a scientific field based on the given scientific field's name
     * @param name scientific field name
     * @return a scientific field
     */
    ScientificField findScientificField(String name);

    /**
     * returns all the scientific fields
     * @return all scientific fields
     */
    List<ScientificField> findAll();

    /**
     * delete one scientific field
     * @param scientificField
     */
    void delete(ScientificField scientificField);
}
