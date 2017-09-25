package com.cc.domain;

import java.util.Date;

public class Member {

	private int id;
	private int studentNum;
	private String name;
	private String college;
	private Date dateOfBirth;
	private String gender;
	private int phone;
	private String intro;

	public Member() {}

	public Member(int id, int studentNum, String name, String college, Date dateOfBirth,
			String gender, int phone, String intro) {
		this.id = id;
		this.studentNum = studentNum;
		this.name = name;
		this.college = college;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", student number: " + studentNum + ", name: "
				+ name + ", college: " + college + ", dateOfBirth: " + dateOfBirth +
				", gender: " + gender + ", phone: " + phone + ", intro: " + intro + "]";
	}
}
