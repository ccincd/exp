package toy.basic.inner;

/**
 * 局部内部类——定义在方法内部的类
 *
 * Created by cc on 16/4/11.
 */
public class LocalInnerClass {

    private int age;

    public LocalInnerClass(int age) {
        this.age = age;
    }

    public void testLocalInnerClass() {

        /**
         * 声明要在定义之前，否则会报编译错误
         */
        // LocalInner notFound = new LocalInner("not found");

        String notFinalStr = "notFinalStr";

        final String finalString = "finalString";

        /**
         * 可见性在方法体内，因而定义访问修饰符并无用途
         */
        class LocalInner {

            String hobbit;

            LocalInner(String hobbit) {
                this.hobbit = hobbit;
            }

            void print() {
                System.out.println(hobbit);
                System.out.println(LocalInnerClass.this.age);

                /**
                 * 不能访问非final的局部变量
                 */
                // System.out.println(notFinalStr);
                System.out.println(finalString);
            }
        }

        LocalInner localInner = new LocalInner("Sleeping");
        localInner.print();
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass(25);

        localInnerClass.testLocalInnerClass();
    }
}
