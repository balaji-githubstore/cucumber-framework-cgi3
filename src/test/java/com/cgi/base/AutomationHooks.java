package com.cgi.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationHooks {
	
	public static WebDriver driver;
	
	@After
	public void endScenario()
	{
		AutomationHooks.driver.quit();
	}
	
	

}
