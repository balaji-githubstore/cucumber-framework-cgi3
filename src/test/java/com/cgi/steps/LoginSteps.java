package com.cgi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	@Given("I have browser with orangehrm application")
	public void i_have_browser_with_orangehrm_application() {
	    System.out.println("given");
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
	    System.out.println("when");
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
	    
	}
	
	@When("I click on login")
	public void i_click_on_login() {
	    
	}
	
	@Then("I should get access to the portal with page content as {string}")
	public void i_should_get_access_to_the_portal_with_page_content_as(String expectedValue) {
	    System.out.println("then");
	}

}
