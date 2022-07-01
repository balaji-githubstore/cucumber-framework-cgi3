package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cgi.base.AutomationHooks;

public class MainPage {
	private By myInfoLocator=By.partialLinkText("Info");
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void clickOnMyInfo()
	{
		driver.findElement(myInfoLocator).click();
	}
	
	public String getMyInfoText()
	{
		return driver.findElement(myInfoLocator).getText();
	}
	
	//clickOnPIM()
	//clickOnAddEmployee()

}
