package com.cgi.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmergencyContactsSteps {
	
	private static DataTable emergencyContact_dt;

	@When("I click on My Info")
	public void i_click_on_my_info() {

		AutomationHooks.driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}

	@When("I click on Emergency Contact")
	public void i_click_on_emergency_contact() {
		AutomationHooks.driver.findElement(By.linkText("Emergency Contacts")).click();
	}

	@When("I click on add emergency contact")
	public void i_click_on_add_emergency_contact() {
		AutomationHooks.driver.findElement(By.id("btnAddContact")).click();
	}

	@When("I fill the form")
	public void i_fill_the_form(DataTable dataTable) {
		
		emergencyContact_dt=dataTable;
		List<Map<String, String>> list = dataTable.asMaps();
		System.out.println(list);

//		System.out.println(list.get(0).get("contactname"));
//		System.out.println(list.get(0).get("relationship"));

		String contactName = list.get(0).get("contactname");
		String relationship = list.get(0).get("relationship");

		AutomationHooks.driver.findElement(By.id("emgcontacts_name")).sendKeys(contactName);
		AutomationHooks.driver.findElement(By.id("emgcontacts_relationship")).sendKeys(relationship);
		AutomationHooks.driver.findElement(By.name("emgcontacts[homePhone]")).sendKeys(list.get(0).get("hometelephone"));
		AutomationHooks.driver.findElement(By.name("emgcontacts[mobilePhone]")).sendKeys(list.get(0).get("mobile"));
		AutomationHooks.driver.findElement(By.name("emgcontacts[workPhone]")).sendKeys(list.get(0).get("worktelephone"));
		// fill mobile
		// fill worktelephone
	}

	@When("I click on save")
	public void i_click_on_save() {
		AutomationHooks.driver.findElement(By.id("btnSaveEContact")).click();
	}

	@Then("I should get the added recorded")
	public void i_should_get_the_added_recorded() {
		
		//expected contact details
		List<Map<String, String>> list = emergencyContact_dt.asMaps();
		String cName=list.get(0).get("contactname");

		//actual table record in webpage
		String actualValue=AutomationHooks.driver.findElement(By.xpath("//table[@id='emgcontact_list']")).getText();
	
		Assert.assertTrue(actualValue.contains(cName)); //it should be true
		Assert.assertTrue(actualValue.contains(list.get(0).get("relationship")));
		Assert.assertTrue("Assertion on home telephone name",actualValue.contains(list.get(0).get("hometelephone")));
	}

}
