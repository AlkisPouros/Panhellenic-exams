package gr.aueb.sweng22.team04.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Mixanografiko {

    private int mixanografikoID;
    private Date registrationDate;
    private ArrayList<RegisteredDepartment> registeredDepartments = new ArrayList<RegisteredDepartment>();
    private String CandidateIDNumber;

    public Mixanografiko(String CandidateIDNumber){
        Random rand = new Random();
        this.mixanografikoID = rand.nextInt();
        this.registrationDate = new Date();
        this.CandidateIDNumber = CandidateIDNumber;
    }
    public String getCandidateIDNumber(){
        return this.CandidateIDNumber;
    }

    public int getMixanografikoID() {
        return mixanografikoID;
    }
    /*
    public void registerDepartment(int position, Department department){
        RegisteredDepartment registeredDepartment = new RegisteredDepartment(position, department);
        this.registeredDepartments.add(registeredDepartment);
    }
    */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public ArrayList<RegisteredDepartment> getRegisteredDepartments() {
        return registeredDepartments;
    }
}
