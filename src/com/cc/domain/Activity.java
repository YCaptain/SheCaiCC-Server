package com.cc.domain;

import java.util.Date;

public class Activity {

	private int id;
	private String name;
	private Date startDay;
	private Date endDay;
	private String location;
	private double cost;
	private String intro;

	public Activity() {}

	public Activity(int id, String name, Date startDay, Date endDay, String location,
			double cost, String intro) {
		this.id = id;
		this.name = name;
		this.startDay = startDay;
		this.endDay = endDay;
		this.location = location;
		this.cost = cost;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
