@smokeTest
Feature: Verify login function in New Tours web application
  Scenario: Successfully login to new tours web application
    Given User go to New Tours home page q
    And User click on the user name field q
    When User type test username in username field q
    And User click on the password field q
    And User type test password in password field q
    Then User click on the loging button q
    And User verify the text "Login Successfully" q