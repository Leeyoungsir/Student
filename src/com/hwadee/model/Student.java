package com.hwadee.model;

import java.io.Serializable;

/**
 * @Author LH
 * @Description 学生实体类
 * @Date Create in 9:59 2020/7/20
 */
public class Student implements Serializable {
    private String sno;//学号
    private String sname;//姓名
    private String ssex;//性别，F:女，M:男
    private int sage;//年龄
    private int syear;//所在年级
    private String smajor;//专业
    private String c_no;//所在班级

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getSyear() {
        return syear;
    }

    public void setSyear(int syear) {
        this.syear = syear;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public String getC_no() {
        return c_no;
    }

    public void setC_no(String c_no) {
        this.c_no = c_no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", syear=" + syear +
                ", smajor='" + smajor + '\'' +
                ", c_no='" + c_no + '\'' +
                '}';
    }
}
