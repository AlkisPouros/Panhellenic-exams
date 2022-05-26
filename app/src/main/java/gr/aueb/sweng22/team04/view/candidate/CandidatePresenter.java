package gr.aueb.sweng22.team04.view.candidate;

import java.util.ArrayList;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.model.Department;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public class CandidatePresenter {
    private CandidateView view;
    private CandidateDAO candidateDAO;
    private MarkedLessonDAO markedLessonDAO;
    private LessonDAO lessonDAO;
    private DepartmentDAO departmentDAO;
    private MixanografikoDAO mixanografikoDAO;
    private ArrayList<MarkedLesson> allMarks;

    public CandidatePresenter(CandidateView view, CandidateDAO candidateDAO, MarkedLessonDAO markedLessonDAO, LessonDAO lessonDAO, DepartmentDAO departmentDAO, MixanografikoDAO mixanografikoDAO)
    {
        this.view = view;
        this.candidateDAO = candidateDAO;
        this.markedLessonDAO = markedLessonDAO;
        this.lessonDAO = lessonDAO;
        this.departmentDAO = departmentDAO;
        this.mixanografikoDAO = mixanografikoDAO;
    }

    void onCalculateMarks()
    {
        double totalMark = 0;
        /*
        for(MarkedLesson markedLesson: this.markedLessonDAO.getMarkedLessons()){
            totalMark += markedLesson.getMark() * (2 + markedLesson.getLesson().getCoefficient());
        }

         */
        totalMark *= 100;
        this.candidateDAO.findCandidate("email","password").setMoria((int) totalMark);
    }
     void onFindAvailableDepartments()
     {
         /*
        for(Department department : this.departmentDAO.getDepartments())
        {
            if(this.candidateDAO.findCandidate("email","password").getMoria()>= department.getEBE() && this.candidateDAO.findCandidate("email","password").getField().getName().equals(department.getField().getName()))
            {
                this.candidateDAO.getAvailableDeparmtentsperUser().add(department);
            }
        }
          */
     }
}
