package gr.aueb.sweng22.team04.dao;
import java.util.Date;

import gr.aueb.sweng22.team04.model.*;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData() {
        eraseData();


        ScientificFieldDAO scientificFieldDAO = getScientificFieldDAO();

        scientificFieldDAO.addScientificField(new ScientificField("1o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("2o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("3o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("4o pedio", 4));
        
        
        LessonDAO lessonDAO = getLessonDAO();  // Χρησιμοποιούμε την addLesson στο DAO, μάλλον δεν πρέπει

        Lesson lesson = new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("AOTH", 0.7, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("AEPP", 0, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("Ekthesi", 0, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);


        ExaminerDAO examinerDAO = getExaminerDAO(); // assignAcademicRole ?

        Examiner examiner = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findLessonByName("Math"));
        examinerDAO.addExaminer(examiner);
        examiner = new Examiner("examiner1", "examiner1", "12342321", "exam1@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findLessonByName("AOTH"));
        examinerDAO.addExaminer(examiner);
        examiner = new Examiner("examiner2", "examiner2", "12345241", "exam2@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findLessonByName("AEPP"));
        examinerDAO.addExaminer(examiner);
        examiner = new Examiner("examiner3", "examiner3", "12346743", "exam3@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findLessonByName("Ekthesi"));
        examinerDAO.addExaminer(examiner);


        DepartmentDAO departmentDAO = getDepartmentDAO(); // setEBE ?

        Department department = new Department("OPA", 333, 120, scientificFieldDAO.findScientificField("4o pedio"));
        department.setEBE(15000);
        departmentDAO.addDepartment(department);
        department = new Department("PAPEI", 457, 150, scientificFieldDAO.findScientificField("4o pedio"));
        department.setEBE(16000);
        departmentDAO.addDepartment(department);
        department = new Department("EMP", 425, 250, scientificFieldDAO.findScientificField("2o pedio"));
        department.setEBE(18500);
        departmentDAO.addDepartment(department);
        department = new Department("EKPA", 125, 180, scientificFieldDAO.findScientificField("4o pedio"));
        department.setEBE(17000);
        departmentDAO.addDepartment(department);


        CandidateDAO candidateDAO = getCandidateDAO();

        Candidate candidate = new Candidate("1234", "hello@gmail.com", "tester", "tester", new Date(), "AK457841", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);
        candidate = new Candidate("1234555", "hello3@gmail.com", "tester32", "tester32", new Date(), "AK467841", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);
        candidate = new Candidate("1234414", "hello2@gmail.com", "tester22", "tester22", new Date(), "AK457541", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);


    }

    public abstract CandidateDAO getCandidateDAO();

    public abstract DepartmentDAO getDepartmentDAO();

    public abstract ExaminerDAO getExaminerDAO();

    public abstract LessonDAO getLessonDAO();

    public abstract MarkedLessonDAO getMarkedLessonDAO();

    public abstract MixanografikoDAO getMixanografikoDAO();

    public abstract RegisteredDepartmentDAO getRegisteredDepartmentDAO();

    public abstract ScientificFieldDAO getScientificFieldDAO();


}
