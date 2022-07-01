package com.cgi.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cgi.base.AutomationHooks;
import com.cgi.base.HelloDemo;
import com.cgi.pages.LoginPage;
import com.cgi.pages.MainPage;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	private LoginPage loginPage;
	private MainPage mainPage;
	private AutomationHooks hooks;
	private Scenario scenario;
	
	public LoginSteps(AutomationHooks hooks)
	{
		this.hooks=hooks;
	}

	@Given("I have browser with orangehrm application")
	public void i_have_browser_with_orangehrm_application() {

		WebDriverManager.chromedriver().setup();

		hooks.driver = new ChromeDriver();
		hooks.driver.manage().window().maximize();
		hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hooks.driver.get("https://opensource-demo.orangehrmlive.com/");

		// create object for page object class
		initializePageObjects();
	}

	public void initializePageObjects() {
		loginPage = new LoginPage(hooks.driver);
		mainPage = new MainPage(hooks.driver);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {

		loginPage.enterUsername(username);
		hooks.scenario.log("Entered Username as "+username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickOnLogin();
	}

	@Then("I should get access to the portal with page content as {string}")
	public void i_should_get_access_to_the_portal_with_page_content_as(String expectedText) {

		String actualText = mainPage.getMyInfoText();
		Assert.assertEquals(expectedText, actualText);
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {

		String actualError = loginPage.getLoginErrorMessage();
		hooks.scenario.log("Actual error message  "+actualError);
		
		Assert.assertEquals(expectedError, actualError);
		
	}

}
