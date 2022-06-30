package com.cgi.pages;

import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

public class LoginPage {
	private static By usernameLocator = By.id("txtUsername");
	private static By passwordLocator = By.cssSelector("#txtPassword");
	private static By loginLocator = By.xpath("//input[@id='btnLogin']");
	private static By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	private static By errorLocator=By.id("spanMessage");

	public static void enterUsername(String username) {
		AutomationHooks.driver.findElement(usernameLocator).sendKeys(username);
	}

	public static void enterPassword(String password) {
		AutomationHooks.driver.findElement(passwordLocator).sendKeys(password);
	}

	public static void clickOnLogin() {
		AutomationHooks.driver.findElement(loginLocator).click();
	}

	public static void clickOnLinkedinIcon() {
		AutomationHooks.driver.findElement(linkedinLocator).click();
	}

	public static String getLoginErrorMessage() {
		String text = AutomationHooks.driver.findElement(errorLocator).getText();
		return text;
	}
}
