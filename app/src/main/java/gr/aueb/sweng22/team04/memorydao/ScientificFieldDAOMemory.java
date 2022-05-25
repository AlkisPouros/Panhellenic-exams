package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;
import gr.aueb.sweng22.team04.model.ScientificField;

public class ScientificFieldDAOMemory implements ScientificFieldDAO {
    protected static ArrayList<ScientificField> scientificFieldEntities = new ArrayList<ScientificField>();

    @Override
    public void addScientificField(ScientificField entity) {
        scientificFieldEntities.add(entity);
    }

    public ScientificField findScientificField(String name) {
        for (ScientificField scientificField : scientificFieldEntities) {
            if (scientificField.getName() == name) {
                return scientificField;
            }
        }
        return null;
    }
}
