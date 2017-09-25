package com.cc.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cc.utils.JdbcUtils;

public class MemberDaoImpl implements MemberDao {

	/**
	 * add member
	 */
	@Override
	public void addMember(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO member(id, studentNum, name, college, dateOfBirth,"
					+ "gender, phone, intro)" + " VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, member.getId());
			ps.setInt(2, member.getStudentNum());
			ps.setString(3, member.getName());
			ps.setString(4, member.getCollege());
			ps.setDate(5, new Date(member.getDateOfBirth().getTime()));
			ps.setString(6, member.getGender());
			ps.setInt(7, member.getPhone());
			ps.setString(8, member.getIntro());
			int count = ps.executeUpdate();
			System.out.println("Add member record: " + count);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	/**
	 * get member by id
	 */
	@Override
	public Member getMemberById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM member WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setId(id);
				member.setStudentNum(rs.getInt("studentNum"));
				member.setName(rs.getString("name"));
				member.setCollege(rs.getString("college"));
				member.setDateOfBirth(rs.getDate("dateOfBirth"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getInt("phone"));
				member.setIntro(rs.getString("intro"));
				return member;
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, ps, con);
		}
		return null;
	}

	/**
	 * update member
	 */
	@Override
	public int update(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "UPDATE member SET studentNum = ?, name = ?, college = ?,"
					+ "dateOfBirth = ?, gender = ?, phone = ?, intro = ? WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, member.getStudentNum());
			ps.setString(2, member.getName());
			ps.setString(3, member.getCollege());
			ps.setDate(4, new Date(member.getDateOfBirth().getTime()));
			ps.setString(5, member.getGender());
			ps.setInt(6, member.getPhone());
			ps.setString(7, member.getIntro());
			ps.setInt(8, member.getId());
			int count = ps.executeUpdate();
			System.out.println("Update member record: " + count);
			return count;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	/**
	 * delete member
	 */
	@Override
	public int delete(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM member WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, member.getId());
			int count = ps.executeUpdate();
			System.out.println("Delete member record: " + count);
			return count;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

}
