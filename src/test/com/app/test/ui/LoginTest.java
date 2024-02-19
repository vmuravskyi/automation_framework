package com.app.test.ui;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.framework.base.BrowserType;
import com.app.framework.base.DriverContext;
import com.app.framework.base.FrameworkInitialize;
import com.app.framework.pages.HomePage;
import com.app.framework.pages.LoginPage;
import com.app.framework.utilities.ExcelUtil;
import jxl.read.biff.BiffException;

public class LoginTest extends FrameworkInitialize {

	public final String URL = "http://eaapp.somee.com/";
	public final String username = "Admin";
	public final String password = "password";

	@Before
	public void initialize() {

		initializeBrowser(BrowserType.CHROME);
		DriverContext.browser.goToUrl(URL);
	}

	@After
	public void tearDown() {
		DriverContext.driver.close();
		DriverContext.driver.quit();
	}

	@Test
	public void xmlTest() throws BiffException, IOException {
		LOGGER.info("hello");
		ExcelUtil excelUtil = new ExcelUtil("C:\\Dev\\projects\\java\\automation_framework\\data.xls");
		var login = ExcelUtil.readCell("UserName", 1);
		var password = ExcelUtil.readCell("Password", 1);
		System.out.printf("login=%s, pass=%s%n", login, password);
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
