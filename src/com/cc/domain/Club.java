package com.cc.domain;

import java.util.Date;

public class Club {

	private int id;
	private int masterId;
	private String name;
	private Date buildDay;
	private String type;
	private String intro;

	public Club() {}

	public Club(int id, int masterId, String name, Date buildDay, String type, String intro) {
		this.id = id;
		this.masterId = masterId;
		this.name = name;
		this.buildDay = buildDay;
		this.type = type;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBuildDay() {
		return buildDay;
	}

	public void setBuildDay(Date buildDay) {
		this.buildDay = buildDay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", name: " + name + ", buildDay: " + buildDay +
				", type: " + type + ", intro: " + intro + "]";
	}

}
