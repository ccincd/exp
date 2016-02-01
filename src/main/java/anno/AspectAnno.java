package anno;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * AspectAnno
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午5:04
 */
@Component
@Aspect
public class AspectAnno {

    @Around("@annotation(anno.Fruit)")
    public Object proxyRequestTemplate(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();

            Fruit fruit = null;
            if (method.isAnnotationPresent(Fruit.class)) {
                fruit = method.getAnnotation(Fruit.class);
            }

            if (fruit != null) {
                System.out.println("fruit count: " + fruit.counter());
                System.out.println("fruit color: " + fruit.color().name());
            }

            System.out.println("before proceed");
            result = joinPoint.proceed();
            System.out.println("after proceed");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
