package com.app.test.ui;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.framework.base.DriverContext;
import com.app.framework.base.FrameworkInitialize;
import com.app.framework.config.ConfigReader;
import com.app.framework.config.Settings;
import com.app.framework.pages.HomePage;
import com.app.framework.pages.LoginPage;
import com.app.framework.utilities.ExcelUtil;

import jxl.read.biff.BiffException;

public class LoginTest extends FrameworkInitialize {

	public String username;
	public String password;
	
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
	public void xmlTest() throws BiffException, IOException {
		ExcelUtil excelUtil = new ExcelUtil(Settings.EXCEL_SHEET_PATH);
		username = ExcelUtil.readCell("UserName", 1);
		password = ExcelUtil.readCell("Password", 1);
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
