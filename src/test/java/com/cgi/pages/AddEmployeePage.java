package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddEmployeePage {
	private By firstnameLocator = By.id("firstName");
	private By createLoginLocator=By.id("chkLogin");
	
	private WebDriver driver;
	
	public AddEmployeePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void enterFirstName(String firstname)
	{
		driver.findElement(firstnameLocator).sendKeys(firstname);
	}
	
	public void checkCreateLoginDetail()
	{
		if(!driver.findElement(createLoginLocator).isSelected())
		{
			driver.findElement(createLoginLocator).click();
		}
	}
	
	public void unCheckCreateLoginDetail()
	{
		if(driver.findElement(createLoginLocator).isSelected())
		{
			driver.findElement(createLoginLocator).click();
		}
	}

}
