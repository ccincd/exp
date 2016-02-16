package toy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Fruit
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午4:57
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Fruit {
    int counter() default 0;;

    Color color() default Color.GREEN;

    public enum Color {
        RED, GREEN, YELLOW, WHITE
    }
}
