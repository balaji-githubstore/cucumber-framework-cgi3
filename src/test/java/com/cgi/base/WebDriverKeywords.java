package com.cgi.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverKeywords {

	protected WebDriver driver;

	public WebDriverKeywords(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsingLocator(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void clickUsingLocator(By locator) {
		driver.findElement(locator).click();
	}

}
