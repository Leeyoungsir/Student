package com.hwadee.model;

import java.io.Serializable;

public class SC implements Serializable {
			
	private static final long serialVersionUID = 1L;

	private String sno;//学号
	private String sname;//姓名

	private String cno;//课程号
	private String cname;//课程名称
	private double grade;//成绩
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		cname = cname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		sname = sname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setGrade(double grade) {
		grade = grade;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		cno = cno;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		grade = grade;
	}
}
