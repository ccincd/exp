package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * TestMain
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 上午11:49
 */
@Aspect
@Component
public class AspectPoint {
    @Before("execution(public * aspect.AspectMain.*(..))")
    public void doIt() {
        System.out.println("do it!");
    }
}
