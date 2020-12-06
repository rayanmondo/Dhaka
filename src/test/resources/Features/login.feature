Feature: Test login functionalies

  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enter email and click on continue button
    And user enter password and click on Sign-in button
    Then user is navigated to home page