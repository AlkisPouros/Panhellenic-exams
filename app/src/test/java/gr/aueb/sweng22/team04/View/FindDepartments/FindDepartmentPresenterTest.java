package gr.aueb.sweng22.team04.View.FindDepartments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.DepartmentDAOMemory;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.view.FindDepartment.FindDepartmentPresenter;

public class FindDepartmentPresenterTest {

    FindDepartmentPresenter presenter;
    FindDepartmentViewStub viewStub;

    @Before
    public void setUp()
    {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        viewStub = new FindDepartmentViewStub();
        presenter = new FindDepartmentPresenter();

        presenter.setView(viewStub);

        presenter.setDepartmentDAO(new DepartmentDAOMemory());
    }

    /**
     * this method checks that the correct department is found by inserting department's id
     */
    @Test
    public void onFindDepartment()
    {
        Department department = presenter.getDepartmentDAO().findDepartment(333);
        presenter.onFindDepartment(department.getDepartmentID());
        assertEquals(333,department.getDepartmentID());
        department = presenter.getDepartmentDAO().findDepartment(457);
        assertEquals(457,department.getDepartmentID());
        assertNotEquals(000,department.getDepartmentID());
    }
}
