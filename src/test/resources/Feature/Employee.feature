@employee
Feature: Employee
  In order to maintain the employees record
  As an Admin
  I would like create, edit, delete employee records

  Scenario: Add Employee
    Given I have browser with orangehrm application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    And I click on PIM
    And I click on Add Employee
    And I fill the employee details
      | firstname | middelname | lastname | employee_id | emp_image                            | check_create_credential | username | password    | confirm_password | status   |
      | john      | k          | ken      |      101454 | src/test/resources/Files/emp_101.PNG | true                    | john1267 | Welcome@123 | Welcome@123      | Disabled |
    And I click on save employee record
    Then I should get the added employee record under personal details

 