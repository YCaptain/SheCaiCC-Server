package com.cc.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cc.utils.JdbcUtils;

public class ClubDaoImpl implements ClubDao {

	@Override
	public void addClub(Club club) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO club(id, masterId, name, buildDay, type, intro)"
					+ " VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, club.getId());
			ps.setInt(2, club.getMasterId());
			ps.setString(3, club.getName());
			ps.setDate(4, new Date(club.getBuildDay().getTime()));
			ps.setString(5, club.getType());
			ps.setString(6, club.getIntro());
			int count = ps.executeUpdate();
			System.out.println("Add club record: " + count);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	@Override
	public Club getClubById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM club WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Club club = new Club();
				club.setId(id);
				club.setMasterId(rs.getInt("masterId"));
				club.setName(rs.getString("name"));
				club.setBuildDay(rs.getDate("buildDay"));
				club.setType(rs.getString("type"));
				club.setIntro(rs.getString("intro"));
				return club;
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, ps, con);
		}
		return null;
	}

	@Override
	public int update(Club club) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "UPDATE club SET masterId = ?, name = ?, buildDay = ?, type = ?, intro = ?"
					+ " WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, club.getMasterId());
			ps.setString(2, club.getName());
			ps.setDate(3, new Date(club.getBuildDay().getTime()));
			ps.setString(4, club.getType());
			ps.setString(5, club.getIntro());
			ps.setInt(6, club.getId());
			int count = ps.executeUpdate();
			System.out.println("Update club record: " + count);
			return count;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	@Override
	public int delete(Club club) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM club WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, club.getId());
			int count = ps.executeUpdate();
			System.out.println("Delete club record: " + count);
			return count;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}





}
