package com.hwadee.model;


import java.io.Serializable;

/**
 * 课程实体类
 */
public class Course implements Serializable {



    private String sno;//学号
    private String sname;//姓名
    private String cno;//课程号
    private String cname;//课程名称
    private String cteacher;//执教老师
    private int Ccredit;//学分
    private double grade;//成绩

    public Course(){

    }
    public Course(String sno,String sname,String cno,String cname,String cteacher,int Ccredit, double grade){
        sno=this.sno;
        sname=this.sname;
        cno=this.cno;
        cname=this.cname;
        cteacher=this.cteacher;
        Ccredit=this.Ccredit;
        grade=this.grade;
    }

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", Ccredit=" + Ccredit +
                ", grade=" + grade +
                '}';
    }
}
