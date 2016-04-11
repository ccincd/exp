package toy.basic.inner;

import toy.basic.Person;

/**
 * 外部类中常规内部类
 *
 * 内部类中不能有静态成员
 * this指针指向的是内部类对象
 * 内部类可以通过OuterAndNormalInnerClass.this的方式访问外部类的对象
 *
 * 如果一个内部类不依赖于其外部类的实例变量，或与实例变量无关，则选择应用静态内部类
 *
 * Created by cc on 16/4/11.
 */
public class OuterAndNormalInnerClass {

    private int age;

    private String name;

    private Person friend;

    class Hobbit {

        private String hobi;

        Hobbit(String hobi) {
            this.hobi = hobi;
        }

        void printAttribs() {
            System.out.println(OuterAndNormalInnerClass.this.age);
            System.out.println(OuterAndNormalInnerClass.this.name);
            System.out.println(OuterAndNormalInnerClass.this.friend);

            System.out.println(hobi);
        }
    }

    public OuterAndNormalInnerClass(Person friend, int age, String name) {
        this.friend = friend;
        this.age = age;
        this.name = name;
    }

    /**
     * 创建内部类对象的方式一
     */
    public void createAndPrintInnerClass() {
        Hobbit hobbit = new Hobbit("climbing");
        System.out.println(hobbit.hobi);
    }

    public static void main(String[] args) {
        OuterAndNormalInnerClass innerClass =
                new OuterAndNormalInnerClass(new Person(28, "joy"), 35, "steve");

        innerClass.createAndPrintInnerClass();

        /**
         * 创建内部类对象的方式二
         * 要通过外部类对象来创建内部类对象
         *
         * 不合法的两种使用方式:
         * new OuterAndNormalInnerClass.Hobbit("hobbit")
         * OuterAndNormalInnerClass.new Hobbit("hobbit")
         */
        OuterAndNormalInnerClass.Hobbit hobbitOne = innerClass.new Hobbit("video games");
        OuterAndNormalInnerClass.Hobbit hobbitTwo = innerClass.new Hobbit("cards");

        /**
         * hobbitOne和hobbitTwo共用一个OuterAndNormalInnerClass对象
         */
        hobbitOne.printAttribs();
        hobbitTwo.printAttribs();
    }
}
