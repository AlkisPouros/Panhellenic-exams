package gr.aueb.sweng22.team04.model;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for registered department
 */

public class RegisteredDepartment {

    private int position;
    private Department department;

    /**
     * constructor for registered department
     * @param position
     * @param department
     */
    public RegisteredDepartment(int position, Department department) {
        this.position = position;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
