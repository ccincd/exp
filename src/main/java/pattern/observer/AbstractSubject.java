package pattern.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 抽象主题类
 *
 * Created by cc on 16/3/20.
 */
public abstract class AbstractSubject implements ISubject {

    private List<IObserver> list = Lists.newArrayList();

    @Override public void attach(IObserver observer) {
        list.add(observer);
    }

    /**
     * If this list does not contain the element, it is unchanged
     */
    @Override public void detach(IObserver observer) {
        list.remove(observer);
    }

    @Override public void notifyObservers() {
        for (IObserver observer : list) {
            observer.update();
        }
    }
}
