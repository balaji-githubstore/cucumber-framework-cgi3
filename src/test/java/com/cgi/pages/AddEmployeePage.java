package com.cgi.pages;

import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

public class AddEmployeePage {
	private static By firstnameLocator = By.id("firstName");
	private static By createLoginLocator=By.id("chkLogin");
	
	public static void enterFirstName(String firstname)
	{
		AutomationHooks.driver.findElement(firstnameLocator).sendKeys(firstname);
	}
	
	public static void checkCreateLoginDetail()
	{
		if(!AutomationHooks.driver.findElement(createLoginLocator).isSelected())
		{
			AutomationHooks.driver.findElement(createLoginLocator).click();
		}
	}
	
	public static void unCheckCreateLoginDetail()
	{
		if(AutomationHooks.driver.findElement(createLoginLocator).isSelected())
		{
			AutomationHooks.driver.findElement(createLoginLocator).click();
		}
	}

}
