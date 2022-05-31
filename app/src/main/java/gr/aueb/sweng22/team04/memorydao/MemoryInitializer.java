package gr.aueb.sweng22.team04.memorydao;

import java.io.Serializable;

import gr.aueb.sweng22.team04.dao.UserDAO;
import gr.aueb.sweng22.team04.model.*;
import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.dao.ExaminerDAO;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.dao.RegisteredDepartmentDAO;
import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;

public class MemoryInitializer extends Initializer {
    protected void eraseData() {

        for(ScientificField scientificField: getScientificFieldDAO().findAll()){
            getScientificFieldDAO().delete(scientificField);
        }

        for(Lesson lesson : getLessonDAO().findAll()){
            getLessonDAO().delete(lesson);
        }

        for(Examiner examiner : getExaminerDAO().findAll()){
            getExaminerDAO().delete(examiner);
        }

        for(Department department : getDepartmentDAO().findAll()){
            getDepartmentDAO().delete(department);
        }

        for(Candidate candidate : getCandidateDAO().findAll()){
            getCandidateDAO().delete(candidate);
        }

        for(MarkedLesson markedLesson : getMarkedLessonDAO().findAll()){
            getMarkedLessonDAO().delete(markedLesson);
        }
    }


    @Override
    public CandidateDAO getCandidateDAO() {
        return new CandidateDAOMemory();
    }

    @Override
    public DepartmentDAO getDepartmentDAO() {
        return new DepartmentDAOMemory();
    }

    @Override
    public ExaminerDAO getExaminerDAO() {
        return new ExaminerDAOMemory();
    }

    @Override
    public LessonDAO getLessonDAO() {
        return new LessonDAOMemory();
    }

    @Override
    public MarkedLessonDAO getMarkedLessonDAO() {
        return new MarkedLessonDAOMemory();
    }

    @Override
    public MixanografikoDAO getMixanografikoDAO() {
        return new MixanografikoDAOMemory();
    }

    @Override
    public RegisteredDepartmentDAO getRegisteredDepartmentDAO() {
        return new RegisteredDepartmentDAOMemory();
    }

    @Override
    public ScientificFieldDAO getScientificFieldDAO() {
        return new ScientificFieldDAOMemory();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMemory();
    }
}
