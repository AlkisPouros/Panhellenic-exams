package gr.aueb.sweng22.team04.model;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for examiner
 */

public class Examiner extends User {

    private String firstName;
    private String lastName;
    private Lesson academicRole;

    /**
     * constructor for examiner
     * @param firstName
     * @param lastName
     * @param password
     * @param email
     */
    public Examiner(String firstName, String lastName, String password, String email) {
        super(password, email, "Examiner");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Boolean loginExaminer(String email, String password){
        return loginUser(email, password);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Lesson getAcademicRole() {
        return this.academicRole;
    }

    public void assignAcademicRole(Lesson academicRole) {
        if(this.academicRole != null){
            return;
        }
        this.academicRole = academicRole;
    }
}
