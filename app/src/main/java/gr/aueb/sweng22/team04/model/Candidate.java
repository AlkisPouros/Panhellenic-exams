package gr.aueb.sweng22.team04.model;

import java.util.Date;
import java.util.ArrayList;

import gr.aueb.sweng22.team04.Helper;

public class Candidate extends User{

    private String name;
    private String lastName;
    private Date birthday;
    private String idNumber;
    private ArrayList<Department> availableDepartmentperUser = new ArrayList<Department>();
    private ArrayList<MarkedLesson> allMarks = new ArrayList<MarkedLesson>();
    private Mixanografiko mixanografiko;
    private int moria;
    private ScientificField field;
    private Department finalDepartment;


    public Candidate(String password, String email, String name, String lastName, Date birthday, String idNumber, ScientificField field) {
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

    public void signUp(String password, String email, String name, String lastName, Date birthday, String idNumber, ScientificField field){
        Candidate candidate = new Candidate(password, email, name, lastName, birthday, idNumber, field);
        Helper.allCandidates.add(candidate);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public ArrayList<Department> getAvailableDepartmentperUser() {
        return availableDepartmentperUser;
    }

    public void setAvailableDepartmentperUser(ArrayList<Department> availableDepartmentperUser) {
        this.availableDepartmentperUser = availableDepartmentperUser;
    }

    public ScientificField getField() {
        return field;
    }

    public Mixanografiko getMixanografiko() {
        return mixanografiko;
    }

    public void createMixanografiko() {
        this.mixanografiko = new Mixanografiko();
        this.findAvailableDepartments();
    }

    public int getMoria() {
        return moria;
    }

    public void setMoria(int moria) {
        this.moria = moria;
    }

    public void calculateMarks(){
        double totalMark = 0;
        for(MarkedLesson lesson: this.allMarks){
            totalMark += lesson.getMark() * (2 + lesson.getLesson().getCoefficient());
        }
        totalMark *= 100;
        setMoria((int) totalMark);
    }

    public void addMark(MarkedLesson markedLesson){
        this.allMarks.add(markedLesson);
    }

    public ArrayList<MarkedLesson> getAllMarks(){
        return this.allMarks;
    }

    public void findAvailableDepartments(){
        for(Department department : Helper.allDepartments){
            if(this.getMoria() >= department.getEBE() && this.getField().equals(department.getField())){
                this.availableDepartmentperUser.add(department);
            }
        }
        this.setAvailableDepartmentperUser(this.availableDepartmentperUser);
    }
}
