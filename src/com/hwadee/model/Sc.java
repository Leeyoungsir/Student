package com.hwadee.model;

import java.io.Serializable;

public class Sc implements Serializable {
			
	private static final long serialVersionUID = 1L;

	private String sno;//学号
	private String sname;//姓名
    private String cteacher;//执教老师
	private String cno;//课程号
	private String cname;//课程名称
	private double grade;//成绩

	public Sc() {
	}

	public Sc(String sno, String sname, String cno, String cname, double grade) {
		this.sno = sno;
		this.sname = sname;
		this.cno = cno;
		this.cname = cname;
		this.grade = grade;
	}

	public String getSno() {
		return this.sno;
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

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	@Override
	public String toString() {
		return "Sc{" +
				"sno='" + sno + '\'' +
				", sname='" + sname + '\'' +
				", cteacher='" + cteacher + '\'' +
				", cno='" + cno + '\'' +
				", cname='" + cname + '\'' +
				", grade=" + grade +
				'}';
	}
}
