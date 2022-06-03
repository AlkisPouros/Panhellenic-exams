package gr.aueb.sweng22.team04.dao;
import java.io.Serializable;
import java.util.Date;

import gr.aueb.sweng22.team04.model.*;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData() {
        eraseData();

        UserDAO userDAO = getUserDAO();

        ScientificFieldDAO scientificFieldDAO = getScientificFieldDAO();

        scientificFieldDAO.addScientificField(new ScientificField("1o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("2o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("3o pedio", 4));
        scientificFieldDAO.addScientificField(new ScientificField("4o pedio", 4));
        
        
        LessonDAO lessonDAO = getLessonDAO();

        Lesson lesson = new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("AOTH", 0.7, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("AOTH", 0.7, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("AEPP", 0, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("AEPP", 0, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);
        lesson = new Lesson("Ekthesi", 0, scientificFieldDAO.findScientificField("4o pedio"));
        scientificFieldDAO.findScientificField("4o pedio").addLesson(new Lesson("Ekthesi", 0, scientificFieldDAO.findScientificField("4o pedio")));
        lessonDAO.addLesson(lesson);


        ExaminerDAO examinerDAO = getExaminerDAO();

        Examiner examiner = new Examiner("examiner", "examiner", "123456789", "exam@gmail.com");
        examiner.assignAcademicRole(lessonDAO.findLessonByName("Math"));
        examinerDAO.addExaminer(examiner);
        userDAO.addUser(examiner);
        Examiner examiner1 = new Examiner("examiner1", "examiner1", "12342321", "exam1@gmail.com");
        examiner1.assignAcademicRole(lessonDAO.findLessonByName("AOTH"));
        examinerDAO.addExaminer(examiner1);
        userDAO.addUser(examiner1);
        Examiner examiner3 = new Examiner("examiner2", "examiner2", "12345241", "exam2@gmail.com");
        examiner3.assignAcademicRole(lessonDAO.findLessonByName("AEPP"));
        examinerDAO.addExaminer(examiner3);
        userDAO.addUser(examiner3);
        Examiner examiner4 = new Examiner("examiner3", "examiner3", "12346743", "exam3@gmail.com");
        examiner4.assignAcademicRole(lessonDAO.findLessonByName("Ekthesi"));
        examinerDAO.addExaminer(examiner4);
        userDAO.addUser(examiner4);


        DepartmentDAO departmentDAO = getDepartmentDAO();

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

        Candidate candidate = new Candidate("12345678", "hello@gmail.com", "tester", "tester", "10/12/2001", "AK457841", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);
        int candidateID = candidate.getId();

        String candidateIDNumber = candidate.getIdNumber();

        userDAO.addUser(candidate);
        candidate = new Candidate("123455554352", "hello3@gmail.com", "tester32", "tester32", "10/12/2005", "AK467841", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);
        userDAO.addUser(candidate);
        candidate = new Candidate("12344144546", "hello2@gmail.com", "tester22", "tester22", "10/12/2012", "AK457541", scientificFieldDAO.findScientificField("4o pedio"));
        candidateDAO.addCandidate(candidate);
        userDAO.addUser(candidate);

        MarkedLessonDAO markedLessonDAO = getMarkedLessonDAO();
        Examiner examiner5 = new Examiner("alkis","alkis","12345678","alkis@gmail.com");
        examiner5.assignAcademicRole(lessonDAO.findLessonByName("Math"));
        MarkedLesson markedLesson = new MarkedLesson(new Lesson("Math", 1.3, scientificFieldDAO.findScientificField("4o pedio")),19,examiner5,candidateID);
        markedLessonDAO.addMarkedLesson(markedLesson);
        examiner5 = new Examiner("alkis","alkis","12345678","alkis@gmail.com");
        examiner5.assignAcademicRole(lessonDAO.findLessonByName("AOTH"));
        markedLesson = new MarkedLesson(new Lesson("AOTH", 0.7, scientificFieldDAO.findScientificField("4o pedio")),19.5,examiner5,candidateID);
        markedLessonDAO.addMarkedLesson(markedLesson);
        examiner5 = new Examiner("alkis","alkis","12345678","alkis@gmail.com");
        examiner5.assignAcademicRole(lessonDAO.findLessonByName("AEPP"));
        markedLesson = new MarkedLesson(new Lesson("AEPP", 0, scientificFieldDAO.findScientificField("4o pedio")),19,examiner5,candidateID);
        markedLessonDAO.addMarkedLesson(markedLesson);
        examiner5 = new Examiner("alkis","alkis","12345678","alkis@gmail.com");
        examiner5.assignAcademicRole(lessonDAO.findLessonByName("Ekthesi"));
        markedLesson = new MarkedLesson(new Lesson("Ekthesi", 0, scientificFieldDAO.findScientificField("4o pedio")),16,examiner5,candidateID);
        markedLessonDAO.addMarkedLesson(markedLesson);

        MixanografikoDAO mixanografikoDAO = getMixanografikoDAO();

        Mixanografiko mixanografiko = new Mixanografiko(candidateIDNumber);
        mixanografikoDAO.addMixanografiko(mixanografiko);

        RegisteredDepartmentDAO registrationDAO = getRegisteredDepartmentDAO();

        RegisteredDepartment registeredDepartment = new RegisteredDepartment(0,new Department("OPA", 333, 120, scientificFieldDAO.findScientificField("4o pedio")));
        registrationDAO.addRegisteredDepartment(registeredDepartment);
        registeredDepartment = new RegisteredDepartment(1,new Department("PAPEI", 457, 150, scientificFieldDAO.findScientificField("4o pedio")));
        registrationDAO.addRegisteredDepartment(registeredDepartment);
        registeredDepartment = new RegisteredDepartment(2,new Department("EKPA", 125, 180, scientificFieldDAO.findScientificField("4o pedio")));
        registrationDAO.addRegisteredDepartment(registeredDepartment);
    }

    public abstract CandidateDAO getCandidateDAO();

    public abstract DepartmentDAO getDepartmentDAO();

    public abstract ExaminerDAO getExaminerDAO();

    public abstract LessonDAO getLessonDAO();

    public abstract MarkedLessonDAO getMarkedLessonDAO();

    public abstract MixanografikoDAO getMixanografikoDAO();

    public abstract RegisteredDepartmentDAO getRegisteredDepartmentDAO();

    public abstract ScientificFieldDAO getScientificFieldDAO();

    public abstract UserDAO getUserDAO();

}
