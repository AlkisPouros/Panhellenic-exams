package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Mixanografiko;

public interface MixanografikoDAO {
    void add(Mixanografiko entity);

    Mixanografiko find(int ID);
}
