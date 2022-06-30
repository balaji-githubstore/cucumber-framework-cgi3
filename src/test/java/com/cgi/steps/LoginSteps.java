package com.cgi.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cgi.base.AutomationHooks;
import com.cgi.pages.LoginPage;
import com.cgi.pages.MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	@Given("I have browser with orangehrm application")
	public void i_have_browser_with_orangehrm_application() {

		WebDriverManager.chromedriver().setup();

		AutomationHooks.driver = new ChromeDriver();
		AutomationHooks.driver.manage().window().maximize();
		AutomationHooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AutomationHooks.driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		LoginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		LoginPage.enterPassword(password);
	}

	@When("I click on login")
	public void i_click_on_login() {
		LoginPage.clickOnLogin();
	}

	@Then("I should get access to the portal with page content as {string}")
	public void i_should_get_access_to_the_portal_with_page_content_as(String expectedText) {

		String actualText = MainPage.getMyInfoText();
		Assert.assertEquals(expectedText, actualText);
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {

		String actualError = LoginPage.getLoginErrorMessage();
		Assert.assertEquals(expectedError, actualError);
	}

}
