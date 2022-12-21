Feature: As a user, I want to create credentials

  @user-journey:Login-Positive
  Scenario Outline: Successful login using valid account
    Given Login form in login page
    When Submit email using "<email>" and password using "<password>"
    Then Success login to home page with displaying account button

    Examples:
    |         email          |  password   |
    | jsoldelvalle@gmail.com | bakira12345 |

  @user-journey:Fail-Login
  Scenario Outline: Failed login using invalid account
    Given Login form in login page
    When Submit email using "<email>" and password using "<password>"
    Then Login failed with displaying error message

    Examples:
      |         email       | password  |
      | failemail@gmail.com | fake12345 |