package toy.jvm.tutorial;

import net.sourceforge.sizeof.SizeOf;

public class Pilot{

    String name;
    int age;

    public Pilot(String a, int b){
        name = a;
        age = b;
    }

    public static void main(String[] args) {
        Pilot pilot = new Pilot("hi", 5);
        System.out.println(SizeOf.sizeOf(pilot));
    }
}
