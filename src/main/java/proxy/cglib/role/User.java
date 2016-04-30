/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.cglib.role;

/**
 * http://blog.csdn.net/xiaohai0504/article/details/6832990
 *
 * @author chichen  Date: 16-4-26 Time: 下午6:53
 */
public class User {

    private RoleEnum role;

    private String name;

    private Integer age;

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

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
}
