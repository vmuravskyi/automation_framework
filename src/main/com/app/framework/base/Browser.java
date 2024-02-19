package com.app.framework.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Browser {

	public BrowserType browserType;
	private WebDriver driver;

	public Browser(WebDriver driver) {
		this.driver = driver;
	}

	public void goToUrl(String url) {
		driver.get(url);
	}

	public void setResolution() {
		driver.manage().window().setSize(new Dimension(1920, 1080));
	}

}

