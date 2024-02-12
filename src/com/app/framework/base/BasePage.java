package app.framework.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverContext.driver;
	}

}
