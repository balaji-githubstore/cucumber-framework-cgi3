package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	
public class LoginPage {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.cssSelector("#txtPassword");
	private By loginLocator = By.xpath("//input[@id='btnLogin']");
	private By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	private By errorLocator = By.id("spanMessage");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public void clickOnLinkedinIcon() {
		driver.findElement(linkedinLocator).click();
	}

	public String getLoginErrorMessage() {
		String text = driver.findElement(errorLocator).getText();
		return text;
	}
}
