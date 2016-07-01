package toy.json.ignore;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Base
 *
 * Created by cc on 16/6/18.
 */
public class BaseTest {

    private String name;

    @JsonIgnore
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
