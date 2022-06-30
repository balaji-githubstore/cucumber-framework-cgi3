package com.cgi.steps;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.cgi.base.AutomationHooks;
import com.cgi.pages.AddEmployeePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeeSteps {
	
	private static DataTable employee_dt;

	@When("I click on PIM")
	public void i_click_on_pim() {
		AutomationHooks.driver.findElement(By.linkText("PIM")).click();
	}

	@When("I click on Add Employee")
	public void i_click_on_add_employee() {
		AutomationHooks.driver.findElement(By.linkText("Add Employee")).click();
	}

	@When("I fill the employee details")
	public void i_fill_the_employee_details(DataTable dataTable) {
		
		employee_dt=dataTable;
		List<Map<String, String>> list= dataTable.asMaps();
		
		String firstName=list.get(0).get("firstname");
		String middleName=list.get(0).get("middelname");
		String lastName=list.get(0).get("lastname");
		String employee_id=list.get(0).get("employee_id");
		String employeeImageRel=list.get(0).get("emp_image");
		String checkCreateCredential=list.get(0).get("check_create_credential");
		String username=list.get(0).get("username");
		String password=list.get(0).get("password");
		String confirmPassword=list.get(0).get("confirm_password");
		String status=list.get(0).get("status");

		AddEmployeePage.enterFirstName(firstName);
		AutomationHooks.driver.findElement(By.id("middleName")).sendKeys(middleName);
		AutomationHooks.driver.findElement(By.id("lastName")).sendKeys(lastName);
		AutomationHooks.driver.findElement(By.id("employeeId")).clear();
		AutomationHooks.driver.findElement(By.id("employeeId")).sendKeys(employee_id);
		
		
		//get the absolute path for image 
		File file=new File(employeeImageRel);
		String employeeImageAbs=file.getAbsolutePath();
		
//		String path=System.getProperty("user.dir");
//		path=path+employeeImageRel;

		//AutomationHooks.driver.findElement(By.id("photofile")).sendKeys("D:\\CSS Assessment 1.PNG");
		AutomationHooks.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(employeeImageAbs);
		
		//check if true
		if(checkCreateCredential.equalsIgnoreCase("true"))
		{
			AddEmployeePage.checkCreateLoginDetail();
		}
		else
		{
			AddEmployeePage.unCheckCreateLoginDetail();
		}
		
		AutomationHooks.driver.findElement(By.id("user_name")).sendKeys(username);
		AutomationHooks.driver.findElement(By.id("user_password")).sendKeys(password);
		AutomationHooks.driver.findElement(By.id("re_password")).sendKeys(confirmPassword);
		
		
		Select selectStatus=new Select(AutomationHooks.driver.findElement(By.id("status")));
		selectStatus.selectByVisibleText(status);
	}

	@When("I click on save employee record")
	public void i_click_on_save_employee_record() {
		AutomationHooks.driver.findElement(By.id("btnSave")).click();
	}

	@Then("I should get the added employee record under personal details")
	public void i_should_get_the_added_employee_record_under_personal_details() {
		
		List<Map<String, String>> list= employee_dt.asMaps();
		
		String firstName=list.get(0).get("firstname");
		String middleName=list.get(0).get("middelname");
		String lastName=list.get(0).get("lastname");
		String employee_id=list.get(0).get("employee_id");
		String employeeImageRel=list.get(0).get("emp_image");
		String checkCreateCredential=list.get(0).get("check_create_credential");
		String username=list.get(0).get("username");
		String password=list.get(0).get("password");
		String confirmPassword=list.get(0).get("confirm_password");
		String status=list.get(0).get("status");
		
		String actualFirstName=AutomationHooks.driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
		String actualEmployeeId=AutomationHooks.driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		Assert.assertEquals(firstName, actualFirstName);
		Assert.assertEquals(employee_id, actualEmployeeId);
	}

}
