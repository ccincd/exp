package aspect;

import org.springframework.stereotype.Component;

/**
 * AspectPoint
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午12:00
 */
@Component
public class AspectMain {

    public void sayHi() {
        System.out.println("Hi, there");
        throw new RuntimeException("Exception");
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void helloWorld() {
        System.out.println("Hello World!");
    }
}
