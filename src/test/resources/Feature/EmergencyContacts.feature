@emergencycontact
Feature: Emergency Contact
  In order to maintain the emergency contact
  As as admin
  I want to modify the emergency contact details

  @addemergencycontact
  Scenario: Add Emergency Contact
    Given I have browser with orangehrm application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    And I click on My Info
    And I click on Emergency Contact
    And I click on add emergency contact
    And I fill the form
      | contactname | relationship | hometelephone | mobile    | worktelephone |
      | sat         | brother      |      78787887 | 875455454 |        545454 |
    And I click on save
    Then I should get the added recorded

