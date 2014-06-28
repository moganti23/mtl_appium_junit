Feature: Folder Navigation Functionality for IOS

#  As a User
#  I want to Navigate from Home Screen to List of testcase Page.
#  So that I can see the List of Testcases.

  @manual
  Scenario: User can see the highest level of folders by tapping 'open' button.
    Given User is in Home Page
    When the user taps on the 'Open' button
    Then the user should see the Page with the Highest Level of folders in a Tabular format
    And the page has the 'Home'  button
    And the table should have the title as 'Folders View'
    And there Should be atleast 1 folder level

  @manual
  Scenario: User should  navigate to the child folder from the highest level folder
    Given User is on the Folders View Page
    And the Folder should have a child folder with > symbol
    When the User taps on childfolder name
    Then the user should  see the child folders inside the highest level folder
    And User should see 'Home' and 'Back' buttons.

  @manual
  Scenario: User should see the Breadcrumbs on the top of the folder view page
    Given User is in Folders View Page
    And the folder  have a child folder with > symbol
    And the Child folder should have another level of child folder
    When the User taps on the folder name in folders view page
    Then the User should see the child folders
    And On the top of the Page the user should see the breadcrumbs like Root>Level one folder
    When the USer taps on the child folders name in subfolders page
    Then the user should see the next child folder of level one folder
    And on the top of the page the user should see the breadcrumbs like Root>Level one folder>Level two one folder

  @manual
  Scenario: User should see the List of Test Cases Page at the last level of the folder
    Given User is in the Folders View Page
    And the Folder contains Child folders with >symbol
    When the User taps on the foldername in the folders view page
    Then the user should see the child folder with > symbol
    When the user taps on the child foldername
    Then user should see the 'Test Cases View Page'
    And the Test Cases View Page should display the Header as "Test Cases View"

  @manual
  Scenario: User should navigate to the Home Page on clicking the 'Home' button
    Given User is on the Folders View Page
    When the user taps on the 'Home' button
    Then the user should navigate to the home page


  @manual
  Scenario: User should navigate to the Home Page on clicking the 'Home' button
    Given User is on the subFolders View Page
    When the user taps on the 'Home' button
    Then the user should navigate to the home page


  @manual
  Scenario: User should navigate to the Previous screen on clicking the 'Back' button
    Given User is on the subFolders View Page
    When the user taps on the 'Back' button
    Then the user should navigate to the 'folder's view page'

  @manual
  Scenario: User should see the Vertical Scroll bars and scroll about when the folders exceed the screen
    Given User is on the Folders View Page
    And there are more no. of folders exceeding the screen size
    Then the user should see the Vertical Scroll bars
    When the user scrolls on the Vertical scroll bar
    Then the user should be able to scroll through the screens

#  @manual
#  Scenario Outline: User should see the dots(....) when the folders name exceed the size of the screen
#    Given User is on the Folders View Page
#    And a folder name is given long with 50 characters
#    Then the user should see the '.....' after the folder name
#
#  Examples:
#    |  folder name  | view  |
##    |  Functional testcase | Functional testcase|   									// display without ... as it fits the screen
#    | Non-Functional High Priority test cases created for the month of April |   Non-Functional High Priori...... |         // display the name with .... as it does not fit in the screen

@folder1
  Scenario: User can navigate to a level of maximum depth of 5
    Given User is on the Folders View Page
    When the user clicks on the all folders
     |Non functional|
     |Installation1|
#     |Level 3 Folder 1|
#     |Level 4 Folder 1|
#     |Level 5 Folder 1|
    Then User should see 'Testcaseview' page.
  When the user clicks on 'Home' button
  And User clicks on Logout button
  And I close the message



  @folder
  Scenario: User should come back to the same Page when the 'Home' button in the device is pressed
    Given User is on the Folders View Page
    When taps on the Folder name with 'Non functional'
    When the user clicks on 'Home' button
    Then User should see welcome message as 'Welcome sri123'
    And User clicks on Logout button
    And I close the message








