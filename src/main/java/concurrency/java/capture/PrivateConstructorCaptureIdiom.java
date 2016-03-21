package concurrency.java.capture;

/**
 * Tester
 *
 * Created by cc on 16/3/20.
 */

class Thing {
    public Thing(int i) {
        System.out.println(i);
    }
}

class SomeOtherClass {
    static int func(float f) {
        return Math.round(f);
    }
}

public class PrivateConstructorCaptureIdiom extends Thing{

    private final int arg;

    public PrivateConstructorCaptureIdiom() {
        /**
         * 提示在调用父类构造函数之前不能访问子类对象
         *
         * Cannot refer to an instance field arg while explicitly invoking a constructor
         */
        /*super(arg = Math.round(12L));*/
        // super(12);
        // 可以直接赋值
        // arg = 10;

        // super(SomeOtherClass.func(5.12f));
        /**
         * Call to super must be first statement in constructor body
         */
        // super(i);
        // arg = SomeOtherClass.func(5.12f);
        this(SomeOtherClass.func(5.12f));
    }

    private PrivateConstructorCaptureIdiom(int i) {
        super(i);
        arg = i;
    }

    public static void main(String[] args) {
        PrivateConstructorCaptureIdiom captureIdiom = new PrivateConstructorCaptureIdiom();

        System.out.println(captureIdiom);
    }
}
