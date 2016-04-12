package toy.basic;

/**
 * Basic Bean
 *
 * Created by cc on 16/3/7.
 */
public class Person {

    private String name;

    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Person) {
            Person person = (Person) obj;
            boolean result = (
                    this.name.equals(person.getName()) && this.age == person.getAge());

            return result;
        }

        return false;
    }

    @Override public int hashCode() {
        return age * name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Override public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }*/
}
