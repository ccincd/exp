package toy.json.bean;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Person
 *
 * @author chi.chen
 * @date 16-2-29
 * @time 下午8:34
 */
public class Person {

    /**
     * fastXml版
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;

    int age;

    /**
     * 1:male, 2:female
     */
    int gentle;

    /**
     * codeHouse版
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    String address;

    public Person(String name, int age, int gentle, String address) {
        this.name = name;
        this.age = age;
        this.gentle = gentle;
        this.address = address;
    }

    public Person(String name, int gentle, int age) {
        this.name = name;
        this.gentle = gentle;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGentle() {
        return gentle;
    }

    public void setGentle(int gentle) {
        this.gentle = gentle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", gentle=" + gentle + ", address='" + address
                + '\'' + '}';
    }
}
