package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;
import gr.aueb.sweng22.team04.model.ScientificField;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface scientific field DAO
 */

public class ScientificFieldDAOMemory implements ScientificFieldDAO {
    protected static ArrayList<ScientificField> scientificFieldEntities = new ArrayList<ScientificField>();

    /**
     * adds a scientific field to list
     * @param entity scientific field
     */
    @Override
    public void addScientificField(ScientificField entity) {
        scientificFieldEntities.add(entity);
    }

    /**
     * finds a scientific field based on the given scientific field's name
     * @param name scientific field name
     * @return a scientific field or null
     */
    public ScientificField findScientificField(String name) {
        for (ScientificField scientificField : scientificFieldEntities) {
            if (scientificField.getName() == name) {
                return scientificField;
            }
        }
        return null;
    }

    /**
     * returns all the scientific fields
     * @return all scientific fields
     */
    @Override
    public List<ScientificField> findAll() {
        ArrayList<ScientificField> result = new ArrayList<ScientificField>();
        result.addAll(scientificFieldEntities);
        return result;
    }

    /**
     * delete one scientific field
     * @param scientificField
     */
    @Override
    public void delete(ScientificField scientificField){
        scientificFieldEntities.remove(scientificField);
    }
}
