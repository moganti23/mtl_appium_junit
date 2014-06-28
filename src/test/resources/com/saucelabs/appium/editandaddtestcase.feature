@testcaseview
Feature: User can add and edit testcase

  Scenario: user can add a test case - happy path

    Given user is in test case page
    And adds a test cases
    When 'title' is set as 'Title'
    And select 'Tester one' in the 'owner' from drop down list
    And select 'low' in the 'priority' from drop down list
    And 'description' is set as 'Auto description'
    And 'test data' is set as 'Auto data'
    And 'test steps' is set as 'Auto Steps'
    And 'Expected Result' is set as 'Auto Expected Result'
    And click on save
    Then the success message is shown as dialog
    Then User should see 'Testcaseview' page.
    And the user clicks on 'Home' button
    And User clicks on Logout button
  And I close the message
