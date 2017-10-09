package com.cc.domain;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		// instantiate member object by factory
		memberDao = DaoFactory.getInstance().createMemberDao();
		System.out.println("Create member instance");
	}

	public void regist(Member member) {
		if (member == null)
			System.out.println("Invalid registration information!!");
		else
			memberDao.addMember(member);
	}

	public Member query(int memberId) {
		Member member = memberDao.getMemberById(memberId);
		if (member == null)
			System.out.println("The query result is empty!!");
		else
			System.out.println(member.toString());
		return memberDao.getMemberById(memberId);
	}

	public void update(Member member) {
		if (member.getId() <= 0)
			System.out.println("Member id is invalid and cannot be updated");
		else
			memberDao.update(member);
	}

	public void delete(Member member) {
		if (member.getId() <= 0)
			System.out.println("Member id is invalid and cannot be deleted");
		else
			memberDao.delete(member);
	}

}
