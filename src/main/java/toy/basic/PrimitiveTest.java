package toy.basic;

/**
 * 输出的str和anotherStr是3520.0
 *
 * Created by cc on 16/3/19.
 */
public class PrimitiveTest {

    public static void main(String[] args) {
        Double d = 3520.00;

        String str = d.toString();
        String anotherStr = String.valueOf(d);
        System.out.println(str);
        System.out.println(anotherStr);
    }
}
