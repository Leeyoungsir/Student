package com.hwadee.model;

import java.io.Serializable;

public class Sc implements Serializable {
			
	private static final long serialVersionUID = 1L;

	private String sno;//学号
	private String cno;//课程号
	private double grade;//成绩

	public Sc() {
	}

	public Sc(String sno, String cno, double grade) {
		this.sno = sno;
		this.cno = cno;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Sc{" +
				"sno='" + sno + '\'' +
				", cno='" + cno + '\'' +
				", grade=" + grade +
				'}';
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}
