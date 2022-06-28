Feature: Login
  In order to manage the employee records
  As a admin
  I want to access the Orange HRM Portal

  Scenario: Valid Credential
    Given I have browser with orangehrm application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    Then I should get access to the portal with page content as 'My Info'

  Scenario Outline: Invalid Credential1
    Given I have browser with orangehrm application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    Then I should get the error message as 'Invalid credentials'

    Examples: 
      | username | password |
      | bala     | bala123  |
      | peter    | peter123 |
      | mark     | mark123  |

      