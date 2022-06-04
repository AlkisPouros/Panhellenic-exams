package gr.aueb.sweng22.team04.view.candidate;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.DepartmentDAO;
import gr.aueb.sweng22.team04.dao.LessonDAO;
import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.dao.MixanografikoDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.MarkedLesson;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * candidate presenter
 */

public class CandidatePresenter {
    private CandidateView view;
    private CandidateDAO candidateDAO;
    private MarkedLessonDAO markedLessonDAO;
    private LessonDAO lessonDAO;
    private DepartmentDAO departmentDAO;
    private MixanografikoDAO mixanografikoDAO;
    private String email;
    private String password;

    public void setMarkedLessonDAO(MarkedLessonDAO markedLessonDAO) {
        this.markedLessonDAO = markedLessonDAO;
    }

    public void setLessonDAO(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public void setMixanografikoDAO(MixanografikoDAO mixanografikoDAO) {
        this.mixanografikoDAO = mixanografikoDAO;
    }

    public void setView(CandidateView view) {
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void setEmail(String email){this.email = email; }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){this.password = password; }

    public String getPassword() {
        return password;
    }

    public CandidateDAO getCandidateDAO(){return candidateDAO; }

    /**
     * calculates the final mark of a candidate with this formula by iterating in marked lessons
     * @return  int total mark
     */
    public int onCalculateMarks()
    {
        double totalMark = 0;
        Candidate candidate = this.candidateDAO.findCandidate(email,password);

        for(MarkedLesson markedLesson : markedLessonDAO.findAll())
        {
            if(markedLesson.getCandidateID()==candidate.getId())
            {
                totalMark += markedLesson.getMark() * (2 + markedLesson.getLesson().getCoefficient());
            }
        }
        totalMark *= 100;
        candidate.setMoria((int) totalMark);
        return (int)totalMark;
    }
}
