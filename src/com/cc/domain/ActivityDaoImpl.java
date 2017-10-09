package com.cc.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cc.utils.JdbcUtils;

public class ActivityDaoImpl implements ActivityDao {

	@Override
	public void addActivity(Activity activity) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO activity(id, name, startDay, endDay, location, cost, intro)"
					+ " VALUES(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, activity.getId());
			ps.setString(2, activity.getName());
			ps.setDate(3, new Date(activity.getStartDay().getTime()));
			ps.setDate(4, new Date(activity.getEndDay().getTime()));
			ps.setString(5, activity.getLocation());
			ps.setDouble(6, activity.getCost());
			ps.setString(7, activity.getIntro());
			int count = ps.executeUpdate();
			System.out.println("Add activity record: " + count);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	@Override
	public Activity getActivityById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM activity WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Activity activity = new Activity();
				activity.setId(id);
				activity.setName(rs.getString("name"));
				activity.setStartDay(rs.getDate("startDay"));
				activity.setEndDay(rs.getDate("endDay"));
				activity.setLocation(rs.getString("location"));
				activity.setCost(rs.getInt("cost"));
				activity.setIntro(rs.getString("intro"));
				return activity;
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, ps, con);
		}
		return null;
	}

	@Override
	public int update(Activity activity) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "UPDATE activity SET name = ?, startDay = ?,"
					+ "endDay = ?, location = ?, cost = ?, intro = ? WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, activity.getName());
			ps.setDate(2, new Date(activity.getStartDay().getTime()));
			ps.setDate(3, new Date(activity.getEndDay().getTime()));
			ps.setString(4, activity.getLocation());
			ps.setDouble(5, activity.getCost());
			ps.setString(6, activity.getIntro());
			ps.setInt(7, activity.getId());
			int count = ps.executeUpdate();
			System.out.println("Update activity record: " + count);
			return count;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, ps, con);
		}
	}

	@Override
	public int delete(Activity activity) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM activity WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, activity.getId());
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
