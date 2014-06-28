Feature: Login Functionality for ios

  #As as User
  #I Login to App
  #So that I can see the Home Screen
  @manual
  Scenario: User should be able to enter data using alfanumeric keypad

    Given User is on Login Page
    And the Username and Password fields are empty
    And Cursor is at Username field
    When User taps in the Username field
    Then User should see the Alfanumeric Keypad along with 'Next' key
    When User enters Username as 'Validuser'
    Then User should see the 'Validuser' text in the username field
    When User taps on 'Next' key on Alfanumeric Keypad
    Then Cursor should be shifted to 'Password' field
    When User enters Password as 'ValidPass123'
    Then User Should see matching no of in Password textfield Password field should not display password
    And on the Keypad 'Next' key should be replaced by 'Done' key
    When User clicks on 'Done' key
  Then Focus should be set on Login button


  @manual
  Scenario: User should not be able to enter more than 50 characters in Username and Password field

    Given User is on Login page
    When  User enter 50 chars in username field
    Then all 50 characters should be dispalyed in the Username textfield
    When User tries to enter 51st character in the Username textfield
    Then User should not be able to enter any extra character
    When  User enter 50 chars in Password field
    Then all 50 characters should be dispalyed in the Passowrd textfield masked with
    When User tries to enter 51st character in the Passowrd textfield
    Then User should not be able to enter any extra character



  @login@manual
  Scenario Outline: User should not be able to login with invalid Username and Password

    Given User is on Login Page
    When User Enter '<Username>' in Username textfield
    When User Enter '<Password>' in Password textfield
    And User clicks on Login button
    Then '<ErrorMessage>' should be displayed
    When I close the message

  Examples:
    |Username         |Password|      ErrorMessage|
#    |Name|Pword|Not a valid user|
#    |$%$Name|Pword$%$%|Not a valid user|
#    | | |please enter valid Username and Passord|
#    |  |ValidPass@123|please enter valid Username|
#    |Validuser| |please enter valid Passord|
    |InValiduser| invalidpassword|Not a valid user|

  @login
  Scenario:Valid signed up user should be able to login and should see Home screen

    Given User is on Login Page
    When User Enter 'sri123' in Username textfield
    And User Enter 'Sri123' in Password textfield
    And User clicks on Login button
    Then User should see welcome message as 'Welcome sri123'
    And User clicks on Logout button
    And I close the message















