package toy.json.ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Derived
 *
 * Created by cc on 16/6/18.
 */
public class DerivedTest extends BaseTest {

    @JsonIgnore
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        DerivedTest derivedTest = new DerivedTest();

        derivedTest.setAge(3);
        derivedTest.setAddress("hi");
        derivedTest.setName("hi");

        BaseTest baseTest = derivedTest;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String special = objectMapper.writeValueAsString(baseTest);
            String ordinary = objectMapper.writeValueAsString(derivedTest);

            System.out.println(special);
            System.out.println(ordinary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
