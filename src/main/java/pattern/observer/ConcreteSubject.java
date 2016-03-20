package pattern.observer;

import org.apache.commons.lang.StringUtils;

/**
 * 主题类
 *
 * Created by cc on 16/3/20.
 */
public class ConcreteSubject extends AbstractSubject implements ISubject {

    private String subjectState = StringUtils.EMPTY;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
