package com.hwadee.model;

import java.io.Serializable;

/**
 * @Author LH
 * @Description 课程实体类
 * @Date Create in 9:50 2020/7/20
 */
public class Class implements Serializable {
    private String c_no;//班级号
    private String c_name;//班级名
    private String dno;//所属院系

    public Class(String c_no, String c_name, String dno) {
        this.c_no = c_no;
        this.c_name = c_name;
        this.dno = dno;
    }

    public Class() {
    }

    public String getC_no() {
        return c_no;
    }

    public void setC_no(String c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    @Override
    public String toString() {
        return "Class{" +
                "c_no='" + c_no + '\'' +
                ", c_name='" + c_name + '\'' +
                ", dno='" + dno + '\'' +
                '}';
    }
}
