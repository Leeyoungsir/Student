package com.hwadee.model;

import java.io.Serializable;

/**
 * @Author LH
 * @Description 用户实体类
 * @Date Create in 9:55 2020/7/20
 */
public class User implements Serializable {
    private int id;
    private String username;//用户名
    private String password;//密码
    private String level;//权限等级，0为普通用户，1为管理员
    private String sno;//用户对应的学生账号

    public User() {
    }

    public User(int id, String username, String password, String level, String sno) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.sno = sno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }
}
