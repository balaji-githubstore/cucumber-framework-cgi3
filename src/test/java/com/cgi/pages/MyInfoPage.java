package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage {
	private By personalDetailLocator = By.linkText("Personal Details");
	private By emergencyContactLocator = By.linkText("Emergency Contacts");

	private WebDriver driver;

	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPersonlDetails() {
		driver.findElement(personalDetailLocator).click();
	}

	public void clickOnEmergencyContact() {
		driver.findElement(emergencyContactLocator).click();
	}

}
