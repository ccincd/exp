package common.base;

/**
 * TestConverterDto
 *
 * Created by cc on 16/6/23.
 */
public class TestConverterDto {

    private Boolean isCompleted;

    private Long caseId;

    private String lessStuff;

    private String mainStuff;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getLessStuff() {
        return lessStuff;
    }

    public void setLessStuff(String lessStuff) {
        this.lessStuff = lessStuff;
    }

    public String getMainStuff() {
        return mainStuff;
    }

    public void setMainStuff(String mainStuff) {
        this.mainStuff = mainStuff;
    }

    @Override
    public String toString() {
        return "TestConverterDto{" +
                "caseId=" + caseId +
                ", isCompleted=" + isCompleted +
                ", lessStuff='" + lessStuff + '\'' +
                ", mainStuff='" + mainStuff + '\'' +
                '}';
    }
}
