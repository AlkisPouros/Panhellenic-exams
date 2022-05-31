package gr.aueb.sweng22.team04.View.examiner;

import gr.aueb.sweng22.team04.view.examiner.ExaminerView;

public class ExaminerViewStub implements ExaminerView {

    private int errorCount;
    private int goodCount;
    private Boolean status = true;

    @Override
    public void showCandidateNotFound() {
        errorCount++;
        status = false;
    }

    @Override
    public void emptyField() {
        errorCount++;
        status = false;
    }

    @Override
    public void saveMarkStatus() {
        goodCount++;
        status = true;
    }

    @Override
    public void emptyMark() {
        errorCount++;
        status = false;
    }

    @Override
    public void invalidMark() {
        errorCount++;
        status = false;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public Boolean getStatus() {
        return status;
    }
}
