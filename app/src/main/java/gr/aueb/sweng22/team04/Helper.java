package gr.aueb.sweng22.team04;

import java.util.ArrayList;
import java.util.Date;

import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.Examiner;
import gr.aueb.sweng22.team04.model.Lesson;
import gr.aueb.sweng22.team04.model.RegisteredDepartment;
import gr.aueb.sweng22.team04.model.ScientificField;

public class Helper {

    public Helper(){}

    public static ArrayList<ScientificField> ScientificFields = new ArrayList<>();
    public static ArrayList<Department> allDepartments = new ArrayList<>();
    public static ArrayList<Examiner> allExaminers = new ArrayList<>();
    public static ArrayList<Lesson> allLessons = new ArrayList<>();
    public static ArrayList<Candidate> allCandidates = new ArrayList<>();

    public void initialiseScientificFields(){
        ScientificField field = new ScientificField(1,"1o pedio", 4);
        ScientificFields.add(field);
        field = new ScientificField(2,"2o pedio", 4);
        ScientificFields.add(field);
        field = new ScientificField(3,"3o pedio", 4);
        ScientificFields.add(field);
        field = new ScientificField(4,"4o pedio", 4);
        ScientificFields.add(field);
    }

    public void initialiseDepartments(){
        Department department = new Department("OPA", 333, 120, ScientificFields.get(3));
        department.setEBE(15000);
        allDepartments.add(department);
        department = new Department("PAPEI", 457, 150, ScientificFields.get(3));
        department.setEBE(16000);
        allDepartments.add(department);
        department = new Department("EMP", 425, 250, ScientificFields.get(2));
        department.setEBE(18500);
        allDepartments.add(department);
        department = new Department("EKPA", 125, 180, ScientificFields.get(3));
        department.setEBE(17000);
        allDepartments.add(department);
    }

    public void initialiseExaminers(){
        Examiner examiner = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner.assignAcademicRole(allLessons.get(0));
        allExaminers.add(examiner);
        examiner = new Examiner("examiner1", "examiner1", "12342321", "exam1@gmail.com");
        examiner.assignAcademicRole(allLessons.get(1));
        allExaminers.add(examiner);
        examiner = new Examiner("examiner2", "examiner2", "12345241", "exam2@gmail.com");
        examiner.assignAcademicRole(allLessons.get(2));
        allExaminers.add(examiner);
        examiner = new Examiner("examiner3", "examiner3", "12346743", "exam3@gmail.com");
        examiner.assignAcademicRole(allLessons.get(3));
        allExaminers.add(examiner);
    }

    public void initialiseLessons(){
        Lesson lesson = new Lesson("Math", 1.3, ScientificFields.get(3));
        ScientificFields.get(3).addLesson(lesson);
        allLessons.add(lesson);
        lesson = new Lesson("AOTH", 0.7, ScientificFields.get(3));
        ScientificFields.get(3).addLesson(lesson);
        allLessons.add(lesson);
        lesson = new Lesson("AEPP", 0, ScientificFields.get(3));
        ScientificFields.get(3).addLesson(lesson);
        allLessons.add(lesson);
        lesson = new Lesson("Ekthesi", 0, ScientificFields.get(3));
        ScientificFields.get(3).addLesson(lesson);
        allLessons.add(lesson);
    }

    public void initialiseCandidates(){
        Candidate candidate = new Candidate("1234", "hello@gmail.com", "tester", "tester", new Date(), "AK457841", ScientificFields.get(3));
        allCandidates.add(candidate);
        candidate = new Candidate("1234555", "hello3@gmail.com", "tester32", "tester32", new Date(), "AK467841", ScientificFields.get(3));
        allCandidates.add(candidate);
        candidate = new Candidate("1234414", "hello2@gmail.com", "tester22", "tester22", new Date(), "AK457541", ScientificFields.get(3));
        allCandidates.add(candidate);
    }

    public void calculateEnterBase(){
        //allCandidates.sort();
        for(Candidate candidate : allCandidates){
            for(RegisteredDepartment department : candidate.getMixanografiko().getRegisteredDepartments()){
                if(department.getDepartment().getRemainingPositions() > 0){
                   department.getDepartment().setEnterBase(candidate.getMoria());
                   candidate.setFinalDepartment(department.getDepartment());
                   department.getDepartment().setRemainingPositions(department.getDepartment().getRemainingPositions() - 1);
                   break;
                }
            }
        }
    }

    public static void main(String [] args){
        Helper helper = new Helper();

        helper.initialiseScientificFields();
        helper.initialiseLessons();
        helper.initialiseExaminers();
        helper.initialiseDepartments();
        helper.initialiseCandidates();
    }
}
