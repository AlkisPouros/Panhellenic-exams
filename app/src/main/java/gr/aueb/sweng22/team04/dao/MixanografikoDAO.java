package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.Mixanografiko;

public interface MixanografikoDAO {
    void addMixanografiko(Mixanografiko entity);

    Mixanografiko findMixanografiko(int ID);

    List<Mixanografiko> findAll();

    void delete(Mixanografiko mixanografiko);
}
