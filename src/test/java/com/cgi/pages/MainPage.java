package com.cgi.pages;

import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

public class MainPage {
	private static By myInfoLocator=By.partialLinkText("Info");
	
	public static void clickOnMyInfo()
	{
		AutomationHooks.driver.findElement(myInfoLocator).click();
	}
	
	public static String getMyInfoText()
	{
		return AutomationHooks.driver.findElement(myInfoLocator).getText();
	}

}
