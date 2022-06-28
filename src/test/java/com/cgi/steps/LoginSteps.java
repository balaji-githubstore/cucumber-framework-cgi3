package com.cgi.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;

	@Given("I have browser with orangehrm application")
	public void i_have_browser_with_orangehrm_application() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.name("Submit")).click();
	}

	@Then("I should get access to the portal with page content as {string}")
	public void i_should_get_access_to_the_portal_with_page_content_as(String expectedText) {
		
		String actualText=driver.findElement(By.partialLinkText("Info")).getText();
		Assert.assertEquals(expectedText,actualText);
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {

		String actualError= driver.findElement(By.id("spanMessage")).getText();
		
		Assert.assertEquals(expectedError, actualError);
	}

}
