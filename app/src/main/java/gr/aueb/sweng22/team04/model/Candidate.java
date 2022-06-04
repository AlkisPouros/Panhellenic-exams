package gr.aueb.sweng22.team04.model;

import java.util.Date;
import java.util.ArrayList;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for candidate
 */

public class Candidate extends User{

    private String name;
    private String lastName;
    private String birthday;
    private String idNumber;
    private ArrayList<Department> availableDepartmentperUser = new ArrayList<Department>();
    private ArrayList<MarkedLesson> allMarks = new ArrayList<MarkedLesson>();
    private Mixanografiko mixanografiko;
    private int moria;
    private ScientificField field;
    private Department finalDepartment;

    /**
     * constructor for candidate
     * @param password
     * @param email
     * @param name
     * @param lastName
     * @param birthday
     * @param idNumber
     * @param field
     */
    public Candidate(String password, String email, String name, String lastName, String birthday, String idNumber, ScientificField field) {
        super(password, email, "Candidate");
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.field = field;
    }

    public Boolean loginCandidate(String email, String password){
        return loginUser(email, password);
    }

    public void signUp(String password, String email, String name, String lastName, String birthday, String idNumber, ScientificField field){
        Candidate candidate = new Candidate(password, email, name, lastName, birthday, idNumber, field);
        //Helper.allCandidates.add(candidate);
    }

    public Department getFinalDepartment() {
        return finalDepartment;
    }

    public void setFinalDepartment(Department finalDepartment) {
        this.finalDepartment = finalDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public ArrayList<Department> getAvailableDepartmentperUser() {
        return this.availableDepartmentperUser;
    }

    public ScientificField getField() {
        return field;
    }

    public Mixanografiko getMixanografiko() {
        return mixanografiko;
    }

    public int getMoria() {
        return moria;
    }

    public void setMoria(int moria) {
        this.moria = moria;
    }

    public ArrayList<MarkedLesson> getAllMarks(){
        return this.allMarks;
    }
}
