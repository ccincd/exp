package pattern.observer;

/**
 * 观察者接口
 *
 * Created by cc on 16/3/20.
 */
public interface IObserver {

    void update();

    void update(IState state);
}
