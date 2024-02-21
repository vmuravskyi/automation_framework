package com.app.test.ui;

import org.junit.Before;

import com.app.framework.base.DriverContext;
import com.app.framework.base.FrameworkInitialize;
import com.app.framework.config.ConfigReader;
import com.app.framework.config.Settings;

public class TestInitialize extends FrameworkInitialize {

	@Before
	public void initialize() {
		ConfigReader.readConfig();
		initializeBrowser(Settings.BROWSER_TYPE);
		DriverContext.browser.goToUrl(Settings.AUT);
	}

}
