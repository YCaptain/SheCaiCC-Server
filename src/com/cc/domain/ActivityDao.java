package com.cc.domain;

public interface ActivityDao {

	public void addActivity(Activity activity);

	public Activity getActivityById(int id);

	public int update(Activity activity);

	public int delete(Activity activity);

}
