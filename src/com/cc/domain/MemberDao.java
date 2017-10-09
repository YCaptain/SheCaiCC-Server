package com.cc.domain;

public interface MemberDao {

	public void addMember(Member member);

	public Member getMemberById(int id);

	public int update(Member member);

	public int delete(Member member);

}
