package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.ScientificField;

public interface ScientificFieldDAO {
    void addScientificField(ScientificField entity);

    ScientificField findScientificField(String name);

    List<ScientificField> findAll();

    void delete(ScientificField scientificField);
}
