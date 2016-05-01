package interf;

/**
 * 接口的具体实现类之一 用英文来欢迎
 *
 * Created by cc on 16/5/1.
 */
public class EnglishWelcome implements Welcome {

    @Override public void sayHello() {
        System.out.println("Hello");
    }
}
