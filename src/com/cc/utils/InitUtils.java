package com.cc.utils;

import java.sql.Connection;
import java.sql.Statement;

public class InitUtils {

	public static void main(String[] args) {
		createDatabase();
		createTables();
		//dropDatabase();
	}

	public static void createDatabase() {
		Connection con = null;
		Statement st=  null;
		try {
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();

			String sql = "CREATE DATABASE " + JdbcUtils.DBNAME;
			st.execute(sql);
			System.out.println("Create database: " + JdbcUtils.DBNAME);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	public static void dropDatabase() {
		Connection con = null;
		Statement st = null;
		try {
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();

			String sql = "DROP DATABASE " + JdbcUtils.DBNAME;
			st.execute(sql);
			System.out.println("Drop database: " + JdbcUtils.DBNAME);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	public static void createTables() {
		Connection con = null;
		Statement st = null;
		try {
			con = JdbcUtils.getConnection();
			st = con.createStatement();

			String sql = "CREATE TABLE member("
					+ "id INT PRIMARY KEY,"
					+ "studentNum INT UNIQUE,"
					+ "name VARCHAR(20) NOT NULL,"
					+ "college VARCHAR(40),"
					+ "dateOfBirth DATETIME,"
					+ "gender VARCHAR(10),"
					+ "phone INT,"
					+ "intro VARCHAR(100)"
					+ ")";
			st.execute(sql);
			System.out.println("Create table: member");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}


}
