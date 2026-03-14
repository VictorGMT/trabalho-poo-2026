package com.oz.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Carrega configurações comuns da aplicação.
 *
 * @author Tiago Inaba
 */
public class Config {
	private static String dbUrl = "jdbc:sqlite:oz.db";
	private static Logger logger = Logger.getLogger(Config.class.getName());

	public static String getDbUrl() {
		return dbUrl;
	}

	public static void load() {
		logger.finest("carregando configuração");
		Properties appSettings = new Properties();
		try (FileInputStream fis = new FileInputStream("config.properties")) {
			appSettings.load(fis);
			dbUrl = (String) appSettings.get("DB_URL");
			logger.finest("configuração carregada");
		} catch (IOException e) {
			logger.warning("impossível carregar config.properties, utilizando configuração padrão");
		}
	}
}
