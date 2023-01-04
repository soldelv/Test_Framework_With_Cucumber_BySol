Feature: As a user, I want to create a new account

  @user-journey:Register-Positive
  Scenario Outline: Successful user register
    Given Register form after login page
    When The form is completed using email "<email>" and password "<password>"
    Then Success register for user
    Then Deletion of account recently registered

    Examples:
      |         email          |  password   |
      | teste20230104@gmail.com | fakepassword1234 |