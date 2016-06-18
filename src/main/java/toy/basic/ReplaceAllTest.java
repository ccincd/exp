package toy.basic;

/**
 * String替换测试
 *
 * Created by cc on 16/6/18.
 */
public class ReplaceAllTest {

    public static void main(String[] args) {
        String str = "四川.成都.成华区";
        System.out.println(str.replaceAll("\\.", "-"));
    }
}
