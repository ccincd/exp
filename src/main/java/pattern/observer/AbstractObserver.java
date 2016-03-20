package pattern.observer;

/**
 * 抽象观察者类
 *
 * Created by cc on 16/3/20.
 */
public abstract class AbstractObserver implements IObserver {

    @Override public abstract void update();

    @Override public void update(IState state) {
        //
    }
}
