Feature: Login Page

  Scenario Outline: User is able to login with valid credentials
    Given User is on the signup page
    When User enters "<username>" in the name input field
    And User enters "<password>" in the password input field
    And User clicks on the login button
    Then User navigate to the homepage

    Examples:
    | username| password |
    | Arun    | arun123  |
