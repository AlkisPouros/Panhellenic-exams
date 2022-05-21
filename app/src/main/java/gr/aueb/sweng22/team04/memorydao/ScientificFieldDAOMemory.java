package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;
import gr.aueb.sweng22.team04.model.ScientificField;
import gr.aueb.sweng22.team04.model.ScientificField;
import gr.aueb.sweng22.team04.model.ScientificField;

public class ScientificFieldDAOMemory implements ScientificFieldDAO {
    protected static ArrayList<ScientificField> entities = new ArrayList<ScientificField>();

    @Override
    public void add(ScientificField entity) {
        entities.add(entity);
    }

    public ScientificField find(int ID) {
        for (ScientificField now : entities)
            if (now.getID() == ID)
                return now;

        return null;
    }

}
