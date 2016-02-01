package anno;

import org.springframework.stereotype.Component;

/**
 * AnnoMain
 *
 * @author chi.chen
 * @date 16-2-1
 * @time 下午5:25
 */
@Component
public class AnnoMain {

    @Fruit(counter = 5)
    public void helloAnno() {
        System.out.println("hello annotation");
    }
}
