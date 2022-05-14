package gr.aueb.sweng22.team04.model;

import gr.aueb.sweng22.team04.Helper;

public class Examiner extends User {

    private String firstName;
    private String lastName;
    private Lesson academicRole;

    public Examiner(String firstName, String lastName, String password, String email) {
        super(password, email, "Examiner");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Boolean loginExaminer(String email, String password){
        return loginUser(email, password);
    }

    public Candidate findCandidate(int idCandidate){
        for(Candidate candidate : Helper.allCandidates){
            if(idCandidate == candidate.getId()){
                return candidate;
            }
        }
        return null;
    }

    public void saveMarks(int idCandidate, double mark){
        Candidate candidate = findCandidate(idCandidate);
        MarkedLesson markedLesson = new MarkedLesson(this.academicRole, mark, this);
        candidate.addMark(markedLesson);
    }

    public MarkedLesson saveMarksTemp(int idCandidate, double mark){
        MarkedLesson markedLesson = new MarkedLesson(this.academicRole, mark, this);
        return markedLesson;
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
