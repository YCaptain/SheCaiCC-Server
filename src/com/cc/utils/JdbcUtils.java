package com.cc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	public static String DBNAME = "CC";
	private static String DBUSER = "root";
	private static String DBPASS = "";

	private static String DBDRIVER = "com.mysql.jdbc.Driver";
	private static String DBBASICURL = "jdbc:mysql://localhost:3306??characterEncoding=gbk&useSSL=true";
	private static final String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?characterEncoding=gbk&useSSL=true";

	static {
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	private JdbcUtils() {
	}

	public static Connection getBasicConnection() throws SQLException {
		return DriverManager.getConnection(DBBASICURL, DBUSER, DBPASS);
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}

	public static void free(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
