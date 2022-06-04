package gr.aueb.sweng22.team04.view.examiner;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * view for examiner massages
 */
public interface ExaminerView {

    /**
     * shows message to examiner when the candidate with the given criteria is not found
     */
    void showCandidateNotFound();

    /**
     * shows message if their is an empty field
     */
    void emptyField();

    /**
     * shows message for successful save of marks
     */
    void saveMarkStatus();

    /**
     * show message for empty mark field
     */
    void emptyMark();

    /**
     * shows message when an invalid mark is entered
     */
    void invalidMark();
}
