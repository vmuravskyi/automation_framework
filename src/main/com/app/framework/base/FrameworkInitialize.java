package com.app.framework.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkInitialize extends Base {

	protected static final Logger LOGGER = LogManager.getLogger(FrameworkInitialize.class);

	public void initializeBrowser(BrowserType type) {
		LOGGER.info("Initializing browser [{}]", String.valueOf(type));
		switch (type) {
			case CHROME -> DriverContext.driver = WebDriverManager.chromedriver().create();
			case FIREFOX -> DriverContext.driver = WebDriverManager.firefoxdriver().create();
			case SAFARI -> DriverContext.driver = WebDriverManager.safaridriver().create();
			case IE -> DriverContext.driver = WebDriverManager.iedriver().create();
		}
		DriverContext.browser = new Browser(DriverContext.driver);
	}

}
