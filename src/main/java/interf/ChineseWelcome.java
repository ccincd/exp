package interf;

/**
 * 接口的具体实现类之一 用中文来欢迎
 *
 * Created by cc on 16/5/1.
 */
public class ChineseWelcome implements Welcome {

    @Override public void sayHello() {
        System.out.println("你好");
    }
}
