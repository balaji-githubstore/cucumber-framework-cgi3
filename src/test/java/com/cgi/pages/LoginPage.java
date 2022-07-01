package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cgi.base.WebDriverKeywords;
	
public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.cssSelector("#txtPassword");
	private By loginLocator = By.xpath("//input[@id='btnLogin']");
	private By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	private By errorLocator = By.id("spanMessage");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	

	public void enterUsername(String username) {
		enterUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		enterUsingLocator(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickUsingLocator(loginLocator);
	}

	public void clickOnLinkedinIcon() {
		driver.findElement(linkedinLocator).click();
	}

	public String getLoginErrorMessage() {
		String text = driver.findElement(errorLocator).getText();
		return text;
	}
}
