/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package pattern.builder;

/**
 * @author chichen  Date: 16-4-18 Time: 下午5:28
 */
public class SimpleDemo {

    private final String name;

    private final Integer age;

    private final String phoneNum;

    private final String address;

    private final Integer gender;

    public static class Builder {

        private String name;

        private Integer age;

        private String phoneNum;

        private String address;

        private Integer gender;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder phoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public SimpleDemo build() {
            return new SimpleDemo(this);
        }
    }

    private SimpleDemo(Builder builder) {
        name = builder.name;
        age = builder.age;
        phoneNum = builder.phoneNum;
        address = builder.address;
        gender = builder.gender;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public Integer getGender() {
        return gender;
    }
}
