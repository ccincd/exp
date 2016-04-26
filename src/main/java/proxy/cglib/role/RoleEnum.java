/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.cglib.role;

import toy.enums.EnumTrait;

import java.util.Objects;

/**
 * @author chichen  Date: 16-4-26 Time: 下午6:53
 */
public enum RoleEnum implements EnumTrait {

    ORDINARY_USER(1, "普通用户"),
    REGISTER_MEMBER(2, "普通注册会员"),
    VIP_MEMBER(3, "VIP会员"),
    EMPLOYEE(4, "内部员工"),
    EDITOR(5, "内容编辑员"),
    ADMIN(6, "普通系统管理员"),
    SUPER_ADMIN(7, "超级系统管理员"),
    OTHER(8, "其他人员");

    private final Integer code;

    private final String text;

    RoleEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static RoleEnum codeOf(Integer code) {
        for (RoleEnum roleEnum : values()) {
            if (Objects.equals(code, roleEnum.code)) {
                return roleEnum;
            }
        }

        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
