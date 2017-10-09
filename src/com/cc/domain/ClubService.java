package com.cc.domain;

public class ClubService {

	private ClubDao clubDao;

	public ClubService() {
		// instantiate club object by factory
		clubDao = DaoFactory.getInstance().createClubDao();
		System.out.println("Create club instance");
	}

	public void regist(Club club) {
		if (club == null)
			System.out.println("Invalid registration information!!");
		else
			clubDao.addClub(club);
	}

	public Club query(int memberId) {
		Club club = clubDao.getClubById(memberId);
		if (club == null)
			System.out.println("The query result is empty!!");
		else
			System.out.println(club.toString());
		return clubDao.getClubById(memberId);
	}

	public void update(Club club) {
		if (club.getId() <= 0)
			System.out.println("Club id is invalid and cannot be updated");
		else
			clubDao.update(club);
	}

	public void delete(Club club) {
		if (club.getId() <= 0)
			System.out.println("Club id is invalid and cannot be deleted");
		else
			clubDao.delete(club);
	}
}
