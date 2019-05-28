package com.neuedu.common;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-11 16:20
 **/
public enum UserRoleEnum {

    ROLE_ADMIN(0, "管理员用户"),
    ROLE_USER(1, "普通用户");

    private int role;
    private String desc;

    UserRoleEnum(int role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
