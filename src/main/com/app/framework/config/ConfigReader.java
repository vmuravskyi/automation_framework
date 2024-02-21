package com.app.framework.config;

import java.io.IOException;
import java.util.Properties;

import com.app.framework.base.BrowserType;

public class ConfigReader {

	public static void readConfig() {
		new ConfigReader().read();
	}

	public void read() {
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/global-config.properties"));

			Settings.AUT = properties.getProperty("AUT");
			Settings.DB_CONNECTION_STRING = properties.getProperty("DB_CONNECTION_STRING");
			Settings.DB_DRIVER_TYPE = properties.getProperty("DB_DRIVER_TYPE");
			Settings.REPORTING_CONNECTION_STRING = properties.getProperty("REPORTING_CONNECTION_STRING");
			Settings.LOG_PATH = properties.getProperty("LOG_PATH");
			Settings.EXCEL_SHEET_PATH = properties.getProperty("EXCEL_SHEET_PATH");
			Settings.BROWSER_TYPE = BrowserType.valueOf(properties.getProperty("BROWSER_TYPE"));

		} catch (IOException e) {
			throw new RuntimeException("Error reading configuration file", e);
		}
	}

}
