package com.cgi.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;
import com.cgi.pages.EmergencyContactPage;
import com.cgi.pages.MainPage;
import com.cgi.pages.MyInfoPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmergencyContactsSteps {
	
	private static DataTable emergencyContact_dt;

	@When("I click on My Info")
	public void i_click_on_my_info() {
		MainPage.clickOnMyInfo();
	}

	@When("I click on Emergency Contact")
	public void i_click_on_emergency_contact() {
		MyInfoPage.clickOnEmergencyContact();
	}

	@When("I click on add emergency contact")
	public void i_click_on_add_emergency_contact() {
		EmergencyContactPage.clickOnAddEmergencyContact();
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

		EmergencyContactPage.enterContactName(contactName);
		EmergencyContactPage.enterRelationship(relationship);
		EmergencyContactPage.enterHomeTelephone(list.get(0).get("hometelephone"));
		EmergencyContactPage.enterMobile(list.get(0).get("mobile"));
		EmergencyContactPage.enterWorkTelephone(list.get(0).get("worktelephone"));

	}

	@When("I click on save")
	public void i_click_on_save() {
		EmergencyContactPage.saveEmergencyContact();
	}

	@Then("I should get the added recorded")
	public void i_should_get_the_added_recorded() {
		
		//expected contact details
		List<Map<String, String>> list = emergencyContact_dt.asMaps();
		String cName=list.get(0).get("contactname");

		//actual table record in webpage
		String actualValue=EmergencyContactPage.getTableRecords();
	
		Assert.assertTrue(actualValue.contains(cName)); //it should be true
		Assert.assertTrue(actualValue.contains(list.get(0).get("relationship")));
		Assert.assertTrue("Assertion on home telephone name",actualValue.contains(list.get(0).get("hometelephone")));
	}

}
