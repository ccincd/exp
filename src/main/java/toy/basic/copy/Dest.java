/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.basic.copy;

import org.springframework.beans.BeanUtils;

/**
 * Dest
 *
 * @author cc
 * @version 1.0, 16/9/8
 */
public class Dest {

    private String there;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getThere() {
        return there;
    }

    public void setThere(String there) {
        this.there = there;
    }

    public static void main(String[] args) {
        Dest dest = new Dest();
        Source source = new Source(3, "hi", "there");
        BeanUtils.copyProperties(source, dest);

        System.out.println(dest);
    }
}
