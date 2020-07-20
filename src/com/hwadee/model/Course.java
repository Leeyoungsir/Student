package com.hwadee.model;

import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cno;//课程号
    private String cname;//课程名称
    private String cteacher;//执教老师
    private int  Ccredit;//学分

    public Course() {
    }

    public Course(String cno, String cname, String cteacher, int ccredit) {
        this.cno = cno;
        this.cname = cname;
        this.cteacher = cteacher;
        Ccredit = ccredit;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", Ccredit=" + Ccredit +
                '}';
    }
}
