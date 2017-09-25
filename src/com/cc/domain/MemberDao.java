package com.cc.domain;

public interface MemberDao {

	//add a new member
	public void addMember(Member member);
	//inquire member by id
	public Member getMemberById(int id);
	//update member
	public int update(Member member);
	//delete member
	public int delete(Member member);

}
