package com.cgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmergencyContactPage {
	private By addEmergencyContactLocator = By.id("btnAddContact");

	private By contactNameLocator = By.id("emgcontacts_name");
	private By relationshipLocator = By.id("emgcontacts_relationship");
	private By homeTeleLocator = By.name("emgcontacts[homePhone]");
	private By mobileLocator = By.name("emgcontacts[mobilePhone]");
	private By workTeleLocator = By.name("emgcontacts[workPhone]");
	private By saveLocator = By.id("btnSaveEContact");

	private By tableLocator = By.xpath("//table[@id='emgcontact_list']");

	private WebDriver driver;

	public EmergencyContactPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddEmergencyContact() {
		driver.findElement(addEmergencyContactLocator).click();
	}

	public void enterContactName(String contactName) {
		driver.findElement(contactNameLocator).sendKeys(contactName);
	}

	public void enterRelationship(String relationship) {
		driver.findElement(relationshipLocator).sendKeys(relationship);
	}

	public void enterHomeTelephone(String homeTelephone) {
		driver.findElement(homeTeleLocator).sendKeys(homeTelephone);
	}

	public void enterMobile(String mobile) {
		driver.findElement(mobileLocator).sendKeys(mobile);
	}

	public void enterWorkTelephone(String workTelephone) {
		driver.findElement(workTeleLocator).sendKeys(workTelephone);
	}

	public void saveEmergencyContact() {
		driver.findElement(saveLocator).click();
	}

	public String getTableRecords() {
		return driver.findElement(tableLocator).getText();
	}
}
