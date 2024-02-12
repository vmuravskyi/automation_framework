package app.framework.pages;

import org.openqa.selenium.By;

import app.framework.base.BasePage;

public class LoginPage extends BasePage {

	private final By txtUserName = By.xpath("//input[@id='UserName']");
	private final By txtUserPassword = By.xpath("//input[@id='Password']");
	private final By checkboxRememberMe = By.xpath("//input[@id='RememberMe']");
	private final By linkRegisterAsNewUser = By.xpath("//section[@id='loginForm']//a[@href='/Account/Register']");
	private final By btnLogin = By.xpath("//input[@type='submit']");

	public LoginPage() {
	}

	/**
	 * Log in user.
	 *
	 * @param username username
	 * @param password password
	 */
	public void login(String username, String password) {
		driver.findElement(txtUserName).sendKeys(username);
		driver.findElement(txtUserPassword).sendKeys(password);
		driver.findElement(btnLogin).submit();
	}

}
