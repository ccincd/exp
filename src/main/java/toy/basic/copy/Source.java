/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.basic.copy;

/**
 * Source
 *
 * @author cc
 * @version 1.0, 16/9/8
 */
public class Source {

    private String hi;

    private String there;

    private Integer age;

    public Source() {
    }

    public Source(Integer age, String hi, String there) {
        this.age = age;
        this.hi = hi;
        this.there = there;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getThere() {
        return there;
    }

    public void setThere(String there) {
        this.there = there;
    }
}
