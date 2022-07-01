package com.cgi.pages;

import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

public class MyInfoPage {
	private static By personalDetailLocator=By.linkText("Personal Details");
	private static By emergencyContactLocator=By.linkText("Emergency Contacts");
	
	public static void clickOnPersonlDetails()
	{
		AutomationHooks.driver.findElement(personalDetailLocator).click();
	}

	public static void clickOnEmergencyContact()
	{
		AutomationHooks.driver.findElement(emergencyContactLocator).click();
	}

}
