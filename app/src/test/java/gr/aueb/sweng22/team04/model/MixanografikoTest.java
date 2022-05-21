package gr.aueb.sweng22.team04.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MixanografikoTest {

    @Test
    public void registerDepartment(){
        ScientificField field = new ScientificField(4,"4o pedio", 4);
        Mixanografiko mixanografiko = new Mixanografiko();
        Department department1 = new Department("OPA", 333, 120, field);
        department1.setEBE(15000);
        Department department2 = new Department("PAPEI", 785, 666, field);
        department2.setEBE(13000);
        Department department3 = new Department("EMP", 158, 200, field);
        department3.setEBE(18000);
        mixanografiko.registerDepartment(1, department1);
        mixanografiko.registerDepartment(2, department3);
        mixanografiko.registerDepartment(3, department2);
        assertEquals(3, mixanografiko.getRegisteredDepartments().size());
        assertSame(department3, mixanografiko.getRegisteredDepartments().get(1).getDepartment());
    }
}