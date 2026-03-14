package com.oz.db;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

/**
 * Classe que roda as migrations.
 *
 * @author Tiago Inaba
 */
public class MigrationRunner {
	public static void initDatabase(DataSource ds) {
		Flyway flyway = Flyway.configure().dataSource(ds).load();
		flyway.migrate();
	}
}
