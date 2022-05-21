package gr.aueb.sweng22.team04.dao;

import gr.aueb.sweng22.team04.model.Mixanografiko;
import gr.aueb.sweng22.team04.model.ScientificField;

public interface ScientificFieldDAO {
    void add(ScientificField entity);

    ScientificField find(int ID);
}
