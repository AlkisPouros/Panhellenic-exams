package gr.aueb.sweng22.team04.model;

public class Department {

    private String departmentName;
    private int departmentID;
    private int maxNumberOfCandidates;
    private ScientificField field;
    private int remainingPositions;
    private int EBE;
    private int enterBase;

    public Department(String departmentName, int departmentID, int maxNumberOfCandidates, ScientificField field) {
        this.departmentName = departmentName;
        this.departmentID = departmentID;
        this.maxNumberOfCandidates = maxNumberOfCandidates;
        this.remainingPositions = maxNumberOfCandidates;
        this.field = field;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getRemainingPositions() {
        return remainingPositions;
    }

    public void setEBE(int EBE){
        this.EBE = EBE;
        this.enterBase = EBE;
    }

    public int getEnterBase() {
        return enterBase;
    }

    public void setEnterBase(int enterBase) {
        this.enterBase = enterBase;
    }

    public void setRemainingPositions(int remainingPositions) {
        this.remainingPositions = remainingPositions;
    }

    public int getEBE() {
        return EBE;
    }

    public ScientificField getField() {
        return field;
    }
}
