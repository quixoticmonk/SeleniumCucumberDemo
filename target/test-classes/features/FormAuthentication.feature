
Feature:
  Background:
  Scenario: Validate the Status Code page
    Given I am on the url "login"
    When I enter "tomsmith" for the field "UserName"
    And I enter "SuperSecretPassword!" for the field "Password"
    And I select the "Login" button
    Then I see the message "Welcome to the Secure Area. When you are done click logout below."