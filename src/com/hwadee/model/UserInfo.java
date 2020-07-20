/**
 *@Author xuiexizhang
 *@Description UserInfo
 */


package com.hwadee.model;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String level;
    private String sno;

    public UserInfo() {

    }

    public UserInfo(int id, String username, String password, String level, String sno) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.sno = sno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLevel() {
        return level;
    }

    public String getPassword() {
        return password;
    }

    public String getSno() {
        return sno;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }


}
