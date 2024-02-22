package com.app.test.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.framework.base.DriverContext;
import com.app.framework.base.FrameworkInitialize;
import com.app.framework.config.ConfigReader;
import com.app.framework.config.Settings;
import com.app.framework.pages.HomePage;
import com.app.framework.pages.LoginPage;

public class LoginTest extends FrameworkInitialize {

	private String username = "admin";
	private String password = "password";

	@Before
	public void initialize() {
		ConfigReader.readConfig();
		initializeBrowser(Settings.BROWSER_TYPE);
		DriverContext.browser.goToUrl(Settings.AUT);
	}

	@After
	public void tearDown() {
		DriverContext.driver.close();
		DriverContext.driver.quit();
	}

	@Test
	public void login() throws InterruptedException {
		Thread.sleep(2000);

		HomePage homePage = new HomePage();
		homePage.clickLogin();

		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

		Thread.sleep(2000);
	}

	@Test
	public void testToFail() {
		assert false;
	}

}
