package jvm;

/**
 * MethodHandlerTest
 *
 * Created by cc on 16/6/13.
 */
public class MethodHandlerTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        //
    }
}
