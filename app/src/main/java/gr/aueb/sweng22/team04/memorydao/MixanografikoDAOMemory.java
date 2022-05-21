package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.model.Mixanografiko;
import gr.aueb.sweng22.team04.model.Mixanografiko;

public class MixanografikoDAOMemory implements MixanografikoDAO {
    protected static ArrayList<Mixanografiko> entities = new ArrayList<Mixanografiko>();

    @Override
    public void add(Mixanografiko entity) {
        entities.add(entity);
    }

    @Override
    public Mixanografiko find(int ID) {
        for (Mixanografiko now : entities)
            if (now.getMixanografikoID() == ID)
                return now;

        return null;
    }
}
