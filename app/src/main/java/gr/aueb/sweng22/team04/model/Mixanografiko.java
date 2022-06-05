package gr.aueb.sweng22.team04.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * model for mixanografiko
 */

public class Mixanografiko {

    private int mixanografikoID;
    private Date registrationDate;
    private ArrayList<RegisteredDepartment> registeredDepartments = new ArrayList<RegisteredDepartment>();
    private String CandidateIDNumber;

    /**
     * constructor for mixanografiko
     * @param CandidateIDNumber
     */
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public ArrayList<RegisteredDepartment> getRegisteredDepartments() {
        return registeredDepartments;
    }
}
