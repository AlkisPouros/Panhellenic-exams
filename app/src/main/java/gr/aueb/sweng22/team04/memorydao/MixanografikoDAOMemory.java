package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.model.Mixanografiko;

public class MixanografikoDAOMemory implements MixanografikoDAO {
    protected static ArrayList<Mixanografiko> mixanografikoEntities = new ArrayList<Mixanografiko>();

    @Override
    public void addMixanografiko(Mixanografiko entity) {
        mixanografikoEntities.add(entity);
    }

    @Override
    public Mixanografiko findMixanografiko(int ID) {
        for (Mixanografiko mixanografiko : mixanografikoEntities) {
            if (mixanografiko.getMixanografikoID() == ID) {
                return mixanografiko;
            }
        }
        return null;
    }

    @Override
    public List<Mixanografiko> findAll() {
        ArrayList<Mixanografiko> result = new ArrayList<Mixanografiko>();
        result.addAll(mixanografikoEntities);
        return result;
    }

    @Override
    public void delete(Mixanografiko mixanografiko) {
        mixanografikoEntities.remove(mixanografiko);
    }
}
