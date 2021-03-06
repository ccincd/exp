package toy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(public * toy.aspect.AspectMain.*(..))")
    public void doIt() {
    }

    @Before("doIt()")
    public void before() {
        System.out.println("before");
    }

    @After("doIt()")
    public void after() {
        System.out.println("after");
    }

    @AfterThrowing("doIt()")
    public void afterThrowing() {
        System.out.println("after throwing");
    }

    @AfterReturning("doIt()")
    public void afterReturning() {
        System.out.println("after returning");
    }

    @Around("doIt()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result;
        String methodName = joinPoint.getSignature().getName();

        try {
            System.out.println("Method name: " + methodName);
            System.out.println("before proceed");
            result = joinPoint.proceed();
            System.out.println("after proceed");
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }

        return result;
    }
}
