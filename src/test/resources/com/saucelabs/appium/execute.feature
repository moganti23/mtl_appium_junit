Feature: Execute test cases

  @new
  Scenario: User Can Update the 'Status' as pass by tapping on the 'Pass' and clicking 'Save' button

    Given user is in test case page
    And User has navigated to this Page in 'Execute' mode
    And User is on a Particular 'Title, Auto description' for which he wants to execute testcase
    When User enters the data in the 'Actual Results' field
    And User taps the 'Pass' button
    Then User should see the Status dropdown list with the value 'Pass'
    When User taps the 'Save' button
    Then User can see notification as 'Test Case Updated'
    And User should Navigate to the 'Test Case view' list Page
    And User can see the 'Status' field updated with 'Pass' for the test cases which was executed



  Scenario:  User Can Update the 'Status' as pass by tapping on the 'Fail' and clicking 'Save' button

    Given User is on a Particular 'Test Case View' for which he wants to execute testcase
    And User has navigated to this Page in 'Execute' mode
    When User enters the data in the 'Actual Results' field
    And User taps the 'Fail' button
    Then User should see the Status dropdown list with the value 'Fail'
    When User taps the 'Save' button
    Then User can see notification as 'Test Case Updated'
    And User should Navigate to the 'Test Case view' list Page
    And User can see the 'Status' field updated with 'Fail' for the test cases which was executed