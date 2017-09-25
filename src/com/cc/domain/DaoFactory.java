package com.cc.domain;

import java.io.FileInputStream;
import java.util.Properties;

public class DaoFactory {
	/**
	 * Singleton
	 */
	private static MemberDao memberDao = null;
	private static DaoFactory instance = new DaoFactory();

	private DaoFactory() {
		/**
		 * read properties to load Dao layers
		 */
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/com/cc/domain/daoconfig.properties");
			prop.load(fis);
			String className = prop.getProperty("memberDaoClass");
			Class<?> clazz = Class.forName(className);
			memberDao = (MemberDao) clazz.newInstance();
			fis.close();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public MemberDao createMemberDao() {
		return memberDao;
	}

}
