package controller.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * User
 *
 * @author chi.chen
 * @date 16-3-7
 * @time 下午1:36
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8343439268593145911L;

    /**
     * Size注解验证对象（Array,Collection,Map,String）长度是否在给定的范围之内 Length注解只验证String的长度范围
     */
    @NotNull(message = "姓名不能为空")
    @Size(min = 2, max = 25, message = "姓名长度在2~25范围内")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "年龄最小为1岁")
    @Max(value = 100, message = "年龄最大为100岁")
    private Integer age;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "住址不能为空")
    private String address;

    /**
     * get传参可以使用&friends=cc,dd,ee,ff的形式
     */
    @NotEmpty(message = "不能没有朋友")
    private List<String> friends;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Pattern(regexp = "^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$", message = "手机号不合法")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", email='" + email + '\'' + ", address='" + address
                + '\'' + ", friends=" + friends + ", date='" + date + '\'' + ", phoneNumber='" + phoneNumber + '\''
                + '}';
    }
}
