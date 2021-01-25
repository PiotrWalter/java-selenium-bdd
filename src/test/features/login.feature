Feature: Login features
  Scenario: Should login user using valid login and password
    Given Open login page
    When Login using piotrwaltrowski@gmail.com email and XJvF2@s3GeLx9L@ password
    Then User is logged in

  Scenario: Should show message when try to login when logged in
    Given Open login page
    When Login using piotrwaltrowski@gmail.com email and XJvF2@s3GeLx9L@ password
    Then User is logged in


    Scenario Outline: Should show message when try to login using invalid credentials
      Given Open homepage
      When Login using <email> email and <password> password
      Then User in not logged in
      And Alert <expected alert> is visible
      Examples:
        |email                      |password|expected alert|
        |piotrwaltrowski@gmail.com  |        |Password is required.     |
        |                           |123qwe  |An email address required.|

