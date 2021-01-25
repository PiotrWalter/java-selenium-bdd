Feature: Creating New account feature

  Scenario: Create new account using valid (unused) email and valid credentials
    Given Open login page
    When Create account using peterdoea23@gmail.com email
    When Create account using personal info: Peter Doe 123qwe Aleje Warsaw State 00000 123456799
    Then User is logged in

  Scenario Outline: Create new account using not valid credentials
    Given Open login page
    When Create account using <email> email
    When Create account using personal info: <First Name> <Last Name> <password> <Address> <City> <State> <Zip> <Mobile>
    Then User is logged in

    Examples:
      |First Name|Last Name|email               |password |Address |City  |State  |Zip  |Mobile   |
      |Dirk      |Ridick   |dirkr1231@gmail.com |2131231  |aaa     |Warsaw|Alabama|00000|12312313 |
