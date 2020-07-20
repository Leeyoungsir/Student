package com.hwadee.model;

import java.io.Serializable;

/**
 * @Author LH
 * @Description 院系实体类
 * @Date Create in 10:03 2020/7/20
 */
public class Department implements Serializable {
    private String dno;//院系号
    private String dname;//院系名

    public Department() {
    }

    public Department(String dno, String dname) {
        this.dno = dno;
        this.dname = dname;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
