package pattern.observer;

/**
 * 观察者类
 *
 * Created by cc on 16/3/20.
 */
public class ConcreteObserver extends AbstractObserver implements IObserver{

    private ConcreteSubject subjectRef;

    private String strState;

    public ConcreteObserver(String strState, ConcreteSubject subjectRef) {
        this.strState = strState;
        this.subjectRef = subjectRef;
    }

    @Override public void update() {
        if (!strState.equals(subjectRef.getSubjectState())) {
            strState = subjectRef.getSubjectState();

            System.out.println("hi, changed");
        }
    }
}
