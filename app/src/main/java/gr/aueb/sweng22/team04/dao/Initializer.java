package gr.aueb.sweng22.team04.dao;
import java.util.Date;

import gr.aueb.sweng22.team04.model.*;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData() {
        eraseData();


        ScientificFieldDAO scientificFieldDAO = getScientificFieldDAO();

        scientificFieldDAO.add(new ScientificField(1,"1o pedio", 4));
        scientificFieldDAO.add(new ScientificField(2,"2o pedio", 4));
        scientificFieldDAO.add(new ScientificField(3,"3o pedio", 4));
        scientificFieldDAO.add(new ScientificField(4,"4o pedio", 4));
        
        
        LessonDAO lessonDAO = getLessonDAO();  // Χρησιμοποιούμε την addLesson στο DAO, μάλλον δεν πρέπει

        Lesson lesson = new Lesson("Math", 1.3, scientificFieldDAO.find(3));
        scientificFieldDAO.find(4).addLesson(new Lesson("Math", 1.3, scientificFieldDAO.find(4)));
        lessonDAO.add(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.find(3));
        scientificFieldDAO.find(4).addLesson(new Lesson("AOTH", 0.7, scientificFieldDAO.find(4)));
        lessonDAO.add(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.find(3));
        scientificFieldDAO.find(4).addLesson(new Lesson("AEPP", 0, scientificFieldDAO.find(4)));
        lessonDAO.add(lesson);
        lesson = new Lesson("Math", 1.3, scientificFieldDAO.find(3));
        scientificFieldDAO.find(4).addLesson(new Lesson("Ekthesi", 0, scientificFieldDAO.find(4)));
        lessonDAO.add(lesson);


        ExaminerDAO examinerDAO = getExaminerDAO(); // assignAcademicRole ?

        Examiner examiner = new Examiner("examiner", "examiner", "1234", "exam@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findByName("Math"));
        examinerDAO.add(examiner);
        examiner = new Examiner("examiner1", "examiner1", "12342321", "exam1@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findByName("AOTH"));
        examinerDAO.add(examiner);
        examiner = new Examiner("examiner2", "examiner2", "12345241", "exam2@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findByName("AEPP"));
        examinerDAO.add(examiner);
        examiner = new Examiner("examiner3", "examiner3", "12346743", "exam3@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findByName("Ekthesi"));
        examinerDAO.add(examiner);


        DepartmentDAO departmentDAO = getDepartmentDAO(); // setEBE ?

        Department department = new Department("OPA", 333, 120, scientificFieldDAO.find(4));
        department.setEBE(15000);
        departmentDAO.add(department);
        department = new Department("PAPEI", 457, 150, scientificFieldDAO.find(4));
        department.setEBE(16000);
        departmentDAO.add(department);
        department = new Department("EMP", 425, 250, scientificFieldDAO.find(2));
        department.setEBE(18500);
        departmentDAO.add(department);
        department = new Department("EKPA", 125, 180, scientificFieldDAO.find(4));
        department.setEBE(17000);
        departmentDAO.add(department);


        CandidateDAO candidateDAO = getCandidateDAO();

        Candidate candidate = new Candidate("1234", "hello@gmail.com", "tester", "tester", new Date(), "AK457841", scientificFieldDAO.find(4));
        candidateDAO.add(candidate);
        candidate = new Candidate("1234555", "hello3@gmail.com", "tester32", "tester32", new Date(), "AK467841", scientificFieldDAO.find(4));
        candidateDAO.add(candidate);
        candidate = new Candidate("1234414", "hello2@gmail.com", "tester22", "tester22", new Date(), "AK457541", scientificFieldDAO.find(4));
        candidateDAO.add(candidate);


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
