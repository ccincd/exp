package pattern.observer;

/**
 * 主题接口
 *
 * Created by cc on 16/3/20.
 */
public interface ISubject {

    void attach(IObserver IObserver);

    void detach(IObserver IObserver);

    void notifyObservers();
}
