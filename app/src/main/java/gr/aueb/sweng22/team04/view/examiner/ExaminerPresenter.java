package gr.aueb.sweng22.team04.view.examiner;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.ExaminerDAO;
import gr.aueb.sweng22.team04.dao.MarkedLessonDAO;
import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.Examiner;
import gr.aueb.sweng22.team04.model.MarkedLesson;

public class ExaminerPresenter {

    private ExaminerView view;
    private CandidateDAO candidateDAO;
    private ExaminerDAO examinerDAO;
    private ScientificFieldDAO scientificFieldDAO;
    private MarkedLessonDAO markedLessonDAO;

    public ExaminerView getView(){
        return this.view;
    }

    public void setView(ExaminerView view){
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO){
        this.candidateDAO = candidateDAO;
    }

    public void setScientificFieldDAO(ScientificFieldDAO scientificFieldDAO){
        this.scientificFieldDAO = scientificFieldDAO;
    }

    public void setExaminerDAO(ExaminerDAO examinerDAO){
        this.examinerDAO = examinerDAO;
    }

    public void setMarkedLessonDAO(MarkedLessonDAO markedLessonDAO){
        this.markedLessonDAO = markedLessonDAO;
    }

    public Candidate onFindCandidate(String firstName, String lastName){
        if(firstName.isEmpty() || lastName.isEmpty()){
            view.emptyField();
            return null;
        }

        Candidate candidate = candidateDAO.findCandidateToMark(firstName, lastName);
        if(candidate == null){
            view.showCandidateNotFound();
        }else{
            return candidate;
        }
        return null;
    }

    public Examiner onFindExaminer(int ID){
        return examinerDAO.findExaminer(ID);
    }

    public void onSaveMark(Examiner examiner, Candidate candidate, double mark){

        if(mark <= 0 || mark >= 20){
            view.invalidMark();
        }else{
            MarkedLesson markedLesson = new MarkedLesson(examiner.getAcademicRole(), mark, examiner, candidate.getId());
            markedLessonDAO.addMarkedLesson(markedLesson);
            view.saveMarkStatus();
        }
    }
}
