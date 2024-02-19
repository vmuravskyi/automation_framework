package com.app.framework.pages;

import org.openqa.selenium.By;

import com.app.framework.base.BasePage;

public class HomePage extends BasePage {

	private final By lnkLogin = By.xpath("//a[@id='loginLink']");
	private final By lnkHome = By.xpath("//a[text()='Home']");
	private final By lnkAbout = By.xpath("//a[text()='About']");
	private final By lnkEmployeeList = By.xpath("//a[text()='Employee List']");

	public HomePage() {
	}

	public void clickLogin() {
		driver.findElement(lnkLogin).click();
	}

}
