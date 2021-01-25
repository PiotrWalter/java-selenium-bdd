Feature: Login features

  Scenario: Should login user using valid login and password
    Given Open login page
    When Login using waltertest@gmail.com email and 123^%$QAZwer password
    Then User is logged in

    Scenario Outline: Should show message when try to login using invalid credentials
      Given Open homepage
      When Login using <email> email and <password> password
      Then User in not logged in
      And Alert <expected alert> is visible
      Examples:
        |email                      |password     |expected alert|
        |waltertest@gmail.com       |             |Password is required.     |
        |                           |123^%$QAZwer |An email address required.|
        |waltertest@gmail.com       |wrong        |Invalid password.         |
        |wrong                      |aaaa         |Invalid email address.    |

    Scenario: Should log out when user is logged in and click log out button
      Given Open login page
      And Login using waltertest@gmail.com email and 123^%$QAZwer password
      When Logout button is clicked
      Then User in not logged in