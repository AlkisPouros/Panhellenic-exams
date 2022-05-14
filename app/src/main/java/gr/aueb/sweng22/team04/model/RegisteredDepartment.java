package gr.aueb.sweng22.team04.model;

public class RegisteredDepartment {

    private int position;
    private Department department;

    public RegisteredDepartment(int position, Department department) {
        this.position = position;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
