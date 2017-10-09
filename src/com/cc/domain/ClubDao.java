package com.cc.domain;

public interface ClubDao {

	public void addClub(Club club);

	public Club getClubById(int id);

	public int update(Club club);

	public int delete(Club club);

}
