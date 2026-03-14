package com.oz.db;

import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;
import com.oz.config.Config;

public class DatabaseFactory {
	private static final SQLiteDataSource dataSource;

	static {
		dataSource = new SQLiteDataSource();
		dataSource.setUrl(Config.getDbUrl());
		dataSource.setEnforceForeignKeys(true);
		dataSource.setJournalMode("WAL");
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
