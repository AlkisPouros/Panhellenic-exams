package gr.aueb.sweng22.team04.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Mixanografiko {

    private int mixanografikoID;
    private Date registrationDate;
    private ArrayList<RegisteredDepartment> registeredDepartments = new ArrayList<RegisteredDepartment>();

    public Mixanografiko(){
        Random rand = new Random();
        this.mixanografikoID = rand.nextInt();
        this.registrationDate = new Date();
    }

    public int getMixanografikoID() {
        return mixanografikoID;
    }

    public void registerDepartment(int position, Department department){
        RegisteredDepartment registeredDepartment = new RegisteredDepartment(position, department);
        this.registeredDepartments.add(registeredDepartment);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public ArrayList<RegisteredDepartment> getRegisteredDepartments() {
        return registeredDepartments;
    }
}
