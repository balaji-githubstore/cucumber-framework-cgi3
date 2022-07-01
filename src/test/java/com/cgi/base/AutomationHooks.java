package com.cgi.base;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AutomationHooks {
	
	public WebDriver driver;
	public Scenario scenario;
	
	@Before
	public void startScenario(Scenario scenario)
	{
		this.scenario=scenario;
	}
	
	@After
	public void endScenario(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] byteData= ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(byteData, "image/png", "Error+ "+scenario.getName());
		}
		
		System.out.println(scenario.getName());
		System.out.println(scenario.isFailed());
		scenario.log("Scenario Completed"+LocalDateTime.now().toString());
		
		driver.quit();
	}
	
	

}
