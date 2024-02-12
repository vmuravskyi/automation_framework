package com.app.test.ui.tests;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import app.framework.base.DriverContext;
import app.framework.pages.HomePage;
import app.framework.pages.LoginPage;

public class LoginTest {

	public final String URL = "http://eaapp.somee.com/";
	public final String username = "Admin";
	public final String password = "password";

	@Before
	public void initialize() {
		var driverPath = "D:" + File.separator + "Dev" + File.separator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		DriverContext.driver = new ChromeDriver();
		DriverContext.driver.navigate().to(URL);
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

}
