package pattern.observer;

/**
 * 客户端测试代码
 * 实例描述：客户支付了订单款项，这时财务需要开具发票，出纳需要记账，配送员需要配货
 *
 * Created by cc on 16/3/20.
 */
public class ClientTest {

    public static void main(String[] args) {
        // 新建主题
        ConcreteSubject subject = new ConcreteSubject();

        // 添加观察者
        subject.attach(new ConcreteObserver("s1", subject));
        subject.attach(new ConcreteObserver("s2", subject));
        subject.attach(new ConcreteObserver("s3", subject));
        subject.attach(new ConcreteObserver("s4", subject));

        // 状态变化
        subject.setSubjectState("s0");
        // 通知观察者
        subject.notifyObservers();
    }
}
