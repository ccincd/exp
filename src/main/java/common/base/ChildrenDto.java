package common.base;

/**
 * hi
 *
 * Created by cc on 16/6/23.
 */
public class ChildrenDto {

    private Boolean completed;

    private Long caseId;

    private StuffDto lessStuff;

    private StuffDto mainStuff;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public StuffDto getLessStuff() {
        return lessStuff;
    }

    public void setLessStuff(StuffDto lessStuff) {
        this.lessStuff = lessStuff;
    }

    public StuffDto getMainStuff() {
        return mainStuff;
    }

    public void setMainStuff(StuffDto mainStuff) {
        this.mainStuff = mainStuff;
    }
}
