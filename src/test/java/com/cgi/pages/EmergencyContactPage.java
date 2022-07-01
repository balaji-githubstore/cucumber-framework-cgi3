package com.cgi.pages;

import org.openqa.selenium.By;

import com.cgi.base.AutomationHooks;

public class EmergencyContactPage {
	private static By addEmergencyContactLocator = By.id("btnAddContact");

	private static By contactNameLocator = By.id("emgcontacts_name");
	private static By relationshipLocator = By.id("emgcontacts_relationship");
	private static By homeTeleLocator = By.name("emgcontacts[homePhone]");
	private static By mobileLocator = By.name("emgcontacts[mobilePhone]");
	private static By workTeleLocator = By.name("emgcontacts[workPhone]");
	private static By saveLocator = By.id("btnSaveEContact");

	private static By tableLocator = By.xpath("//table[@id='emgcontact_list']");

	public static void clickOnAddEmergencyContact() {
		AutomationHooks.driver.findElement(addEmergencyContactLocator).click();
	}

	public static void enterContactName(String contactName) {
		AutomationHooks.driver.findElement(contactNameLocator).sendKeys(contactName);
	}

	public static void enterRelationship(String relationship) {
		AutomationHooks.driver.findElement(relationshipLocator).sendKeys(relationship);
	}

	public static void enterHomeTelephone(String homeTelephone) {
		AutomationHooks.driver.findElement(homeTeleLocator).sendKeys(homeTelephone);
	}

	public static void enterMobile(String mobile) {
		AutomationHooks.driver.findElement(mobileLocator).sendKeys(mobile);
	}

	public static void enterWorkTelephone(String workTelephone) {
		AutomationHooks.driver.findElement(workTeleLocator).sendKeys(workTelephone);
	}

	public static void saveEmergencyContact() {
		AutomationHooks.driver.findElement(saveLocator).click();
	}

	public static String getTableRecords() {
		return AutomationHooks.driver.findElement(tableLocator).getText();
	}
}
